package boid;

import vector.Vector;

import java.util.ArrayList;

import graphics.Colors;
import graphics.Drawable;
public interface Boid extends Drawable {
	public boolean movement();//calulates the boids movment to the next frame
	public boolean preBehaviour();
	public boolean behaviour();			//caluates the acceleration in the 
	public void seeBoid(Boid other);		//when two boids can see each other each one needs to see each other
	public Vector getVelocityVector();		//get the boids velocity vector
	public Vector getPositionVector();		//get the boids position vector
	public static double distance(Boid a,Boid b) {	//unimplmented
		return utils.Utils.distance(a.getPositionVector(),b.getPositionVector());
	}
	public static void sight(Boid a, Boid b) {
		a.seeBoid(b);
		b.seeBoid(a);
	}
	public default ArrayList<Vector> getlines(){
		return null;
		
	}
	public default Vector getCenter(){
		return this.getPositionVector();
	}
	
	public default double getRadius() {
		return 0;
	}
	public default double getWidth() {
		return 0;
	}
	public default double getHeight() {
		return 0;
	}
	public default Colors getColor() {
		return Colors.RED;
	}
}
