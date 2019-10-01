package ray;
import java.util.ArrayList;
import java.util.Collections;

import graphics.Drawable;
import vector.Vector;
import shape.Circle;
/* 
class ray{

	ok	Vector starting point;
	ok	Vector current point;
	ok	Vector direction;
	ok	double distanceLast;

	ok	double trace(double limitDistance);			//run the trace for a minimum unit return distance if you hit anything, -1 for hitting nothing 
	im	arrayList<shape.Circles> fetchCirlces(); 	//calculate all the circles for drawing and debugging reuse the shape class for easy drawing
	ok	boolean search(double distance);			//rotate the direction vector left and right until you find a direction that does not collide within the distance save the vector to direction
}
 */
public class Ray{
	
	public static final ArrayList<RayDetectable> rayDetectable = new ArrayList<RayDetectable>(); 
	
	public static ArrayList<RayDetectable> getRaydetectable() {
		return rayDetectable;
	}
	private Vector startPoint;

	private Vector currentPoint = new Vector(0,0);
	
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
		this.currentPoint.copy(startPoint);
		while(newDistance<=limitDistance) {

		
			tempDistance = minDistance(limitDistance);
			if(tempDistance<1) {
				return newDistance;
			}
			if(tempDistance>=limitDistance-1){//no objects within range
				return -1;
			}
			moveCurrentPoint(tempDistance);
			
			newDistance+=tempDistance;
		}
		return -1; 
	}
	public double minDistance(double limit) {
		double tempDistance = limit;
		for(int i=0; i<rayDetectable.size(); i++) {
			if(rayDetectable.get(i).distanceToPoint(this.getCurrentPoint()) < tempDistance){
				tempDistance = rayDetectable.get(i).distanceToPoint(this.getCurrentPoint());
			}
		}
		return tempDistance;
	}
	public void moveCurrentPoint(double distance) {
		this.direction.scale(distance);
		this.currentPoint.add(this.direction);
	}
	
	
	public boolean search(double limitDistance) {
		boolean found = false;
		double degreeCounter = 0;
		boolean counterClockwise = true;
		while(!found) {
			if(this.trace(limitDistance)<0) {
				found = true;
				return true;
			}else {
				
				degreeCounter++;
				if(counterClockwise) {
					this.direction.rotate(Math.toRadians(degreeCounter));
					counterClockwise = false;
				}else {
					this.direction.rotate(-Math.toRadians(degreeCounter));
					counterClockwise = true;
				}
			}
		}
		return found ? true : false;
	}
	
	@Override
	public String toString() {
		return "Ray [startPoint=" + startPoint + ", currentPoint=" + currentPoint + ", direction=" + direction
				+ ", lastDistance=" + lastDistance + "]";
	}


	
	
}
