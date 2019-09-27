package utils;

import vector.Vector;
import java.math.*;
public class Utils {
	public static int SCREEN_HIEGHT = 600;
	public static int SCREEN_WIDTH = 600;
	
	public static double round(double input) {
		input*=1000;
		input=Math.round(input);
		return input/1000;
	}
	public static double distance(Vector a, Vector b) {
		double x = a.getxComponent()-b.getxComponent();
		double y = a.getyComponent()-b.getyComponent();
		return Math.sqrt(x*x+y*y);
	}
}
