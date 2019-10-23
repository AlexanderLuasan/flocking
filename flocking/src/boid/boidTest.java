package boid;

import vector.Vector;
import graphics.*;
import ray.Ray;
import shape.Circle;
import shape.Polygon;
import shape.Rectangle;
import shape.Shape;
import utils.*;
import java.util.ArrayList;
import java.util.Random;


public class boidTest {
		static int NUMBER_OF_BIRDS = 40;
		static int SPEED_RANGE = 5;
		static int DEBUG_CODE = Log.DEBUG+Log.BOIDS;
		private BoidRule basic(){
			BoidRule end = new BoidRuleBase();
			end = new Alignment(end);
			end = new Separation(end);
			end = new Cohesion(end);
			return end;
		}
		
		
		public static void main(String [] args) {
			//mathtest();
			//Log myLog = Log.getLog();
			
			//myLog.setFilter(Log.BOIDS);
			
			//Bird a = new Bird(100, 100, new Vector(0,1));
			//birds.add(a);
			Random rand = new Random();
			//Boid a = new DrawingPigeon(0,0,new Vector(1,1));
			for(int i=0;i<NUMBER_OF_BIRDS;i++) {
				int xpos = rand.nextInt(utils.Utils.SCREEN_WIDTH);
				int ypos = rand.nextInt(utils.Utils.SCREEN_HIEGHT);
				double xcomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				double ycomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				new Pigeon(xpos,ypos,new Vector(xcomp,ycomp));
			}
			
			for(int i=0;i<5;i++) {
				int xpos = rand.nextInt(utils.Utils.SCREEN_WIDTH);
				int ypos = rand.nextInt(utils.Utils.SCREEN_HIEGHT);
				double xcomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				double ycomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
				//new Hawk(xpos,ypos,new Vector(xcomp,ycomp));
			}
			
			//add shapes
			ArrayList<Shape> env = new ArrayList<Shape>();
			//env.add(new Rectangle(new Vector(200,200),300,300));
			ArrayList<Vector> l = new ArrayList<Vector>();
			l.add(new Vector(100,0));
			l.add(new Vector (0,0));
			l.add(new Vector (0,100));
			env.add(new Polygon(new Vector(220,200),l));
			
			
			
			
			graphics.Screen window = new graphics.Screen(utils.Utils.SCREEN_WIDTH,utils.Utils.SCREEN_HIEGHT);
			for(int i=0;i<Bird.getAllBirds().size();i++) {
				window.getToDraw().add((Drawable)Bird.getAllBirds().get(i));
			}
			for(int i=0;i<env.size();i++) {
				window.getToDraw().add(env.get(i));
				Ray.getRaydetectable().add(env.get(i));
			}
			window.getViewPoint().setZero();
			
			Timer clock = new Timer("Clock",20);
			boolean done = false;
			while(!done) {
				
				
				for(int i=0;i<Bird.getAllBirds().size();i++) {
					Bird.getAllBirds().get(i).preBehaviour();
				}
				for(int i=0;i<Bird.getAllBirds().size()-1;i++) {
					for(int ii=i+1;ii<Bird.getAllBirds().size();ii++) {
						Boid.sight(Bird.getAllBirds().get(i), Bird.getAllBirds().get(ii));
					}
				}
				for(int i=0;i<Bird.getAllBirds().size();i++) {
					Bird.getAllBirds().get(i).behaviour();
				}
				for(int i=0;i<Bird.getAllBirds().size();i++) {
					Bird.getAllBirds().get(i).movement();
				}
				
				//myLog.println(a, DEBUG_CODE);
				//window.getViewPoint().copy(a.getPositionVector());
				window.updateFrameBuffer();
				window.repaint();
				try {
					//TimeUnit.MILLISECONDS.sleep(10);
					clock.sleep();
				} catch (InterruptedException e) {
					e.printStackTrace();
					done = true;
				}
			}
			
		}
		public static void mathtest() {
			System.out.println("boid test");
			
			Log myLog = Log.getLog();
			/*
			
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
			*/
		}
}
