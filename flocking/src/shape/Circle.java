package shape;

import java.util.ArrayList;

import graphics.Drawable;
import vector.Vector;

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


public class Circle extends Shape {
	private int radius;
	
	public Circle(Vector center, int r) {
		super(center);
		this.radius = r;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
}
