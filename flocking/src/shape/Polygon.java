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
	public double minimumDistanceToLines(Vector Point) {
		
		double minimum = -2;
		for(int i=0;i<vector_list.size()-1;i++) {
			Vector Line = Vector.subtract(vector_list.get(i), vector_list.get(i+1));
			double lineLength = Line.getLength();
			Line.normalize();
			
			Vector point = Vector.subtract(Vector.add(vector_list.get(i),this.center), Point);
			double project = Line.dotProduct(point);
			if(project>0 && project < lineLength) {//within the line
				
				Vector perpendiular = Line.perpendicular();
				double distance = perpendiular.dotProduct(Point);
				if(Math.abs(distance)<minimum) {
					minimum = Math.abs(distance);
				}
				if(minimum<0) {
					minimum = Math.abs(distance);
				}
			}
		}	
		return minimum;
	}
}
