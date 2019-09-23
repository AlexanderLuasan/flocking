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
import graphics.Drawable;
import vector.Vector;
public class Triangle implements Drawable {
	private ArrayList<Vector> points = new ArrayList<Vector>();
	
	public Triangle(Vector a, Vector b, Vector c) {
		points.add(a);
		points.add(b);
		points.add(c);
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
		return 0;
	}
	public int getCenterY() {
		return 0;
	}

	@Override
	public ArrayList<Drawable> getComponents() {
		ArrayList<Drawable> Lines = new ArrayList<Drawable>();
		for(int i=0;i<3;i++) {
			for(int ii=i+1;ii<3;ii++) {
				Lines.add((Drawable)new Line(points.get(i),points.get(ii)));
			}
		}
		return Lines;
	}

	@Override
	public int Radius() {
		return 0;
	}

	@Override
	public Vector Line() {
		return null;
	}
	
}
