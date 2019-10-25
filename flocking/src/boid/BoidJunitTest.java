package boid;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.Utils;
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

	
	@Test
	void testHawkPigeon() {
		
		Bird a = new Hawk(100,100,new Vector(1,0));
		Bird b = new Pigeon(150,100,new Vector(1,0));
		
		a.preBehaviour();
		b.preBehaviour();
	
		Boid.sight(a, b);
		
		a.behaviour();
		b.behaviour();
		//all that should be there is the chase acceleration and flee
		
		
		assertEquals(true,a.getAcceleration().isEqual(new Vector(100,0))); // Hawk flys to the differnce in position chase force is double
		assertEquals(true,b.getAcceleration().isEqual(new Vector(50,0))); // pigeon flys to difference in position inversed
	}
	@Test
	void testHawkPigeonOutOfRange() {
		
		Bird a = new Hawk(100,100,new Vector(1,0));
		Bird b = new Pigeon(180,100,new Vector(1,0));
		
		a.preBehaviour();
		b.preBehaviour();
	
		Boid.sight(a, b);
		
		a.behaviour();
		b.behaviour();
		//all that should be there is the chase acceleration and flee
		
		
		assertEquals(true,a.getAcceleration().isEqual(new Vector(0,0))); // Hawk flys to the differnce in position
		assertEquals(true,a.getAcceleration().isEqual(new Vector(0,0))); // pigeon flys to difference in position inversed
	}
	@Test
	void testDynamicCreation() {
		Bird a = new Bird(100,100,new Vector(0,1),new BoidRuleBase());
		Bird b = new Bird(100,100,new Vector(1,0),new BoidRuleBase());
		
		a.preBehaviour();
		b.preBehaviour();
		
		Boid.sight(a, b);
		
		a.behaviour();
		b.behaviour();
		
		a.movement();
		b.movement();
		
		//shoud have no effect so they just move the minmium distance of two
		
		assertEquals(true,a.getPositionVector().isEqual(new Vector(100,102)));
		assertEquals(true,b.getPositionVector().isEqual(new Vector(102,100)));
		
		a.pushRule(new Cohesion());
		b.pushRule(new Cohesion());
		
		
		a.preBehaviour();
		b.preBehaviour();
		
		Boid.sight(a, b);
		
		a.behaviour();
		b.behaviour();
		
		assertEquals(true,a.getAcceleration().isEqual(new Vector(2,-2)));
		assertEquals(true,b.getAcceleration().isEqual(new Vector(-2,2)));
		
		
	}
	@Test
	void testOverTheTop() {
		Bird a = new Bird(100,2,new Vector(0,-4),new BoidRuleBase());
		a.movement();
		assertEquals(true,a.getPositionVector().isEqual(new Vector(100,Utils.SCREEN_HIEGHT-2)));
		
	}
	@Test
	void testOverTheSide() {
		Bird a = new Bird(2,130,new Vector(-6,0),new BoidRuleBase());
		a.movement();
		assertEquals(true,a.getPositionVector().isEqual(new Vector(Utils.SCREEN_WIDTH-3,130))); // note max speed of 5
	}
	@Test
	void testdiagnol() {
		Bird a = new Bird(Utils.SCREEN_WIDTH-2,Utils.SCREEN_HIEGHT-1,new Vector(4,2),new BoidRuleBase());
		a.movement();
		assertEquals(true,a.getPositionVector().isEqual(new Vector(2,1)));
	}
}
