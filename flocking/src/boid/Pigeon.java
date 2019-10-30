package boid;

import graphics.Colors;
import graphics.DrawingBird;
import graphics.DrawingRule;
import graphics.DrawingSight;
import vector.Vector;

public class Pigeon extends DrawingBird {

	private static BoidRule DrawingBasic(){
		BoidRule end = new BoidRuleBase();
		end = new Flee(end,1,Hawk.class);
		end = new DrawingRule(end,Colors.YELLOW);
		end = new Alignment(end);
		end = new DrawingRule(end,Colors.YELLOW);
		end = new Separation(end);
		end = new DrawingRule(end,Colors.RED);
		end = new Cohesion(end);
		end = new DrawingRule(end,Colors.GREEN);
		end = new DrawingSight(end);
		return end;
	}
	public Pigeon(int x, int y, Vector vel) {
		super(x, y, vel,DrawingBasic(),Colors.ORANGE);
	}


}
