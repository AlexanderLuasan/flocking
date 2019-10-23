package boid;

import java.util.ArrayList;

import boidold.BirdWithSight;
import graphics.Colors;
import graphics.Drawable;
import vector.Vector;
/*

class Pigeon{
	sight is small
	flee
		any predator
	join/flock
		with any but preditor
}		
 
 
 */
public class Pigeon extends Bird {
	
	
	protected double getMAX_ACCELERATION() 	{	return MAX_ACCELERATION;	}
	protected double getMAX_SPEED() 		{	return MAX_SPEED;			}
	protected double getMIN_SPEED() 		{	return MIN_SPEED;			}
	private static BoidRule makeHawkPigeon() {
		BoidRule r = new BoidRuleBase();
		r = new Alignment(r,1);
		r = new Cohesion(r,1);
		r = new Separation(r,1);
		r = new DrawingSight(r,75);
		return r;
	}
	public Pigeon(int x, int y, Vector vel) {
		super(x, y, vel,makeHawkPigeon());
		
	}
	
	
	public Colors getColor() {
		return Colors.GREEN;
	}
}
