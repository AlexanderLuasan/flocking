package flocking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import boid.Bird;
import boid.Boid;
import graphics.Drawable;
import graphics.Screen;
import utils.Utils;
import vector.Vector;
public class Main {
	public static Screen Window;
	
	static int NUMBER_OF_BIRDS = 1000;
	static int SPEED_RANGE = 5;
	public static void main(String[] args) {
		System.out.println("Welcome to Boids!");
		Window = new Screen(Utils.SCREEN_WIDTH,Utils.SCREEN_HIEGHT);
		setUpBoids();
		
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
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
				done = true;
			}
		}

	}
	public static void setUpBoids() {
		//create boids
		Random rand = new Random();
		for(int i=0;i<NUMBER_OF_BIRDS;i++) {
			int xpos = rand.nextInt(utils.Utils.SCREEN_WIDTH);
			int ypos = rand.nextInt(utils.Utils.SCREEN_HIEGHT);
			double xcomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
			double ycomp = (SPEED_RANGE*2*rand.nextDouble())-SPEED_RANGE;
			new Bird(xpos,ypos,new Vector(xcomp,ycomp));
				
		}
		//add birds to screen
		for(int i=0;i<Bird.getAllBirds().size();i++) {
			Window.getToDraw().add((Drawable)Bird.getAllBirds().get(i));
		}
	}

}
