package boid;

import java.util.ArrayList;

import graphics.Colors;
import graphics.Drawable;
import ray.DrawableRay;
import vector.Vector;

public class DrawingPigeon extends Pigeon {

	ArrayList<Drawable> Drawings = new ArrayList<Drawable>();
	public DrawingPigeon(int x, int y, Vector vel) {
		super(x, y, vel);
		DrawableRay R = new ray.DrawableRay();
		this.setSight(R);
		Drawable C = new shape.Circle(new Vector(0,0),(int) this.getSIGHT_RANGE());
		Drawable C2 = new shape.Circle(new Vector(0,0),(int) this.getSightDistance());
		Drawings.add(R);
		Drawings.add(C);
		Drawings.add(C2);
	}
	//public Colors getColor() {
	//	return Colors.ORANGE;
	//}
	public ArrayList<Drawable> getDrawables(){
		this.getSight().getStartPoint().setZero();
		return Drawings;
	}
}
