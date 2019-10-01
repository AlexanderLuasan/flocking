package boid;

import vector.Vector;
import graphics.*;
import ray.Ray;
import shape.Circle;
import utils.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class boidTest {
		static int NUMBER_OF_BIRDS = 10;
		static int SPEED_RANGE = 5;
		static int DEBUG_CODE = Log.DEBUG+Log.BOIDS;
		public static void main(String [] args) {
			mathtest();
			Log myLog = Log.getLog();
			
			ArrayList<Bird> birds = new ArrayList<Bird>();
			//Bird a = new Bird(100, 100, new Vector(0,1));
			//birds.add(a);
			Random rand = new Random();
			for(int i=0;i<NUMBER_OF_BIRDS;i++) {
				int xpos = rand.nextInt(utils.Utils.SCREEN_WIDTH);
				int ypos = rand.nextInt(utils.Utils.SCREEN_HIEGHT);
				double xcomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				double ycomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				birds.add(new BirdWithSight(xpos,ypos,new Vector(xcomp,ycomp)));
				
			}
			
			//add shapes
			ArrayList<Circle> env = new ArrayList<Circle>();
			env.add(new Circle(new Vector(200,200),50));
			
			
			
			
			
			graphics.Screen window = new graphics.Screen(utils.Utils.SCREEN_WIDTH,utils.Utils.SCREEN_HIEGHT);
			for(int i=0;i<birds.size();i++) {
				window.getToDraw().add((Drawable)birds.get(i));
			}
			for(int i=0;i<env.size();i++) {
				window.getToDraw().add(env.get(i));
				Ray.getRaydetectable().add(env.get(i));
			}
			
			
			
			boolean done = false;
			while(!done) {
				
				
				for(int i=0;i<birds.size();i++) {
					birds.get(i).preBehaviour();
				}
				for(int i=0;i<birds.size()-1;i++) {
					for(int ii=i+1;ii<birds.size();ii++) {
						Boid.sight(birds.get(i), birds.get(ii));
					}
				}
				for(int i=0;i<birds.size();i++) {
					birds.get(i).behaviour();
				}
				for(int i=0;i<birds.size();i++) {
					birds.get(i).movement();
				}
				
				//myLog.println(a, DEBUG_CODE);
				
				window.updateFrameBuffer();
				window.repaint();
				try {
					TimeUnit.MILLISECONDS.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
					done = true;
				}
			}
			
		}
		public static void mathtest() {
			System.out.println("boid test");
			
			Log myLog = Log.getLog();
			
			
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
			
			
			myLog.println("calulate the seperation force", DEBUG_CODE);
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
