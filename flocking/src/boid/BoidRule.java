package boid;

import java.util.ArrayList;

import graphics.Drawable;
import vector.Vector;

public abstract class BoidRule {
	
	public BoidRule lower;
	public BoidRule(BoidRule a) {
		lower = a;
	}
	public BoidRule(){
		lower = null;
	}
	public abstract Vector getAceleration();
	public abstract boolean clear();
	public abstract Vector seeBoid(Boid me,Boid other);
	public abstract boolean calulate(Boid me);
	public boolean drawingComponents(ArrayList<Drawable> drawings) {
		lower.drawingComponents(drawings);
		return false;
	}
	
}
