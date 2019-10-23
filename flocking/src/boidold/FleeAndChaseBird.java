package boidold;

import boid.Bird;
import vector.Vector;

/*
class FleeAndChaseBird super Bird{
	Vector flee;
	int fleeCount;
	Vector chase;
	boolean foundChase;

ok	FleeAndChaseBird()
ok	boolean preBehaviour() //reset the new vectors then run the super
ok	chase() //finish the chase function
ok	chase(Bird other); // offer selection to the chase function
ok	flee()	//finish the flee function
ok	flee(Bird other);	//offer selection to the flee function
	

}
 */

public class FleeAndChaseBird extends Bird {
	protected Vector flee;
	protected int fleeCount=0;
	protected Vector chase;
	protected boolean foundChase=false;
	protected static final double CHASE_WEIGHT = 1;
	protected static final double FLEE_WEIGHT = 1;
	public FleeAndChaseBird(int x, int y, Vector vel) {
		super(x, y, vel);
		flee = new Vector(0,0);
		chase = new Vector(0,0);
	}
	public boolean preBehaviour() {
		flee.setZero();
		chase.setZero();
		fleeCount = 0;
		foundChase = false;
		return super.preBehaviour();
		
	}
	public boolean behaviour() {
		boolean end = super.behaviour();
		
		this.flee();
		this.chase();
		
		
		if(foundChase) {
			this.chase.divide(this.velocity.getLength());
			this.acceleration.add(this.chase);
		}
		if(fleeCount>0) {
			this.acceleration.setZero();
			this.flee.scale(1);
			this.acceleration.add(this.flee);
		}
		
		return end;
	}
	
	void chase(Bird other) {//find the closest one
		if(foundChase) {
			if(utils.Utils.distance(other.position, this.position)<utils.Utils.distance(flee,this.position)) {
				chase = other.getPositionVector();
			}
		}else {
			chase = other.getPositionVector();
			foundChase=true;
		}
	}
	void chase() {
		if(foundChase) {
			chase = Vector.subtract(chase, this.position);
		}
	}
	void flee(Bird other) {//find the avg position
			flee.add(other.getPositionVector());
			fleeCount+=1;
	}
	void flee() {
		if(fleeCount>0) {
			flee.divide(fleeCount);
			flee = Vector.subtract(flee, this.position);
			flee.invert();
		}
	}
	protected double getCHASE_WEIGHT() {
		return CHASE_WEIGHT;
	}
	protected double getFLEE_WEIGHT() {
		return FLEE_WEIGHT;
	}
	

}
