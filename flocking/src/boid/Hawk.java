package boid;

import graphics.Colors;
import vector.Vector;

public class Hawk extends Bird {

	private static BoidRule DrawingBasic(){
		BoidRule end = new BoidRuleBase();
		end = new Chase(end,2,Pigeon.class);
		end = new DrawingRule(end,Colors.YELLOW);
		end = new Alignment(end,1);
		end = new DrawingRule(end,Colors.YELLOW);
		end = new Separation(end,1);
		end = new DrawingRule(end,Colors.RED);
		end = new Cohesion(end,1);
		end = new DrawingRule(end,Colors.GREEN);
		end = new DrawingSight(end);
		return end;
	}
	public Hawk(int x, int y, Vector vel) {
		super(x, y, vel,DrawingBasic());
	}
}
