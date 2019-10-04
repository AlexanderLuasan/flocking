package ray;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import graphics.Screen;
import shape.Circle;
import shape.Rectangle;
import utils.Utils;
import vector.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RayTest {

	@Test
	public void ToTheLeft() {
		Ray.getRaydetectable().clear();
		Ray testRay = new RayV2();
		testRay.setStartPoint(new Vector(100, 100));
		testRay.setDirection(new Vector(1, 0));
		RayDetectable one = new Rectangle(new Vector(400,100), 100, 100);
		testRay.getRaydetectable().add(one);
		double distance = testRay.trace(300);
		assertEquals(true,(distance>0));
		System.out.println(distance);
	}
	
	@Test
	public void ToTheRightFail() {
		Ray.getRaydetectable().clear();
		Ray testRay = new RayV2();
		testRay.setStartPoint(new Vector(400, 100));
		testRay.setDirection(new Vector(1, 0));
		RayDetectable one = new Rectangle(new Vector(100,100), 100, 100);
		testRay.getRaydetectable().add(one);
		double distance = testRay.trace(300);
		assertEquals(true,(distance<0));
		System.out.println(distance);
	}
	@Test
	public void PositivePositive() {
		Ray.getRaydetectable().clear();
		Ray testRay = new RayV2();
		testRay.setStartPoint(new Vector(100, 100));
		testRay.setDirection(new Vector(1, 1));
		RayDetectable one = new Rectangle(new Vector(400,400), 100, 100);
		testRay.getRaydetectable().add(one);
		double distance = testRay.trace(300);
		assertEquals(true,(distance>0));
		System.out.println(distance);
	}
	@Test
	public void PositivePositiveFail() {
		Ray.getRaydetectable().clear();
		Ray testRay = new RayV2();
		testRay.setStartPoint(new Vector(100, 100));
		testRay.setDirection(new Vector(1, 1));
		RayDetectable one = new Rectangle(new Vector(200,400), 100, 100);
		testRay.getRaydetectable().add(one);
		double distance = testRay.trace(300);
		assertEquals(true,(distance<0));
		System.out.println(distance);
	}
	
	public static void main(String args[]) {
		
		Ray testRay = new RayV2();
		testRay.setStartPoint(new Vector(100, 100));
		testRay.setDirection(new Vector(1, 0));
		RayDetectable one = new Rectangle(new Vector(400,100), 100, 100);
		testRay.getRaydetectable().add(one);
		double distance = testRay.trace(300);
		System.out.println(distance);
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
