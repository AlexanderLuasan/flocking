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
	public default ArrayList<Drawable> getDrawables(){
		return null;
	}
	public default ArrayList<Vector> getlines() {
		return null;
	}
	public Vector getCenter();
	public default double getRadius() {
		return 0;
	}
	public default double getWidth() {
		return 0;
	}
	public default double getHeight() {
		return 0;
	}
	public default Colors getColor() {
		return Colors.BLUE;
	}
}
