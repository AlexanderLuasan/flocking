package boid;

import graphics.Colors;
import vector.Vector;

public class Pigeon extends Bird {

	private static BoidRule DrawingBasic(){
		BoidRule end = new BoidRuleBase();
		end = new Flee(end);
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
		super(x, y, vel,DrawingBasic());
	}
	public boolean prey(Boid other) {
		return false;
	}

}
