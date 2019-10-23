package boid;

import vector.Vector;

public class Cohesion extends BoidRule {

	private Vector cohesion=new Vector(0,0);
	private int cohesionCount=0;
	private double cohesion_weight=1;

	public Cohesion(BoidRule next) {
		super(next);
	}


	public Cohesion(BoidRule next, double cohesion_weight) {
		super(next);
		this.cohesion_weight = cohesion_weight;
	}


	public Vector getAceleration() {
		Vector total = lower.getAceleration();
		cohesion.multiply(cohesion_weight);
		total.add(cohesion);
		return total;
	}


	public boolean clear() {
		lower.clear();
		cohesion.setZero();
		cohesionCount=0;
		return true;
	}


	public Vector seeBoid(Boid me, Boid other) {
		lower.seeBoid(me, other);
		cohesion.add(other.getPositionVector());
		cohesionCount+=1;
		return null;
	}


	public boolean calulate(Boid me) {
		lower.calulate(me);
		if(cohesionCount>0) {//divide to get the avg
			cohesion.divide(cohesionCount);
			//create vector from my velocity to the target
			cohesion = Vector.subtract(cohesion,me.getPositionVector());
		}
		return true;
	}
}
