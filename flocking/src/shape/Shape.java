package shape;


import vector.Vector;
import graphics.Colors;
import graphics.Drawable;
import ray.RayDetectable;

/*
 * 
 * 
 *
 * unimplemented
 * arraylist shapes allobsticals -- warning don't put in constructor
 * 
 * class Shape{
 * 		int center x;
 * 		int center y;
 * 		build your shape around the origin and then have it move
 * 		add getters and setters
 * 		
 * 
 * 		
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 */
//implements RayDetectable, Drawable not ready to implement
public abstract class Shape implements Drawable,RayDetectable {
	protected Vector center;
	private Colors color;
	
	
	public Shape(Vector center) {
		this.center = center;
	}
	
	@Override
	public Vector getCenter() {
		return this.center;
	}
	
	public void setColors(Colors color) {
		this.color = color;
	}
	public Colors getColors() {
		return this.color;
	}
}
