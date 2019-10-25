package boid;

import vector.Vector;

public class Inverse extends BoidRule {

	public Inverse(BoidRule a) {
		super(a);
		
	}

	@Override
	public Vector getAceleration() {
		Vector a  = lower.getAceleration();
		Vector b = lower.getVector();
		b.invert();
		b.multiply(2);
		a.add(b);
		return a;
	}

	@Override
	public boolean clear() {
		return lower.clear();
	}

	@Override
	public Vector seeBoid(Boid me, Boid other) {
		return lower.seeBoid(me, other);
	}

	@Override
	public boolean calulate(Boid me) {
		return lower.calulate(me);

	}

	@Override
	public Vector getVector() {
		Vector a = new Vector(0,0);
		a.invert();
		return a;
	}


}
