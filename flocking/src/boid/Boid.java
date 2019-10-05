package boid;

/*
interface Boid{
ok	public boolean movement();//calulates the boids movment to the next frame
		in Bird
ok	public boolean preBehaviour();
		in Bird
ok	public boolean behaviour();			//caluates the acceleration in the 
		in Bird
ok	public void seeBoid(Boid other);		//when two boids can see each other each one needs to see each other
		in Bird
ok	public Vector getVelocityVector();		//get the boids velocity vector
		in Bird
ok	public Vector getPositionVector();		//get the boids position vector
		in Bird
ok	public double sightRange();				//get sight range
		in Bird
ok	public static double distance(Boid a,Boid b) // return the distance between two boids
er	public static boolean sight(Boid a, Boid b) // detect if two boids 
ok	public default Vector getCenter() // same as return position
ok	public default boolean prey() //detect if someone is a hostile
ok	getColor set a default color

}
 */


import vector.Vector;


import graphics.Colors;
import graphics.Drawable;
public interface Boid extends Drawable {
	
	public boolean movement();//calulates the boids movment to the next frame
	public boolean preBehaviour();
	public boolean behaviour();			//caluates the acceleration in the 
	public void seeBoid(Boid other);		//when two boids can see each other each one needs to see each other
	public Vector getVelocityVector();		//get the boids velocity vector
	public Vector getPositionVector();		//get the boids position vector
	public double sightRange();				//get sight range
	public static double distance(Boid a,Boid b) {	
		return utils.Utils.distance(a.getPositionVector(),b.getPositionVector());
	}
	public static boolean sight(Boid a, Boid b) {//need to include the edges
		boolean inSightRange = false;
		
		double d = Boid.distance(a, b);
		if(d<a.sightRange()) {
			a.seeBoid(b);
			inSightRange = true;
		}
		
		d = Boid.distance(a, b);
		if(d<b.sightRange()) {
			b.seeBoid(a);
			inSightRange = true;
		}
		return inSightRange;
//		if(!a.prey()||!b.prey()) {//if exist
//			if(d<a.sightRange()*2) {
//				a.seeBoid(b);
//			}
//			if(d<b.sightRange()*2) {
//				b.seeBoid(a);
//			}
//		}
	}
	public default Vector getCenter(){
		return this.getPositionVector();
	}
	public default boolean prey() {
		return true;
	}
	public default Colors getColor() {
		return Colors.GREEN;
	}
}
