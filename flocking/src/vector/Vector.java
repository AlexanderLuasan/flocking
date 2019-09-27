package vector;
import java.lang.Math;
/* vector.h

add some public static final vector for north south west east up down left right ...

class vector{

	ok	public double getLength();
	ok   public void setLength(double l);
	ok	public Vector(double x,double y);
	ok	public Vector(double x1, double y1,double x2, double y2);
	ok	public Vector(double radians, double length, boolean type);
	ok	public boolean add(Vector other); 								change to no new
	ok	public boolean subtract(Vector other); 							change to no new
	ok	public static Vector add(Vector a, Vector b);  this will create a new vector
	ok 	public void multiply(double m);
	ok	public void divide(double d);  new divide function
	ok	public normalize();
	ok	public void scale(double newlength);
	ok	public void invert();
	 
	
	
	
	
	 //use the other constructor
	ok	public rotate(double radians); //increase the angle could be negative -- if this function seem to slow you might need to also hold the polar coordinates to save time
										angle + 1 is much faster than tan cos sin stuff i think
	un	public bool limit(double min, double max); // adjust length so it is within the range //if it hit a boundy return true
	
	
	 
 	ok	public static Vector subtract(Vector a, Vector b);  this will create a new vector 
 
 
 	ok  public boolean isEqual(Vector other);
 
 	un public void zero() //sets both compoents to zero
 un public void setAngle(double) // roates the vector to a certain angle in radians
 un public void setComponents(double x, double y) // sets compoenents at the same time
 un public double getAngle();// returns the angle of the vector in radians
}
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
	
	public double getLength() {
		double length = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		return length;
	}

	public void setLength(double l) {
		double oldLength = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale = l/oldLength;
		this.setxComponent(this.xComponent*scale);
		this.setyComponent(this.yComponent*scale);
	}
	
	public Vector(double x,double y) {
		this.setxComponent(x);
		this.setyComponent(y);
	}
	
	public Vector(double x1, double y1,double x2, double y2) {
		this(x2-x1,y2-y1);
	}
	
	public Vector(double radians, double length, boolean type) {
		double xComponent = length*Math.cos(radians);
		double yComponent = length*Math.sin(radians);
		this.setxComponent(xComponent);
		this.setyComponent(yComponent);
	}
	
	public boolean add(Vector other) {
		this.setxComponent(this.xComponent+other.xComponent);
		this.setyComponent(this.yComponent+other.yComponent);
		return true;
	}
	
	public boolean subtract(Vector other) {
		other.invert();
		this.setxComponent(this.xComponent+other.xComponent);
		this.setyComponent(this.yComponent+other.yComponent);
		other.invert();
		return true;
	}
	
	public static Vector add(Vector a, Vector b) {
		Vector newVector = new Vector(0,0);
		boolean addA = newVector.add(a);
		boolean addB = newVector.add(b);
		return newVector;
	}
	
	public static Vector subtract(Vector a, Vector b) {
		Vector newVector = new Vector(0,0);
		boolean addA = newVector.add(a);
		boolean addB = newVector.subtract(b);
		return newVector;
	}
	
	public void multiply(double m) {
		this.setxComponent(this.xComponent*m);
		this.setyComponent(this.yComponent*m);
	}
	
	public void divide(double d) {
		this.setxComponent(this.xComponent/d);
		this.setyComponent(this.yComponent/d);
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
	
	public void invert() {
		this.setxComponent(-this.xComponent);
		this.setyComponent(-this.yComponent);
	}
	
	public boolean limit(double min, double max) {
		double oldLength = Math.sqrt(Math.pow(this.xComponent, 2) + Math.pow(this.yComponent, 2));
		double scale;
		if (oldLength<min) {
			scale = min/oldLength;
			this.setxComponent(this.xComponent*scale);
			this.setyComponent(this.yComponent*scale);
			return true;
		}else if (oldLength>max) {
			scale = max/oldLength;
			this.setxComponent(this.xComponent*scale);
			this.setyComponent(this.yComponent*scale);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void rotate(double radians) {
		double newXComponent = this.xComponent*Math.cos(radians)-this.yComponent*Math.sin(radians);
		double newYComponent = this.xComponent*Math.sin(radians)+this.yComponent*Math.cos(radians);
		this.setxComponent(newXComponent);
		this.setyComponent(newYComponent);
	}
	
	public boolean isEqual(Vector other) {
		
		if (this.round(this.getxComponent())==this.round(other.getxComponent()) && this.round(this.getyComponent())==this.round(other.getyComponent()))
			return true;
		return false;
	}
	
	private static double round(double input) {
		input*=1000;
		input=Math.round(input);
		return input/1000;
	}
	@Override
	public String toString() {
		return "Vector [xComponent=" + xComponent + ", yComponent=" + yComponent + "]";
	}
}
