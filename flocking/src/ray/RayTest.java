package ray;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import shape.Polygon;
import shape.Shape;
import vector.Vector;

class RayTest {

	@Test
	void test() {
		Ray test = new Ray();
		ArrayList<Vector> l = new ArrayList<Vector>();
		l.add(new Vector(100,0));
		l.add(new Vector(0,0));
		l.add(new Vector(0,100));
		Shape testshape = new Polygon(new Vector(300,100),l);
		
		Ray.getRaydetectable().add(testshape);
		
		test.setStartPoint(new Vector(200,150));
		test.setDirection(new Vector(0,1));
		
		double distance = test.trace(200);
		
		System.out.println(distance);
		
		
		
	}

}
