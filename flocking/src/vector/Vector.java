package vector;
import java.lang.Math;

/* vector.h
 * 
 * 
 * add some public static final vector for north south west east up down left right ...
 * unimplmented
 * class vector{
 * 	public void add(Vector other);//return a new one
 * 	public void invert();
 * 	public Vector subtract(Vector other);
 * 	public void scale(double length);
 * 	public normalize();
 * 	public Vector(double x,double y);
 * 	public Vector(double radians, double length);
 * 	public Vector(double x1, double y1,double x2, double y2); //use the other constructor
 *  public rotate(double radians); //increase the angle could be negative -- if this function seem to slow you might need to also hold the polar coordinates to save time
 * 										angle + 1 is much faster than tan cos sin stuff i think
 * 	public Vector limit(double min, double max); // adjust length so it is within the range
 *  public void divide(int a);
 * }
 */

public class Vector {
	
	private double xComponent;
	
	private double yComponent;

	public double getxComponent() {
		return xComponent;
	}

	public void setxComponent(double xComponent) {
		this.xComponent = xComponent;
	}

	public double getyComponent() {
		return yComponent;
	}

	public void setyComponent(double yComponent) {
		this.yComponent = yComponent;
	}

	public Vector(double x,double y) {
		this.setxComponent(x);
		this.setyComponent(y);
	}
	
	public Vector(double x1, double y1,double x2, double y2) {
		this.setxComponent(x2-x1);
		this.setyComponent(y2-y1);
	}
	
	public Vector(double radians, double length, boolean type) {
		double xComponent = length*Math.cos(radians);
		double yComponent = length*Math.sin(radians);
		this.setxComponent(xComponent);
		this.setyComponent(yComponent);
	}
	
	public void add(Vector other) {
		this.setxComponent(this.xComponent+other.xComponent);
		this.setyComponent(this.yComponent+other.yComponent);
	}
	
	public Vector subtract(Vector other) {
		other.invert();
		this.setxComponent(this.xComponent+other.xComponent);
		this.setyComponent(this.yComponent+other.yComponent);
		other.invert();
		return this;
	}
	
	public void normalize() {
		double length = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale = 1.0/length;
		this.setxComponent(this.xComponent*scale);
		this.setyComponent(yComponent*scale);
	}
	
	public void scale(double newlength) {
		double oldLength = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale = newlength/oldLength;
		this.setxComponent(this.xComponent*scale);
		this.setyComponent(this.yComponent*scale);
	}
	
	public void divide(int a) {
		double oldLength = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale = oldLength/a;
		this.setxComponent(this.xComponent*scale);
		this.setyComponent(this.yComponent*scale);
	}
	
	public void invert() {
		this.setxComponent(-this.xComponent);
		this.setyComponent(-this.yComponent);
	}
	
	public void limit(double min, double max) {
		double oldLength = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale;
		if (oldLength<min) {
			scale = min/oldLength;
		}else if (oldLength>max) {
			scale = max/oldLength;
		}else {
			scale = 1;
		}
		this.setxComponent(this.xComponent*scale);
		this.setyComponent(this.yComponent*scale);
	}
	
	public void rotate(double radians) {
		double newXComponent = this.xComponent*Math.cos(radians)-this.yComponent*Math.sin(radians);
		double newYComponent = this.xComponent*Math.sin(radians)+this.yComponent*Math.cos(radians);
		this.setxComponent(newXComponent);
		this.setyComponent(newYComponent);
	}
	
	@Override
	public String toString() {
		return "Vector [xComponent=" + xComponent + ", yComponent=" + yComponent + "]";
	}
}
