package shape;

import java.util.ArrayList;

import vector.Vector;

public class Polygon extends Shape{
	ArrayList<Vector> vector_list = new ArrayList<Vector>();
	
	public Polygon(Vector center, ArrayList<Vector> list) {
		super(center);
		this.vector_list = list;
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Vector> getlines() {
		return this.vector_list;
		
	}
}
