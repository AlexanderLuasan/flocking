package graphics;
/*
 * unimplemented
 * class Drawable{
 * 
 * 
 * 		this one is not function discibable give a series of functions that allow you to draw differnt objects by requesting information
 * 		examples:
 *			note object may be made of multible shapes
 * 			String getColor(); //returns the color hash
 * 			bool isCircle(); // check to make sure they are a circle
 * 			int getCenterX();//returns a point
 * 			int getCenterY();
 * 			double getRadius();
 * 			with these functions you can detect and draw a circle of any color
 * 
 * 
 * }
 * 
 * */
import java.util.ArrayList;
import vector.Vector;
 interface DrawableCircle {
	//Functions for Drawing Circle
	public boolean isCircle();
	public int getCenterX();
	public int getCenterY();
	public double getRadius();
}
 
 interface DrawableLine {
	//Functions for Drawing line
	public int get1pointX();
	public int get1pointY();
	public int get2pointX();
	public int get2pointY();
}




public interface Drawable {
	public ArrayList<Drawable> getComponents();
	public int getCenterX();
	public int getCenterY();
	
	public int Radius();
	public Vector Line();
}
