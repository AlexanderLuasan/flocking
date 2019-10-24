package boid;

import java.util.ArrayList;

import graphics.Colors;
import graphics.Drawable;
import vector.Vector;

class drawVector implements Drawable{
	static Vector cen = new Vector(0,0);
	private Colors color;
	private ArrayList<Vector> lines = new ArrayList<Vector>();
	private Vector point = new Vector(0,0);
	public drawVector(Colors col) {
		color = col;
		lines.add(cen);
		lines.add(point);
	}
	public void copy(Vector c) {
		point.copy(c);
	}
	public Vector getCenter() {
		return cen;
	}
	public ArrayList<Vector> getlines() {
		return lines;
	}
	public Colors getColor() {
		return color;
	}
	
}
