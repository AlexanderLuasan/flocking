package vector;
import java.lang.Math;
import utils.Utils;
/* vector.h

add some public static final vector for north south west east up down left right ...

class vector{
	ok 	public void setComponents(double x, double y);
	ok	public double getLength();
	ok  public void setLength(double l);
	ok 	public void zero();
	ok	public Vector(double x,double y);
	ok	public Vector(double x1, double y1,double x2, double y2);
	ok	public Vector(double radians, double length, boolean type);
	ok	public boolean add(Vector other); 								change to no new
	ok	public boolean subtract(Vector other); 							change to no new
	ok	public static Vector add(Vector a, Vector b);  		this will create a new vector
	ok	public static Vector subtract(Vector a, Vector b);	this will create a new vector
	ok 	public void multiply(double m);
	ok	public void divide(double d);  new divide function
	ok	public normalize();
	ok	public void scale(double newlength);
	ok	public void invert();
	ok	public bool limit(double min, double max); // adjust length so it is within the range //if it hit a boundy return true
	ok	public rotate(double radians);
	ok 	public void setAngle(double) // rotates the vector to a certain angle in radians
	ok 	public double getAngle();
	ok  public boolean isEqual(Vector other);
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
	
	public void setComponents(double x, double y) {
		this.xComponent = x;
		this.yComponent = y;
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
	
	public void setZero() {
		this.setxComponent(0);
		this.setyComponent(0);
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
	
	public void setAngle(double newAngle) {
		double length = this.getLength();
		Vector newVector = new Vector(length, newAngle);
		this.xComponent = (newVector.getxComponent());
		this.yComponent = (newVector.getyComponent());
	}
	
	public double getAngle() {
		double angle;
		if(this.getxComponent()<0) {
			angle = Math.atan(this.getyComponent()/this.getxComponent());
		}else if(this.getxComponent()>0) {
			angle = Math.atan(this.getyComponent()/this.getxComponent())+Math.PI;
		}else if (this.getyComponent()>0) {
			angle = Math.PI/2;
		}else if (this.getyComponent()<0) {
			angle = -Math.PI/2;
		}else {
			angle = 0;
		}
		return angle;
	}
	
	public boolean isEqual(Vector other) {
		if (utils.Utils.round(this.getxComponent())==utils.Utils.round(other.getxComponent()) && utils.Utils.round(this.getyComponent())==utils.Utils.round(other.getyComponent()))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Vector [xComponent=" + xComponent + ", yComponent=" + yComponent + "]";
	}
}
