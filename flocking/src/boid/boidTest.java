package boid;

import vector.Vector;
import utils.*;
public class boidTest {

		public static void main(String [] args) {
			System.out.println("boid test");
			
			Log myLog = Log.getLog();
			int DEBUG_CODE = Log.DEBUG+Log.BOIDS;
			
			Bird a = new Bird(100,100,new Vector(1,0));//bird heading east at 100,100
			Bird b = new Bird(100,110,new Vector(1,0));//bird flying parallel 10 units bellow
			myLog.println(a, DEBUG_CODE);
			myLog.println(b, DEBUG_CODE);
			myLog.println("movement");
			a.movement();
			b.movement();
			myLog.println(a, DEBUG_CODE);
			myLog.println(b, DEBUG_CODE);
			myLog.println("calulate the cohesion force");
			a.cohesion(b);
			b.cohesion(a);
			a.behaviour();
			b.behaviour();
			myLog.println(a.getAcceleration(),DEBUG_CODE);
			myLog.println(b.getAcceleration(),DEBUG_CODE);
			
			myLog.println("calulate the align force", DEBUG_CODE);
			Bird c = new Bird(100,100,new Vector(1,0));
			Bird d = new Bird(110,110,new Vector(0,1));
			myLog.println(c, DEBUG_CODE);
			myLog.println(d, DEBUG_CODE);
			c.align(d);
			d.align(c);
			c.behaviour();
			d.behaviour();
			myLog.println(c.getAcceleration(),DEBUG_CODE);
			myLog.println(d.getAcceleration(),DEBUG_CODE);
			
			
			myLog.println("calulate the align force", DEBUG_CODE);
			Bird e = new Bird(200,200,new Vector(1,0));
			Bird f = new Bird(200,210,new Vector(1,0));
			myLog.println(e, DEBUG_CODE);
			myLog.println(f, DEBUG_CODE);
			e.separation(f);
			f.separation(e);
			e.behaviour();
			f.behaviour();
			myLog.println(e.getAcceleration(), DEBUG_CODE);
			myLog.println(f.getAcceleration(), DEBUG_CODE);
			
			
		}
}
