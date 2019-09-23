package shape;

import java.util.ArrayList;

import graphics.Drawable;
import vector.Vector;

public class Line implements Drawable {

	private Vector p1;
	private Vector p2;
	
	public Line(Vector a,Vector b) {
		p1=a;
		p2=b;
	}
	public void setLine(Vector a,Vector b) {
		p1=a;
		p2=b;
	}
	@Override
	public ArrayList<Drawable> getComponents() {
		return null;
	}

	@Override
	public int getCenterX() {
		return (int) p1.getxComponent();
	}

	@Override
	public int getCenterY() {
		// TODO Auto-generated method stub
		return (int) p1.getyComponent();
	}

	@Override
	public int Radius() {
		return 0;
	}

	@Override
	public Vector Line() {
		return p2;
	}

}
