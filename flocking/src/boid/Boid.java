package boid;

import vector.Vector;

public interface Boid {
	public abstract boolean movement();
	public abstract boolean behaviour();
	public abstract void seeBoid(Boid other);
	public abstract Vector getVelocityVector();
	public abstract Vector getPositionVector();
	public static double distance(Boid a,Boid b) {//unimplmented
		return 0.0;
	}
	
}
