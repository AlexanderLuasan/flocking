package boid;

import graphics.Colors;
import vector.Vector;
/*

Hawk
	
	sight range big
	
	chase
		any prey
	flock only with hawks
	
	


 */

public class Hawk extends BirdWithSight {
	protected double getMAX_ACCELERATION() 	{	return MAX_ACCELERATION;	}
	protected double getMAX_SPEED() 		{	return MAX_SPEED*1.5;			}
	protected double getMIN_SPEED() 		{	return MIN_SPEED;			}
	protected double getSIGHT_RANGE() 		{	return 200;			}
	protected double getALIGNMENT_WEIGHT() 	{	return ALIGNMENT_WEIGHT;	}
	protected double getSEPARATION_WEIGHT() {	return SEPARATION_WEIGHT;	}
	protected double getCOHESION_WEIGHT() 	{	return COHESION_WEIGHT;		}
	protected double getCHASE_WEIGHT() 		{	return CHASE_WEIGHT;		}
	protected double getFLEE_WEIGHT() 		{	return FLEE_WEIGHT;			}
	protected double getSightDistance() 	{	return SIGHT_DISTANCE;		}
	public Hawk(int x, int y, Vector vel) {
		super(x, y, vel);
		
	}
	public void seeBoid(Boid other){
		
		if(other.prey()) {
			this.chase((Bird)other);
			if(Boid.distance(this, other)<2) {//eat
				((Bird)other).remove();
			}
		}else if(other.getClass()==Hawk.class) {//join only with other hawks
			this.align((Bird)other);
			this.cohesion((Bird)other);
			this.separation((Bird)other);
		}
		
	}
	public boolean prey() {
		return false;
	}
	public Colors getColor() {
		return Colors.RED;
	}

}
