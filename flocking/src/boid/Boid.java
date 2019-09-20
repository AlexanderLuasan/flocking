package boid;

import vector.Vector;

public interface Boid {
	public abstract boolean movement();
	public abstract void seeBoid(Boid other);
	public abstract Vector getVelocityVector();
	
}
