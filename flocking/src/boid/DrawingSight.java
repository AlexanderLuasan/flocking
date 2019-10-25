package boid;

import java.util.ArrayList;

import graphics.Drawable;
import ray.DrawableRay;

public class DrawingSight extends Sight {

	
	public DrawingSight(BoidRule next, int trace_distance) {
		super(next, trace_distance,new DrawableRay());
	}
	
	public DrawingSight(BoidRule next) {
		super(next,new DrawableRay());

	}
	
	public boolean drawingComponents(ArrayList<Drawable> drawings){
		drawings.add((Drawable)this.getRay());
		return super.drawingComponents(drawings);
	}
	public boolean calulate(Boid me) {
		super.calulate(me);
		this.getRay().getStartPoint().setZero();
		return false;
	}

	
}
