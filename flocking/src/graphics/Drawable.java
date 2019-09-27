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



/*
interface {
	public Vector getCenter
	public arrayList<Drawable> getDrawables
	public arralist<vector> getLines()
	public double getRadius
	public double getWidth()
	public double getHeight()
	public colors getcolor()
}
 
 
 */

import java.util.ArrayList;
import vector.Vector;
 

public interface Drawable {
	//public ArrayList<Drawable> getDrawables();
	public ArrayList<Vector> getlines();
	public Vector getCenter();
	public double getRadius();
	public double getWidth();
	public double getHeight();
	public Colors getColor();
}
