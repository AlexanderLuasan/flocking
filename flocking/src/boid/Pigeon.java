package boid;

import graphics.Colors;
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
public class Pigeon extends BirdWithSight {
	protected double getMAX_ACCELERATION() 	{	return MAX_ACCELERATION;	}
	protected double getMAX_SPEED() 		{	return MAX_SPEED;			}
	protected double getMIN_SPEED() 		{	return MIN_SPEED;			}
	protected double getSIGHT_RANGE() 		{	return SIGHT_RANGE;			}
	protected double getALIGNMENT_WEIGHT() 	{	return ALIGNMENT_WEIGHT;	}
	protected double getSEPARATION_WEIGHT() {	return SEPARATION_WEIGHT;	}
	protected double getCOHESION_WEIGHT() 	{	return COHESION_WEIGHT;		}
	protected double getCHASE_WEIGHT() 		{	return CHASE_WEIGHT;		}
	protected double getFLEE_WEIGHT() 		{	return 20;					}
	protected double getSightDistance() 	{	return RAY_TRACE_DISTANCE;	}
	public Pigeon(int x, int y, Vector vel) {
		super(x, y, vel);
	}
	public void seeBoid(Boid other){
		
		if(!other.prey()) {
			this.flee((Bird)other);
		}else {
			this.align((Bird)other);
			this.cohesion((Bird)other);
			this.separation((Bird)other);
		}
	}
	public Colors getColor() {
		return Colors.GREEN;
	}
}
