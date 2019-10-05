package shape;
import ray.RayDetectable;
import java.util.ArrayList;

import vector.Vector;

public class Polygon extends Shape implements RayDetectable{
	ArrayList<Vector> vector_list = new ArrayList<Vector>();
	
	public Polygon(Vector center, ArrayList<Vector> list) {
		super(center);
		this.vector_list = list;
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Vector> getlines() {
		return this.vector_list;
	}
	@Override
	public double distanceToPoint(Vector point) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double distanceToPointCircle(Vector point) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<Vector> getPoints(Vector projection) {
		// TODO Auto-generated method stub
		return this.getlines();
	}
}
