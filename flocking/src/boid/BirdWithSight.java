package boid;

import java.util.ArrayList;

import graphics.Drawable;
import ray.Ray;
import vector.Vector;

public class BirdWithSight extends Bird {

	private Ray Sight;
	public BirdWithSight(int x, int y, Vector vel) {
		super(x, y, vel);
		Sight = new ray.DrawableRay();
	}
	
	
	public boolean behaviour() {
		this.acceleration.setComponents(0, 0);

		super.behaviour();
		
		
		Vector testVelocity = Vector.add(this.velocity, this.acceleration);
		
		Vector pos = new Vector(0,0);
		pos.copy(position);
		Sight.setStartPoint(pos);
		Vector dir = new Vector(0,0);
		dir.copy(testVelocity);
		Sight.setDirection(dir);
		
		double distance = Sight.trace(100.0);
		
		if(distance < 0 ) {//if there is nothing in the way 
			//don't change
		}else {
			//zero the acceleration
			this.acceleration.setComponents(0, 0);
			boolean s = Sight.search(100.0);
			if(s) {
				Vector avoidDirection = Sight.getDirection();
				avoidDirection.scale(1);
				//avoidDirection = Vector.subtract(avoidDirection, velocity);
				this.velocity.copy(avoidDirection);
				//this.acceleration.add(avoidDirection);
			}
			
			
		}
		return false;
	}
	public ArrayList<Drawable> getDrawables() {
		ArrayList<Drawable> l = new ArrayList<Drawable>();
		Sight.getStartPoint().setZero();
		l.add((Drawable)Sight);
		
		return l;
	}

}
