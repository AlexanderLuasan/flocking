package flocking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import boid.Bird;
import boid.Boid;
import boid.Pigeon;
import graphics.Drawable;
import graphics.Screen;
import graphics.Timer;
import ray.Ray;
import utils.Utils;
import vector.Vector;
import xmlReader.BoidStructure;
import xmlReader.xmlReadin;
public class Main {
	public static Screen Window;
	
	
	static int SPEED_RANGE = 5;
	public static void main(String[] args) {
		System.out.println("Welcome to Boids!");
		xmlReadin world = new xmlReadin("CS3343.tmx");
		Utils.SCREEN_WIDTH = world.getWidth();
		Utils.SCREEN_HIEGHT = world.getHeight();
		
		//create boids
		for(int i=0;i<world.getAllboids().size();i++) {
			makeBoid(world.getAllboids().get(i));
		}
		
		
		Window = graphics.Screen.initScreen(1000,800); 
		Timer clock = new Timer("Clock",20);
		
		// add shapes to ray and world
		for(int i=0;i<world.getEnvironment().size();i++) {
			Window.getToDraw().add(world.getEnvironment().get(i));
			Ray.getRaydetectable().add(world.getEnvironment().get(i));
		}
		
		//add birds to screen
		for(int i=0;i<Bird.getAllBirds().size();i++) {
			Window.getToDraw().add((Drawable)Bird.getAllBirds().get(i));
		}
		
		//main loop
		boolean done = false;
		while(!done) {
			
			//clear for calculations
			for(int i=0;i<Bird.getAllBirds().size();i++) {
				Bird.getAllBirds().get(i).preBehaviour();
			}
			//see each bird
			for(int i=0;i<Bird.getAllBirds().size()-1;i++) {
				for(int ii=i+1;ii<Bird.getAllBirds().size();ii++) {
					Boid.sight(Bird.getAllBirds().get(i), Bird.getAllBirds().get(ii));
				}
			}
			//run formula
			for(int i=0;i<Bird.getAllBirds().size();i++) {
				Bird.getAllBirds().get(i).behaviour();
			}
			//move birds
			for(int i=0;i<Bird.getAllBirds().size();i++) {
				Bird.getAllBirds().get(i).movement();
			}
			
			//myLog.println(a, DEBUG_CODE);
			Window.updateFrameBuffer();
			Window.repaint();
			try {
				clock.sleep();
			} catch (InterruptedException e) {
				e.printStackTrace();
				done = true;
			}
		}

	}
	public static void makeBoid(BoidStructure bird) {
		if(bird.getType().equals("pigeon")) {
			new Pigeon(bird.getX(),bird.getY(),new Vector(bird.getVx(),bird.getVy()));
		}
		
		
		
	}

}
