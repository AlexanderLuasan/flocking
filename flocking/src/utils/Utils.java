package utils;

public class Utils {
	public static double round(double input) {
		input*=1000;
		input=Math.round(input);
		return input/1000;
	}
}
