package boid;

import vector.Vector;

public class Flee extends BoidRule {
	private Vector flee=new Vector(0,0);
	private int fleeCount=0;
	private double flee_weight = 1;

	public Flee(BoidRule next) {
		super(next);
		
	}
	public Flee(BoidRule next,double flee_weight) {
		super(next);
		this.flee_weight = flee_weight;
	}
	
	public Vector getAceleration() {
		Vector total = lower.getAceleration();
		flee.multiply(flee_weight);
		total.add(flee);
		return total;
	}


	public boolean clear() {
		lower.clear();
		flee.setZero();
		fleeCount = 0;
		return true;
	}


	public Vector seeBoid(Boid me, Boid other) {
		lower.seeBoid(me, other);
		flee.add(other.getPositionVector());
		fleeCount+=1;
		return null;
	}


	public boolean calulate(Boid me) {
		if(fleeCount>0) {
			flee.divide(fleeCount);
			flee = Vector.subtract(flee, me.getPositionVector());
			flee.invert();
		}
		return true;
	}
	@Override
	public Vector getVector() {
		return flee;
	}
}
