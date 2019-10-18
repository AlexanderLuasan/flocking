package boid;


import ray.Ray;
import vector.Vector;
/*
class BirdWithSight super FleeAndChaseBird{
	
ok	RAY_TRACE_DISTANCE at what distance do we worry about the hitting an object
ok	Ray Sight each boid has a ray that it uses to do the calulation
ok	behaviour() run the normal function then check if this puts you on a collision path
				using the ray if so replace the acceleration with a new one that avoids the object	
}
 */
public class BirdWithSight extends FleeAndChaseBird {

	protected static final double RAY_TRACE_DISTANCE = 75.0;
	protected Ray Sight;
	public BirdWithSight(int x, int y, Vector vel) {
		super(x, y, vel);
		Sight = new ray.Ray();
	}
	public BirdWithSight(int x, int y, Vector vel, Ray si) {
		super(x, y, vel);
		Sight = si;
	}
	
	
	public boolean behaviour() {
		this.acceleration.setComponents(0, 0);

		super.behaviour();
		
		
		//
		
		Vector pos = new Vector(0,0);
		pos.copy(position);
		Sight.setStartPoint(pos);
		Vector dir = new Vector(0,0);
		dir.copy(this.velocity);
		Sight.setDirection(dir);
		
		double distance = Sight.trace(getRayDistance());
		
		if(distance < 0 ) {//if there is nothing in the way 
			Vector testVelocity = Vector.add(this.velocity, this.acceleration);
			pos.copy(position);
			Sight.setStartPoint(pos);
			dir.copy(testVelocity);
			Sight.setDirection(dir);
			distance = Sight.trace(getRayDistance());
			if(distance < 0 ) {
				//changing does not put me in danger
			}else {
				//changing puts me in danger
				this.acceleration.setComponents(0, 0);
			} 
			
		}else {
			//zero the acceleration
			this.acceleration.setComponents(0, 0);
			boolean s = Sight.search(getRayDistance());
			if(s) {
				Vector avoidDirection = Sight.getDirection();
				
				//foced based
				if(false) {
					avoidDirection.scale(this.velocity.getLength());
					Vector trunFoce = Vector.subtract(avoidDirection, this.velocity);
					trunFoce.divide(distance/this.velocity.getLength());
					this.velocity.add(trunFoce);
				}else {
					//angle based
					this.velocity.setAngle(avoidDirection.getAngle());
				}
				
				//this.acceleration.add(trunFoce);
				log.println("Boid Avoided Object",this.DEBUG);
			}
			
			
		}
		return false;
	}


	protected double getRayDistance() {
		return RAY_TRACE_DISTANCE;
	}
	protected Ray getSight() {
		return Sight;
	}
	protected void setSight(Ray sight) {
		Sight = sight;
	}

}
