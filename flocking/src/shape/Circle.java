package shape;

import graphics.Drawable;

/*
 * you know a circle 
 * 
 * class circle{
 * 		double radius
 * 		get and set
 * 		// you will need to implement he interface functions
 * }
 * 
 * 
 * 
 * */


public class Circle extends Shape implements Drawable {
	private boolean isCircle = true;
	private int radius;
	
	
	public Circle(int x, int y, int r) {
		super(x,y);
		this.radius = r;
	}
	
	@Override
	public boolean isCircle() {
		return this.isCircle;
	}
	
	@Override
	public int getCenterX() {
		return this.centerX;
	}
	
	@Override
	public int getCenterY() {
		return this.centerY;
	}
	@Override
	public int getRadius() {
		return this.radius;
	}
}
