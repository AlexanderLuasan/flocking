package shape;

import java.util.ArrayList;

import graphics.Drawable;
import vector.Vector;

/*
 * you know a circle 
 * 
 * class circle{
 * 		double radius
 * 		get and set
 * 		// you will need to implement he interface functions
 * }
 * 
 * 
 * 
 * */


public class Circle extends Shape implements Drawable {
	private boolean isCircle = true;
	private int radius;
	
	
	public Circle(int x, int y, int r) {
		super(x,y);
		this.radius = r;
	}


	@Override
	public ArrayList<Drawable> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int Radius() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Vector Line() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
