package ray;

import vector.Vector;
public interface RayDetectable {
	public abstract double distanceToPoint(Vector Point);//the length of the shortest path from the point to the edge of the shape
	public abstract double distanceToPointCircle(Vector Point);//the length of the shortest path from the point to the edge of the shape if it were a circle
}
