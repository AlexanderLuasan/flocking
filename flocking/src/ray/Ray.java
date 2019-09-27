package ray;
import java.util.ArrayList;
import java.util.Collections;

import vector.Vector;
import shape.Circle;
/* 
class ray{

	ok	Vector starting point;
	ok	Vector current point;
	ok	Vector direction;
	ok	double distanceLast;

	un	double trace(double limitDistance);			//run the trace for a minimum unit return distance if you hit anything, -1 for hitting nothing 
	un	double fetchDistance();						//what was the actual distance
	un	arrayList<shape.Circles> fetchCirlces(); 	//calculate all the circles for drawing and debugging reuse the shape class for easy drawing
	un	boolean search(double distance);			//rotate the direction vector left and right until you find a direction that does not collide within the distance save the vector to direction
}
 */
public class Ray {
	
	public static final ArrayList<RayDetectable> rayDetectable = new ArrayList<RayDetectable>(); 
	
	private Vector startPoint;

	private Vector currentPoint;
	
	private Vector direction;
	
	private double lastDistance;
	
	public Vector getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Vector startPoint) {
		this.startPoint = startPoint;
	}

	public Vector getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Vector currentPoint) {
		this.currentPoint = currentPoint;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	public double getLastDistance() {
		return lastDistance;
	}

	public void setLastDistance(double lastDistance) {
		this.lastDistance = lastDistance;
	}

	public double trace(double limitDistance) {
		double tempDistance = 0;
		double newDistance = 0;
		boolean hitObject = false;
		while(!hitObject && newDistance<=limitDistance) {
			tempDistance = rayDetectable.get(0).distanceToPoint(this.getCurrentPoint());
			for(int i=0; i<rayDetectable.size()-1; i++) {
				if(rayDetectable.get(i+1).distanceToPoint(this.getCurrentPoint()) < newDistance){
					tempDistance = rayDetectable.get(i+1).distanceToPoint(this.getCurrentPoint());
				}
			}
			newDistance+=tempDistance;
			this.currentPoint.setLength(tempDistance);
		}
		return (hitObject == true) ? newDistance : -1; 
	}
	
	public double fetchDistance() {
		
	}
	
	public arrayList<shape.Circles> fetchCirlces(){
		
	}
	
	public boolean search(double distance) {
		
	}
	
	@Override
	public String toString() {
		return "Ray [startPoint=" + startPoint + ", currentPoint=" + currentPoint + ", direction=" + direction
				+ ", lastDistance=" + lastDistance + "]";
	}
	
	
}
