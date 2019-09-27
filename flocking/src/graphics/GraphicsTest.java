package graphics;

import java.util.ArrayList;

import shape.*;
import vector.Vector;
public class GraphicsTest {
	
	
	public static void main(String[] args) {
		
		System.out.println("Start Graphics Test");
		Screen test = new Screen(1000, 500);
		
		test.getToDraw().add(new Circle(new Vector(100,300) , 50));
		
		
	}

}
