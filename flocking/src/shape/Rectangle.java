package shape;

import vector.Vector;

public class Rectangle extends Shape {
	private int width;
	private int height;
	public Rectangle(Vector center, int width, int height) {
		super(center);
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
}
