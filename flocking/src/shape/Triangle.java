package shape;
/*
 * 
 * class Triangle{
 * 		this of points in relative position to a center
 * 
 * 		create by giving all
 * 		set and get for variables
 * 			array accessed with a get and set with index
 * 
 * 		needs to implement drawable
 * 		
 * }
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import vector.Vector;
public class Triangle {
	private ArrayList<Vector> points;
	private int x;
	private int y;
	
	public Triangle(int x,int y,Vector a, Vector b, Vector c) {
		points.add(a);
		points.add(b);
		points.add(c);
		this.x=x;
		this.y=y;
	}
	
	public void setPoint(int index,int x,int y) {
		if(index<points.size()&&index>=0) {
			points.get(index).setxComponent(x);
			points.get(index).setyComponent(y);
		}
	}
	public Vector getPoint(int index) {
		if(index>=0&&index<points.size()) {
			return points.get(index);
		}
		return null;
	}
	public int getCenterX() {
		return x;
	}
	public int getCenterY() {
		return y;
	}
	
}
