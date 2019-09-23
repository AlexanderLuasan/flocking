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
import java.util.ArrayList;
public class Screen extends JFrame {

	private ArrayList<Drawable> toDraw = new ArrayList<Drawable>();
	
	public Screen(int width, int height){
		setVisible(true);
		setResizable(false);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		for(int i=0;i<toDraw.size();i++) {
			draw(toDraw.get(i),g);
		}
	}
	
	
	public void drawCircle(Graphics g) {
		Circle a = new Circle(100,100, 10);
		//g.drawOval(a.getCenterX(), a.getCenterY(), a.getRadius(), a.getRadius());
	}
	
	public void draw(Drawable d, Graphics g) {
		if(d.Radius()>0) {
			g.drawOval(d.getCenterX()-d.Radius(), d.getCenterY()-d.Radius(),d.Radius()*2, d.Radius()*2);
		}
		if(d.Line()!=null) {
			g.drawLine(d.getCenterX(), d.getCenterY(), (int)d.Line().getxComponent(), (int)d.Line().getyComponent());
		}
		if(d.getComponents()!=null) {
			for(int i=0;i<d.getComponents().size();i++) {
				draw(d.getComponents().get(i),g);
			}
		}
		
	}
	
	public void drawLine() {
		Line l = new Line();
	}

	protected ArrayList<Drawable> getToDraw() {
		return toDraw;
	}

	protected void setToDraw(ArrayList<Drawable> toDraw) {
		this.toDraw = toDraw;
	}
	
}
