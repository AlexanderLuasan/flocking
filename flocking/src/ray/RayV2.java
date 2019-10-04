package ray;

import java.util.ArrayList;

import vector.Vector;

public class RayV2 extends Ray {

	public RayV2() {
		
	}
	public double trace(double limitDistance) {
		
		
		Vector prependiular = this.getDirection().perpendicular();
		//create the perpendicular vector
		
		//for each object
		
		for(int i=0;i<rayDetectable.size();i++) {
			//get its points
			ArrayList<Vector> points = rayDetectable.get(i).getPoints(prependiular);
			//make a new copy of its points/have the shape always give a new copy
			//shift the points to put us at the center
			for(int ii=0;ii<points.size();ii++) {
				points.add(this.getStartPoint());
			}
			
			//check the perpendicular colision
			boolean positive = false;
			boolean negative = false;
			for(int ii=0;ii<points.size();ii++) {
				//project each point see if one is positive or negative
				double porjection = prependiular.dotProduct(points.get(ii));
				if(porjection>0) {
					positive=true;
				}else if(porjection<0) {
					negative=true;
				}
			}
			
			//if so check the regular position
			if(positive && negative) {
				//project each point see if one is positive or negative
				
				boolean allPositive = true;
				double minimum = -10;
				for(int ii=0;ii<points.size();ii++) {
					double porjection = this.getDirection().dotProduct(points.get(ii));
					if(porjection<0) {
						allPositive=false;
						break;
					}
					if(porjection<minimum) {
						minimum=porjection;
					}
					if(minimum<0) {
						minimum=porjection;
					}
				}
				//if positive calulate the colost point and return
				if(allPositive) {// it is infront of us
					return minimum;
				}
				//else move on it was behind us
			}	
		}
		return -1;
	}
}
