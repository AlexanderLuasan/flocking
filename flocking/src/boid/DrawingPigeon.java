package boid;

import java.util.ArrayList;

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
	public void align() {
		super.align();
		Dalignment.copy(this.alignment);
		Dalignment.scale(vLength * this.getALIGNMENT_WEIGHT());
	}
	public void cohesion() {
		super.cohesion();
		Dcohesion.copy(this.cohesion);
		Dcohesion.scale(vLength * this.getCOHESION_WEIGHT());
	}
	public void separation() {
		super.separation();
		Dseparation.copy(this.separation);
		Dseparation.scale(vLength * this.getSEPARATION_WEIGHT());
	}
	public void flee() {
		super.flee();
		if(fleeCount>0) {
			Dflee.copy(this.flee);
			Dflee.scale(vLength * this.getFLEE_WEIGHT());
		}else {
			Dflee.setZero();
		}
	}
	public DrawingPigeon(int x, int y, Vector vel) {
		super(x, y, vel);
		DrawableRay R = new ray.DrawableRay();
		this.setSight(R);
		vLength = this.getSIGHT_RANGE();
		Dalignment = new Vector(0,0);
		Dcohesion = new Vector(0,0);
		Dseparation = new Vector(0,0);
		Dflee = new Vector(0,0);
		
		Drawable C = new shape.Circle(new Vector(0,0),(int) this.getSIGHT_RANGE());
		Drawable C2 = new shape.Circle(new Vector(0,0),(int) this.getSightDistance());
		Drawings.add(R);
		Drawings.add(C);
		Drawings.add(C2);
		Drawings.add(new drawVector(Dalignment,Colors.YELLOW));
		Drawings.add(new drawVector(Dcohesion,Colors.BLUE));
		Drawings.add(new drawVector(Dseparation,Colors.RED));
		Drawings.add(new drawVector(Dflee,Colors.ORANGE));
		
	}
	//public Colors getColor() {
	//	return Colors.ORANGE;
	//}
	public ArrayList<Drawable> getDrawables(){
		this.getSight().getStartPoint().setZero();
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
