package ray;
import vector.Vector;
/* 
class ray{

	ok	Vector starting point;
	ok	Vector current point;
	ok	Vector direction;
	ok	double distanceLast;

	un	double trace(distance x);				//run the trace for a minimum unit return distance if you hit anything, -1 for hitting nothing 
	un	double fetchDistance();					//what was the actual distance
	un	arrayList<shape.Circles> fetchCirlces(); 	//calculate all the circles for drawing and debuging reuse the shape class for esay drawing
	un	bool search(double distance);		//rotate the direction vector left and right until you find a direction that dose not colide within the distance save the vector to direction
}
 */
public class Ray {
	
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

	@Override
	public String toString() {
		return "Ray [startPoint=" + startPoint + ", currentPoint=" + currentPoint + ", direction=" + direction
				+ ", lastDistance=" + lastDistance + "]";
	}
	
	
}
