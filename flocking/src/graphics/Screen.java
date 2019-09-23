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

import shape.Circle;
import java.awt.*;

public class Screen extends JFrame {

	public Screen(int width, int height){
		setVisible(true);
		setResizable(false);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 300, 300);
	}
	
	public void drawCircle(Graphics g) {
		Circle a = new Circle(100,100, 10);
		//g.drawOval(a.getCenterX(), a.getCenterY(), a.getRadius(), a.getRadius());
	}
	
	public void drawLine() {
		Line l = new Line();
	}
	
}
