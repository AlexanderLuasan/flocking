package boid;

import vector.Vector;

/*
 * class Bird{
 * 	  variables
 * 		Vector position the boids position
 * 		Vector velocity the boids velocity
 * 		Vector acceleration the acceleration of the boid
 * 
 * 	ok	Bird(int x,int y,vector vel);	//position x and y and inital velocity
 * 	ok	bool movement();				//update the birds position to the next frame
 * 	ok	seeboid(boid other);			//how to tell a boid about other boids
 * 										//this triggers all differnt rules
 * 	ok	behavior();						//finish all the calulations
 * 										//this finishes the calulaition for all the rules
 * 			other general functions are discriped in boid interface		
 * 
 * 		//rule functions
 * 			//alignment
 * 	ok			Vector alignment;
 * 	ok			int alignmentCount
 * 	ok			void align(boid other);		//add a boids velocity vector the alignment vector
 * 	un			void align();				//finish the calulation and add it to the acceleration
 * 			//Cohesion
 * 	ok			Vector cohesion;
 * 	ok			int cohesionCount
 * 	ok			void cohesion(boid other);		//add a boids velocity vector the cohesion vector
 * 	un			void cohesion();				//finish the calulation and add it to the acceleration
 *			//seperation
 *	ok			Vector seperation;
 * 	ok			int seperationCount
 * 	un			void cohesion(boid other);		//add a boids velocity vector the seperation vector
 * 	un			void cohesion();				//finish the calulation and add it to the acceleration
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
		velocity = velocity.add(acceleration);
		
		//update the position with the velocity
		position = position.add(velocity);
		
		
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
			
		this.align();
		this.cohesion();
		this.separation();
		return false;
	}
	
	//alignment
	void align(Bird other) {
		alignment.add(other.velocity);
		alignmentCount+=1;
	}
	void align() {
		//unimplemented
	}
	
	//cohesion
	void cohesion(Bird other) {
		this.cohesion.add(other.position);
		this.cohesionCount+=1;
	}
	void cohesion() {
		
	}
	
	void separation(Bird other) {
		//this.seperation.add(other.position);
		//this.seperationCount+=1;
	}
	void separation() {
		
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
	
	//alignment
	
}
