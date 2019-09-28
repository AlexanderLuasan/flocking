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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import vector.Vector;

public class Screen extends JFrame {

	//add width and height
	private BufferedImage FrameBuffer;
	
	private ArrayList<Drawable> toDraw = new ArrayList<Drawable>();
	
	public Screen(int width, int height){
		setVisible(true);
		setResizable(false);
		setSize(width,height);
		FrameBuffer =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	//it will go through arraylist and draw each
	public void updateFrameBuffer() {
		Graphics g = FrameBuffer.createGraphics();
		g.clearRect(0,0,800,800);
		g.setColor(Color.BLUE);
		for(int i=0;i<toDraw.size();i++) {
			vector.Vector c = new Vector(0,0);
			draw(toDraw.get(i),g,c);
		}
	}
	public void paint(Graphics g) {
		
		g.drawImage(FrameBuffer, 0, 0, this);
	}
	
	//draw a shape in arraylist
	public void draw(Drawable shape, Graphics g, Vector center) {
		center.add(shape.getCenter());
		if(shape.getRadius() > 0) {
			draw_circle(center, shape.getRadius(), g);
		}
		if(shape.getWidth() > 0 && shape.getHeight() > 0) {
			draw_rectangle(center, shape.getWidth(), shape.getHeight(), g);
		}
		if(shape.getlines() != null) {
			draw_polygon(center, shape.getlines(), g);
		}
		draw_center(center, g);
		
		if(shape.getDrawables()!=null) {
			for(int i=0;i<shape.getDrawables().size();i++) {
				Vector subCenter = new Vector(0,0);
				subCenter.copy(center);
				draw(shape.getDrawables().get(i),g,subCenter);
			}
		}
	}

	public ArrayList<Drawable> getToDraw() {
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
	
	public void draw_polygon(Vector center, ArrayList<Vector> list, Graphics g) {
		for(int i = 0; i < list.size(); i++) {
			Vector point1, point2;
			point1 = new Vector(list.get(i).getxComponent() ,list.get(i).getyComponent());
			point1 = Vector.add(point1, center);
			if (i == list.size()-1) {
				point2 = new Vector(list.get(0).getxComponent() ,list.get(0).getyComponent());
				point2 = Vector.add(point2, center);
			} else {
				point2 = new Vector(list.get(i+1).getxComponent() ,list.get(i+1).getyComponent());
				point2 = Vector.add(point2, center);
			}
			g.drawLine((int) point1.getxComponent(),(int) point1.getyComponent(),(int) point2.getxComponent(),(int) point2.getyComponent());
		}
	}
}
