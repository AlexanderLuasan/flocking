package graphics;

public class line implements DrawableLine {
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	@Override
	public int get1pointX() {
		return this.x1;
	}
	@Override
	public int get1pointY() {
		return this.y1;
	}
	@Override
	public int get2pointX() {
		return this.x2;
	}
	@Override
	public int get2pointY() {
		return this.y2;
	}
}
