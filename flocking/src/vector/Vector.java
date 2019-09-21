package vector;
import java.lang.Math;

/* vector.h
 * 
 * 
 * add some public static final vector for north south west east up down left right ...
 * unimplmented
 * class vector{
 * 		public Vector add(Vector other);//return a new one
 * 		public void invert();
 * 		public Vector subtract(Vector other);
 * 		public void scale(double length);
 * 		public normalize();
 * 	ok	public Vector(double x,double y);
 * 		public Vector(double radians, double length);
 * 		public Vector(double x1, double y1,double x2, double y2); //use the other constructor
 * 		public rotate(double radians); //increase the angle could be negative -- if this function seem to slow you might need to also hold the polar coordinates to save time
 * 										angle + 1 is much faster than tan cos sin stuff i think
 * 		public Vector limit(double min, double max); // adjust length so it is within the range
 * }
 */


public class Vector {
	
	private double xPos;
	private double yPos;
	
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public Vector(double x,double y) {
		this.setxPos(x);
		this.setyPos(y);
	}
	
	public Vector(double radians, double length, boolean type) {
		double xPos = Math.cos(length);
		double yPos = Math.sin(length);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}
}
