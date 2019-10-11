package boid;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vector.Vector;

class BoidJunitTest {

	@BeforeEach
	void setUp() throws Exception {
		Bird.getAllBirds().clear();
	}
	
	@Test
	void testAlignment() {
		Vector vela = new Vector(10,10);
		Vector velb = new Vector(-10,-10);
		Vector velc = new Vector(10,0);
		Vector posa = new Vector(10,10);
		Vector posb = new Vector(10,60);
		Vector posc = new Vector(50,40);
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela);
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb);
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc);
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		
		System.out.println(a.alignment);
		System.out.println(b.alignment);
		System.out.println(c.alignment);
		
		Vector Ga = Vector.add(velb, velc);
		Ga.divide(2);
		Ga.subtract(vela);
		Vector Gb = Vector.add(vela, velc);
		Gb.divide(2);
		Gb.subtract(velb);
		Vector Gc = Vector.add(vela, velb);
		Gc.divide(2);
		Gc.subtract(velc);
		
		assertEquals(true,a.alignment.isEqual(Ga));
		assertEquals(true,b.alignment.isEqual(Gb));
		assertEquals(true,c.alignment.isEqual(Gc));
	}
	@Test
	void testCohesion() {
		Vector vela = new Vector(10,10);
		Vector velb = new Vector(-10,-10);
		Vector velc = new Vector(10,0);
		Vector posa = new Vector(10,10);
		Vector posb = new Vector(10,60);
		Vector posc = new Vector(50,40);
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela);
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb);
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc);
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		
		System.out.println(a.cohesion);
		System.out.println(b.cohesion);
		System.out.println(c.cohesion);
		
		Vector Ga = Vector.add(posb, posc);
		Ga.divide(2);
		Ga.subtract(posa);
		Vector Gb = Vector.add(posa, posc);
		Gb.divide(2);
		Gb.subtract(posb);
		Vector Gc = Vector.add(posa, posb);
		Gc.divide(2);
		Gc.subtract(posc);
		
		assertEquals(true,a.cohesion.isEqual(Ga));
		assertEquals(true,b.cohesion.isEqual(Gb));
		assertEquals(true,c.cohesion.isEqual(Gc));
	}
	@Test
	void testSeperation() {
		Vector vela = new Vector(10,10);
		Vector velb = new Vector(-10,-10);
		Vector velc = new Vector(10,0);
		Vector posa = new Vector(10,10);
		Vector posb = new Vector(10,60);
		Vector posc = new Vector(50,40);
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela);
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb);
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc);
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		assertEquals(true,a.separation.isEqual(new Vector(-22.5,-45.0)));
		assertEquals(true,b.separation.isEqual(new Vector(-28.1249,42.1875)));
		assertEquals(true,c.separation.isEqual(new Vector(50.625,2.8125)));
	}

}
