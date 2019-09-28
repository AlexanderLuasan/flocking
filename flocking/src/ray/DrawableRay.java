package ray;

import java.util.ArrayList;

import graphics.Drawable;
import vector.Vector;

public class DrawableRay extends Ray implements Drawable {

	private ArrayList<Drawable> arrayCircle = new  ArrayList<Drawable>();
	
	@Override
	public Vector getCenter() {
		return this.getStartPoint();
	}
	public ArrayList<Drawable> getDrawables(){
		return this.arrayCircle;
	}
}
