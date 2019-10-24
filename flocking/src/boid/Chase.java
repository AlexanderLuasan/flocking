package boid;

import vector.Vector;

public class Chase extends BoidRule {

	private Vector chase=new Vector(0,0);
	protected boolean foundChase=false;
	private double chase_weight = 1;
	
	public Chase(BoidRule next) {
		super(next);
		
	}
	public Chase(BoidRule next,double chase_weight) {
		super(next);
		this.chase_weight = chase_weight;
	}
	
	public Vector getAceleration() {
		Vector total = lower.getAceleration();
		total.add(chase);
		return total;
	}


	public boolean clear() {
		lower.clear();
		chase.setZero();
		foundChase = false;
		return true;
	}


	public Vector seeBoid(Boid me, Boid other) {
		lower.seeBoid(me, other);
		if(foundChase) {
			if(utils.Utils.distance(other.getPositionVector(), me.getPositionVector())<utils.Utils.distance(chase,me.getPositionVector())) {
				chase = other.getPositionVector();
			}
		}else {
			chase = other.getPositionVector();
			foundChase=true;
		}
		return null;
	}


	public boolean calulate(Boid me) {
		lower.calulate(me);
		if(foundChase) {
			chase = Vector.subtract(chase, me.getPositionVector());
		}
		return true;
	}
	@Override
	public Vector getVector() {
		return chase;
	}
}
