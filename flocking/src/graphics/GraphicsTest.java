package graphics;

import shape.Triangle;
import vector.Vector;
public class GraphicsTest {
	
	
	public static void main(String[] args) {
		System.out.println("Start Graphics Test");
		Screen test = new Screen(1000, 500);
		
		test.getToDraw().add(new Triangle(new Vector(100,100),new Vector(200,200),new Vector(100,200)));
		
	}

}
