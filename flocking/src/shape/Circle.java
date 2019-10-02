package shape;


import ray.RayDetectable;

import vector.Vector;
import utils.Utils;
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


public class Circle extends Shape implements RayDetectable {
	private int radius;
	
	public Circle(Vector center, int r) {
		super(center);
		this.radius = r;
	}
	
	public double getRadius() {
		return this.radius;
	}

	@Override
	public double distanceToPoint(Vector point) {
		double tempDistance = Utils.distance(point, this.getCenter());
		double resultDistance = tempDistance-this.getRadius();
		return resultDistance;
	}

	@Override
	public double distanceToPointCircle(Vector point) {
		return distanceToPoint(point);
	}
	
}
