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
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela,new Alignment(new BoidRuleBase()));
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb,new Alignment(new BoidRuleBase()));
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc,new Alignment(new BoidRuleBase()));
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		
		System.out.println(a.getAcceleration());
		System.out.println(b.getAcceleration());
		System.out.println(c.getAcceleration());
		
		Vector Ga = Vector.add(velb, velc);
		Ga.divide(2);
		Ga.subtract(vela);
		Vector Gb = Vector.add(vela, velc);
		Gb.divide(2);
		Gb.subtract(velb);
		Vector Gc = Vector.add(vela, velb);
		Gc.divide(2);
		Gc.subtract(velc);
		
		assertEquals(true,a.getAcceleration().isEqual(Ga));
		assertEquals(true,b.getAcceleration().isEqual(Gb));
		assertEquals(true,c.getAcceleration().isEqual(Gc));
	}
	@Test
	void testCohesion() {
		Vector vela = new Vector(10,10);
		Vector velb = new Vector(-10,-10);
		Vector velc = new Vector(10,0);
		Vector posa = new Vector(10,10);
		Vector posb = new Vector(10,60);
		Vector posc = new Vector(50,40);
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela,new Cohesion(new BoidRuleBase()));
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb,new Cohesion(new BoidRuleBase()));
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc,new Cohesion(new BoidRuleBase()));
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		
		System.out.println(a.getAcceleration());
		System.out.println(b.getAcceleration());
		System.out.println(c.getAcceleration());
		
		Vector Ga = Vector.add(posb, posc);
		Ga.divide(2);
		Ga.subtract(posa);
		Vector Gb = Vector.add(posa, posc);
		Gb.divide(2);
		Gb.subtract(posb);
		Vector Gc = Vector.add(posa, posb);
		Gc.divide(2);
		Gc.subtract(posc);
		
		assertEquals(true,a.getAcceleration().isEqual(Ga));
		assertEquals(true,b.getAcceleration().isEqual(Gb));
		assertEquals(true,c.getAcceleration().isEqual(Gc));
	}
	@Test
	void testSeperation() {
		Vector vela = new Vector(10,10);
		Vector velb = new Vector(-10,-10);
		Vector velc = new Vector(10,0);
		Vector posa = new Vector(10,10);
		Vector posb = new Vector(10,60);
		Vector posc = new Vector(50,40);
		Bird a = new Bird((int)posa.getxComponent(),(int)posa.getyComponent(),vela,new Separation(new BoidRuleBase()));
		Bird b = new Bird((int)posb.getxComponent(),(int)posb.getyComponent(),velb,new Separation(new BoidRuleBase()));
		Bird c = new Bird((int)posc.getxComponent(),(int)posc.getyComponent(),velc,new Separation(new BoidRuleBase()));
		
		a.preBehaviour();
		b.preBehaviour();
		c.preBehaviour();
		
		Boid.sight(a, b);
		Boid.sight(a, c);
		Boid.sight(b, c);
		
		a.behaviour();
		b.behaviour();
		c.behaviour();
		
		assertEquals(true,a.getAcceleration().isEqual(new Vector(-22.5,-45.0)));
		assertEquals(true,b.getAcceleration().isEqual(new Vector(-28.1249,42.1875)));
		assertEquals(true,c.getAcceleration().isEqual(new Vector(50.625,2.8125)));
	}

}
