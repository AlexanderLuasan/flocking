package boid;

import java.util.ArrayList;

import vector.Vector;

/*
 * class Bird{
 * 	  variables
 * 		Vector position 	// the boids position
 * 		Vector velocity 	//the boids velocity
 * 		Vector acceleration //the acceleration of the boid
 * 				//all have get
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
	protected static final double MAX_ACCELERATION = .1;
	protected static final double MAX_SPEED = 5;
	protected static final double MIN_SPEED = 2;
	protected static final double SIGHT_RANGE = 75;
	protected static final double ALIGNMENT_WEIGHT = 1;
	protected static final double SEPARATION_WEIGHT = 1.3;
	protected static final double COHESION_WEIGHT = 1;
	
	private static final ArrayList<Bird> ALL_BIRDS = new ArrayList<Bird>();
	protected Vector position;
	protected Vector velocity;
	protected Vector acceleration;
	
	private ArrayList<Vector> drawLines = new ArrayList<Vector>();
	
	//rule vectors
	protected Vector alignment=new Vector(0,0);
	protected int alignmentCount=0;
	protected Vector separation=new Vector(0,0);
	protected int separationCount=0;
	protected Vector cohesion=new Vector(0,0);
	protected int cohesionCount=0;

	public Bird(int x, int y, Vector vel) {
		position = new Vector((double)x,(double)y);
		velocity = vel;
		acceleration = new Vector(0,0);
		for(int i=0;i<4;i++) {
			drawLines.add(new Vector(0,0));
		}
		ALL_BIRDS.add(this);
	}
	public boolean remove() {
		ALL_BIRDS.remove(this);
		return false;	
	}
	
	public boolean movement() {
		//needed limit max acceleration
		this.acceleration.limit(0,getMAX_ACCELERATION());
		//update the velocity with the acceleration
		this.velocity.add(this.acceleration);
		//needed limit max speed
		this.velocity.limit(getMIN_SPEED(), getMAX_SPEED());
		//update the position with the velocity
		this.position.add(this.velocity);
		//needed rollover world edge
		if(this.position.getxComponent()<0) {
			this.position.setxComponent(this.position.getxComponent()+utils.Utils.SCREEN_WIDTH);
		}else if(this.position.getxComponent()>utils.Utils.SCREEN_WIDTH) {
			this.position.setxComponent(this.position.getxComponent()-utils.Utils.SCREEN_WIDTH);
		}
		if(this.position.getyComponent()<0) {
			this.position.setyComponent(this.position.getyComponent()+utils.Utils.SCREEN_HIEGHT);
		}else if(this.position.getyComponent()>utils.Utils.SCREEN_HIEGHT) {
			this.position.setyComponent(this.position.getyComponent()-utils.Utils.SCREEN_HIEGHT);
		}
		
		//update the image
		updateDrawLines();
		return true;
	}

	public void seeBoid(Boid other) {
		
		this.align((Bird)other);
		this.cohesion((Bird)other);
		this.separation((Bird)other);
		
	}
	
	public boolean preBehaviour() {
		//reset all vectors and counts for next frame
		this.alignment.setZero();
		this.cohesion.setZero();
		this.separation.setZero();
		this.separationCount=0;
		this.alignmentCount=0;
		this.cohesionCount=0;
		return false;
	}
	public boolean behaviour() {
		//zero the acceleration
		this.acceleration.setComponents(0, 0);
		
		//Calculate the final vectors
		this.align();
		this.cohesion();
		this.separation();
		//scale forces
		
		if(alignmentCount>0) {
			alignment.scale(getALIGNMENT_WEIGHT());
		}
		if(cohesionCount>0) {
			cohesion.scale(getCOHESION_WEIGHT());
		}
		if(separationCount>0) {
			separation.scale(getSEPARATION_WEIGHT());
		}
		
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
			alignment = Vector.subtract(alignment,this.velocity);
			
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
		return this.velocity;
	}

	@Override
	public Vector getPositionVector() {
		return this.position;
	}

	public Vector getAcceleration() {
		return this.acceleration;
	}

	@Override
	public String toString() {
		return "Bird [position=" + position + ", velocity=" + velocity + "]";
	}

	@Override
	public double sightRange() {
		return getSIGHT_RANGE();
	}

	public void updateDrawLines() {
		drawLines.get(0).copy(velocity);
		drawLines.get(0).scale(10);
		
		drawLines.get(1).copy(velocity);
		drawLines.get(1).scale(-10);
		drawLines.get(1).rotate(.5);
		
		drawLines.get(2).setZero();
		
		drawLines.get(3).copy(velocity);
		drawLines.get(3).scale(-10);
		drawLines.get(3).rotate(-.5);
		
		
	}
	public ArrayList<Vector> getlines(){
		return drawLines;
	}

	public static ArrayList<Bird> getAllBirds() {
		return ALL_BIRDS;
	}

	protected double getMAX_ACCELERATION() {
		return MAX_ACCELERATION;
	}

	protected double getMAX_SPEED() {
		return MAX_SPEED;
	}

	protected double getMIN_SPEED() {
		return MIN_SPEED;
	}

	protected double getSIGHT_RANGE() {
		return SIGHT_RANGE;
	}

	protected double getALIGNMENT_WEIGHT() {
		return ALIGNMENT_WEIGHT;
	}

	protected double getSEPARATION_WEIGHT() {
		return SEPARATION_WEIGHT;
	}

	protected double getCOHESION_WEIGHT() {
		return COHESION_WEIGHT;
	}

	
	
	


}
