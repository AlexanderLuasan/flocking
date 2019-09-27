package shape;

import ray.RayDetectable;
import vector.Vector;

import java.util.ArrayList;

import graphics.Colors;
import graphics.Drawable;

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
public class Shape implements Drawable {
	protected Vector center;
	
	public Shape(Vector center) {
		this.center = center;
	}

	@Override
	public ArrayList<Vector> getlines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getCenter() {
		return this.center;
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Colors getColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
