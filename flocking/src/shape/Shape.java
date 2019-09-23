package shape;

import ray.RayDetectable;
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
public abstract class Shape  {
	int centerX;
	int centerY;
	
	public Shape(int x, int y) {
		centerX = x;
		centerY = y;
	}
}
