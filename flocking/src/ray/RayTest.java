package ray;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import graphics.Screen;
import shape.Circle;
import utils.Utils;
import vector.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RayTest {
	static Screen window;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	public static void main(String args[]) {
		
		Ray testRay = new RayV2();
		
		double distance = testRay.trace(300);
		
		/*
		window = new Screen(Utils.SCREEN_WIDTH, Utils.SCREEN_HIEGHT);
		DrawableRay testRay = new DrawableRay();
		testRay.setStartPoint(new Vector(100, 100));
		testRay.setDirection(new Vector(1, 0));
		Circle circle = new Circle(new Vector(200, 100), 50);
		Circle circle2 = new Circle(new Vector(100, 160), 50);
		Ray.getRaydetectable().add(circle);
		Ray.getRaydetectable().add(circle2);
		window.getToDraw().add(circle);
		window.getToDraw().add(circle2);
		window.getToDraw().add(testRay);
		
		System.out.println(testRay.trace(300));

		window.repaint();
		*/
	}

}
