package ray;

import vector.Vector;
public interface RayDetectable {
	public abstract double distanceToPoint(Vector point);//the length of the shortest path from the point to the edge of the shape
	public abstract double distanceToPointCircle(Vector point);//the length of the shortest path from the point to the edge of the shape if it were a circle
}
