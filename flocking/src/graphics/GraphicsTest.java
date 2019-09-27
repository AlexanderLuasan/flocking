package graphics;

import java.util.ArrayList;
import shape.*;
import vector.Vector;
import java.time.*;
public class GraphicsTest {
	
	
	public static void main(String[] args) {
		
		System.out.println("Start Graphics Test");
		Screen test = new Screen(1000, 500);

		ArrayList<Vector> list = new ArrayList<Vector>();
		list.add(new Vector(300,250));
		list.add(new Vector(350,400));
		list.add(new Vector(300,350));
		list.add(new Vector(250,400));

		test.getToDraw().add(new Circle(new Vector(100,300) , 50));
		test.getToDraw().add(new Rectangle(new Vector(300,100), 50, 70));
		test.getToDraw().add(new Polygon(new Vector(300,300), list));
	}

}
