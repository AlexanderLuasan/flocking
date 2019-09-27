package boid;

import vector.Vector;

/*
 * class Bird{
 * 	  variables
 * 		Vector position the boids position
 * 		Vector velocity the boids velocity
 * 		Vector acceleration the acceleration of the boid
 * 
 * 	ok	Bird(int x,int y,vector vel);	//position x and y and initial velocity
 * 	ok	bool movement();				//update the birds position to the next frame //---- missing
 * 	ok	seeBoid(boid other);			//how to tell a boid about other boids
 * 										//this triggers all different rules
 * 	ok 	preBehavior();					//set rule calulations to zero and reset counts
 * 	ok	behavior();						//finish all the calculations
 * 										//this finishes the calculation for all the rules active on the bird scales them
 * 										//and add them to the acceleration vector
 * 			
 * 
 * 		//rule functions
 * 
 * 		//alignment
 * 	ok	Vector alignment;
 * 	ok	int alignmentCount
 * 	ok	void align(boid other);			//add a boids velocity vector the alignment vector my velocity to avg other velocity
 * 	un	void align();					//finish the calculation 
 * 		//Cohesion
 * 	ok	Vector cohesion;
 * 	ok	int cohesionCount
 * 	ok	void cohesion(boid other);		//my position to avg position of other points
 * 	ok	void cohesion();				//finish the calculation 
 *		//Separation
 *	ok	Vector separation;
 * 	ok	int seperationCount
 * 	ok	void cohesion(boid other);		//avg of each boid position to mine scaled by distastance 1/d
 * 	ok	void cohesion();				//finish the calculation
 *			
 * 		
 * }
 */

public class Bird implements Boid {
	//
	private static final int MAX_ACCELERATION = 10;
	private static final int MAX_SPEED = 20;
	
	private Vector position;
	private Vector velocity;
	private Vector acceleration;
	
	//rule vectors
	private Vector alignment=new Vector(0,0);
	private int alignmentCount=0;
	private Vector separation=new Vector(0,0);
	private int separationCount=0;
	private Vector cohesion=new Vector(0,0);
	private int cohesionCount=0;

	public Bird(int x, int y, Vector vel) {
		position = new Vector((double)x,(double)y);
		velocity = vel;
		acceleration = new Vector(0,0);
	}
	
	public boolean movement() {
		//needed limit max acceleration
		this.acceleration.limit(0,this.MAX_ACCELERATION);
		//update the velocity with the acceleration
		this.velocity.add(this.acceleration);
		//needed limit max speed
		this.velocity.limit(0, this.MAX_SPEED);
		//update the position with the velocity
		this.position.add(this.velocity);
		//needed rollover world edge
		return true;
	}

	public void seeBoid(Boid other) {
		
		this.align((Bird)other);
		this.cohesion((Bird)other);
		this.separation((Bird)other);
		
	}
	
	public boolean preBehavior() {
		//reset all vectors and counts for next frame
		this.alignment.setxComponent(0);
		this.alignment.setyComponent(0);
		this.cohesion.setxComponent(0);
		this.cohesion.setyComponent(0);
		this.separation.setxComponent(0);
		this.separation.setyComponent(0);
		this.separationCount=0;
		this.alignmentCount=0;
		this.cohesionCount=0;
		return false;
	}
	public boolean behaviour() {
		//zero the acceleration
		this.acceleration.setxComponent(0);
		this.acceleration.setyComponent(0);
		
		//Calculate the final vectors
		this.align();
		this.cohesion();
		this.separation();
		
		//add them to the acceleration
		this.acceleration.add(alignment);
		this.acceleration.add(cohesion);
		this.acceleration.add(separation);
		
		
		
		return false;
	}
	
	//alignment
	void align(Bird other) {
		//sum velocities
		alignment.add(other.velocity);
		alignmentCount+=1;
	}
	void align() {
		if(alignmentCount>0) {//divide to get the avg
			alignment.divide(alignmentCount);
			//create vector from my velocity to the target
			alignment = Vector.subtract(this.velocity, alignment);
			
		}
		
	}
	//cohesion
	void cohesion(Bird other) {
		//sum positions
		this.cohesion.add(other.position);
		this.cohesionCount+=1;
	}
	void cohesion() {
		if(cohesionCount>0) {
			//average positions
			cohesion.divide(cohesionCount);
			//get the vector from my position to the other
			cohesion = Vector.subtract(cohesion, position);
		}
		
	}
	
	void separation(Bird other) {
		//vector pointed from them to me
		Vector force = Vector.subtract(this.position,other.position);
		//weaken vector based on distance
		force.divide(force.getLength()*force.getLength());
		//sum the vectors
		this.separation.add(force);
		this.separationCount+=1;
	}
	void separation() {
		if(separationCount>0) {
			//avg the vector
			separation.divide(separationCount);
		}
	}
	
	
	@Override
	public Vector getVelocityVector() {
		return velocity;
	}

	@Override
	public Vector getPositionVector() {
		return position;
	}



	protected Vector getPosition() {
		return position;
	}

	protected void setPosition(Vector position) {
		this.position = position;
	}

	protected Vector getVelocity() {
		return velocity;
	}

	protected void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	@Override
	public String toString() {
		return "Bird [position=" + position + ", velocity=" + velocity + "]";
	}

	protected Vector getAcceleration() {
		return acceleration;
	}

	protected void setAcceleration(Vector acceleration) {
		this.acceleration = acceleration;
	}
}
