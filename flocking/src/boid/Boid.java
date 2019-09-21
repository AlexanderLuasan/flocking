package boid;

import vector.Vector;

public interface Boid {
	public abstract boolean movement();				//calulates the boids movment to the next frame
	public abstract boolean behaviour();			//caluates the acceleration in the 
	public abstract void seeBoid(Boid other);		//when two boids can see each other each one needs to see each other
	public abstract Vector getVelocityVector();		//get the boids velocity vector
	public abstract Vector getPositionVector();		//get the boids position vector
	public static double distance(Boid a,Boid b) {	//unimplmented
		return 0.0;
	}
	
}
