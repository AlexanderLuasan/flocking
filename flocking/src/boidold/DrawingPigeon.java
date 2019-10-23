package boidold;

import java.util.ArrayList;

import boid.Pigeon;
import graphics.Colors;
import graphics.Drawable;
import ray.DrawableRay;
import vector.Vector;

public class DrawingPigeon extends Pigeon {

	ArrayList<Drawable> Drawings = new ArrayList<Drawable>();
	
	Vector Dalignment;
	Vector Dcohesion;
	Vector Dseparation;
	Vector Dflee;
	public static double vLength; 
	public DrawingPigeon(int x, int y, Vector vel) {
		super(x, y, vel);
		
		
	}
	public ArrayList<Drawable> getDrawables(){
		return Drawings;
	}
}
class drawVector implements Drawable{
	static Vector cen = new Vector(0,0);
	private Colors color;
	ArrayList<Vector> lines = new ArrayList<Vector>();
	public drawVector(Vector point, Colors col) {
		color = col;
		lines.add(cen);
		lines.add(point);
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
