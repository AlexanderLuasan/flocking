package boid;


import ray.Ray;
import vector.Vector;

public class BirdWithSight extends FleeAndChaseBird {

	protected static final double SIGHT_DISTANCE = 100.0;
	protected Ray Sight;
	public BirdWithSight(int x, int y, Vector vel) {
		super(x, y, vel);
		Sight = new ray.Ray();
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
		
		double distance = Sight.trace(SIGHT_DISTANCE);
		
		if(distance < 0 ) {//if there is nothing in the way 
			//don't change
		}else {
			//zero the acceleration
			this.acceleration.setComponents(0, 0);
			boolean s = Sight.search(SIGHT_DISTANCE);
			if(s) {
				Vector avoidDirection = Sight.getDirection();
				avoidDirection.scale(1);
				//avoidDirection = Vector.subtract(avoidDirection, velocity);
				this.velocity.copy(avoidDirection);//this is a bad use
				//this.acceleration.add(avoidDirection);
			}
			
			
		}
		return false;
	}


	protected double getSightDistance() {
		return SIGHT_DISTANCE;
	}

}
