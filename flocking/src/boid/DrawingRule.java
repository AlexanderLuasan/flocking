package boid;

import java.util.ArrayList;

import graphics.Colors;
import graphics.Drawable;
import vector.Vector;

public class DrawingRule extends BoidRule {

	private drawVector vectorline;
	public DrawingRule(BoidRule next, Colors c) {
		super(next);
		vectorline = new drawVector(c);
	}
	public Vector getAceleration() {
		Vector a = lower.getAceleration();
		vectorline.copy(a);
		return a;
	}

	public boolean drawingComponents(ArrayList<Drawable> drawings){
		drawings.add(vectorline);
		return super.drawingComponents(drawings);
	}

	public boolean clear() {
		return this.lower.clear();

	}
	@Override
	public Vector seeBoid(Boid me, Boid other) {
		return this.lower.seeBoid(me, other);

	}
	@Override
	public boolean calulate(Boid me) {
		return this.lower.calulate(me);

	}
	

}
