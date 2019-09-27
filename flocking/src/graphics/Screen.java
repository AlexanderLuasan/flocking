package graphics;
/*
 * 
 * unimplemented
 * class Screen{
 * 		
 * 		list list Drawables;
 * 
 *			you will recive a bunch of drawables lists at the begining of the program each flip iterate through and draw each item
 *			make this a singleton pattern.
 * 		public Screen(int width, int height); // on defult constructor just pick a size
 * 		public bool addDrawablesList(ArrayList<Drawable>); // you could receive more than one
 *      public flip(): // redraw the screen
 *      private drawDrawable(Drawable);// draw a single shape
 * 		public getWidth();
 * 		public getHeight();
 * 			https://www.youtube.com/watch?v=XRuGQi45mG4 video tutorial
 * 			look at this vid for setup and such
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * */
import javax.swing.*;
import shape.*;
import java.awt.*;
import java.util.ArrayList;
import vector.Vector;

public class Screen extends JFrame {

	private ArrayList<Drawable> toDraw = new ArrayList<Drawable>();
	
	public Screen(int width, int height){
		setVisible(true);
		setResizable(false);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	//it will go through arraylist and draw each
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		for(int i=0;i<toDraw.size();i++) {
			vector.Vector c = new Vector(0,0);
			draw(toDraw.get(i),g,c);
		}
	}
	
	//draw a shape in arraylist
	public void draw(Drawable shape, Graphics g, Vector center) {
		if(shape.getRadius() > 0) {
			draw_circle(shape.getCenter(), shape.getRadius(), g);
		}
		if(shape.getWidth() > 0 && shape.getHeight() > 0) {
			draw_rectangle(shape.getCenter(), shape.getWidth(), shape.getHeight(), g);
		}
		draw_center(shape.getCenter(), g);
		
	}

	protected ArrayList<Drawable> getToDraw() {
		return toDraw;
	}

	protected void setToDraw(ArrayList<Drawable> toDraw) {
		this.toDraw = toDraw;
	}
	
	public void draw_circle(Vector center, double radius, Graphics g) {
		int x = (int) center.getxComponent();
		int y = (int) center.getyComponent();
		x -= radius;
		y -= radius;
		g.drawOval(x, y, (int) radius*2, (int) radius*2);
	}
	
	public void draw_center(Vector center, Graphics g) {
		int x = (int) center.getxComponent();
		int y = (int) center.getyComponent();
		x -= 5;
		y -= 5;
		g.drawOval(x, y, 10, 10);
	}
	
	public void draw_rectangle(Vector center, double width, double height, Graphics g) {
		int x = (int) center.getxComponent();
		int y = (int) center.getyComponent();
		x -= width/2;
		y -= height/2;
		g.drawRect(x, y, (int) width, (int) height);
	}
}
