package boid;

import boidold.BirdWithSight;
import graphics.Colors;
import vector.Vector;
/*

class Hawk{
	
	sight range big
	
	chase
		any prey
	flock only with hawks
	
}	


 */






public class Hawk extends Bird {
	private static BoidRule makeHawkRules() {
		BoidRule r = new BoidRuleBase();
		r = new Alignment(r,1);
		r = new Cohesion(r,1);
		r = new Separation(r,1);
		r = new Chase(r,1);
		r = new Sight(r,100);
		return r;
	}
	public Hawk(int x, int y, Vector vel) {
		super(x, y, vel,makeHawkRules());
		
	}
	public boolean prey() {
		return false;
	}
	public Colors getColor() {
		return Colors.RED;
	}

}
