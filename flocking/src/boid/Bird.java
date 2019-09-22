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
 * 	ok	bool movement();				//update the birds position to the next frame
 * 	ok	seeBoid(boid other);			//how to tell a boid about other boids
 * 										//this triggers all different rules
 * 	ok	behavior();						//finish all the calculations
 * 										//this finishes the calculation for all the rules
 * 			other general functions are described in boid interface		
 * 
 * 		//rule functions
 * 			//alignment
 * 	ok			Vector alignment;
 * 	ok			int alignmentCount
 * 	ok			void align(boid other);		//add a boids velocity vector the alignment vector
 * 	un			void align();				//finish the calculation and add it to the acceleration
 * 			//Cohesion
 * 	ok			Vector cohesion;
 * 	ok			int cohesionCount
 * 	ok			void cohesion(boid other);		//add a boids velocity vector the cohesion vector
 * 	un			void cohesion();				//finish the calculation and add it to the acceleration
 *			//Separation
 *	ok			Vector separation;
 * 	ok			int seperationCount
 * 	un			void cohesion(boid other);		//add a boids velocity vector the separation vector
 * 	un			void cohesion();				//finish the calculation and add it to the acceleration
 *			
 * 		
 * }
 */

public class Bird implements Boid {
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
		//update the velocity with the acceleration
		velocity.add(acceleration);
		
		//update the position with the velocity
		position.add(velocity);
		
		
		//needed limit max speed
		//needed rollover world edge
		
		return true;
	}

	public void seeBoid(Boid other) {
		
		this.align((Bird)other);
		this.cohesion((Bird)other);
		this.separation((Bird)other);
		
	}
	

	public boolean behaviour() {
		
		acceleration.setxComponent(0);
		acceleration.setyComponent(0);
		
		this.align();
		this.cohesion();
		this.separation();
		
		acceleration.add(alignment);
		acceleration.add(cohesion);
		//acceleration.add(separation);
		alignment.setxComponent(0);
		alignment.setyComponent(0);
		cohesion.setxComponent(0);
		cohesion.setyComponent(0);
		return false;
	}
	
	//alignment
	void align(Bird other) {
		alignment.add(other.velocity);
		alignmentCount+=1;
	}
	void align() {
		if(alignmentCount>0) {
			alignment.divide(alignmentCount);
			alignment = Vector.subtract(velocity, alignment);
		}
		
	}
	//cohesion
	void cohesion(Bird other) {
		this.cohesion.add(other.position);
		this.cohesionCount+=1;
	}
	void cohesion() {
		if(cohesionCount>0) {
			cohesion.divide(cohesionCount);
			cohesion = Vector.subtract(cohesion, position);
		}
		
	}
	
	void separation(Bird other) {
		Vector force = Vector.subtract(this.position,other.position);
		
		this.separation.add(force);
		this.separationCount+=1;
	}
	void separation() {
		if(separationCount>0) {
			separation.divide(separationCount);
		}
		//cohesion = Vector.subtract(cohesion, position);
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
	
	//alignment
	
}
