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
import utils.Utils;

public class Screen extends JFrame {

	//add width and height
	private BufferedImage FrameBuffer;
	private BufferedImage RotationBuffer;
	
	private ArrayList<Drawable> toDraw = new ArrayList<Drawable>();
	
	private Vector viewPoint;
	
	public Screen(int width, int height){
		viewPoint=new Vector(0,0);
		setVisible(true);
		setResizable(false);
		setSize(width,height);
		FrameBuffer =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		RotationBuffer =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		validate();
	}
	
	//it will go through arraylist and draw each
	public void updateFrameBuffer() {
		//Graphics g = RotationBuffer.createGraphics();
		Graphics g = FrameBuffer.createGraphics();
		g.clearRect(0,0,Utils.SCREEN_WIDTH,Utils.SCREEN_HIEGHT);
		//rotationG.clearRect(0,0,Utils.SCREEN_WIDTH,Utils.SCREEN_HIEGHT);
		g.setColor(Color.BLUE);
		for(int i=0;i<toDraw.size();i++) {
			vector.Vector c = new Vector(Utils.SCREEN_WIDTH/2,Utils.SCREEN_HIEGHT/2);
			c.subtract(viewPoint);
			draw(toDraw.get(i),g,c);
		}
		//shift image by view point
		
		//rotationG.drawImage(RotationBuffer, Utils.SCREEN_WIDTH/2 -(int)Math.round(viewPoint.getxComponent()), Utils.SCREEN_HIEGHT/2 -(int)Math.round(viewPoint.getyComponent()), this);
		
		//draw a part to the left or the right

		

		
		
		
		
		//rotationG.drawImage(RotationBuffer, this.getWidth()/2 -(int)Math.round(viewPoint.getxComponent()), -this.getHeight()/2 -(int)Math.round(viewPoint.getyComponent()), this);
		
		
	}
	public void paint(Graphics g) {
		
		g.drawImage(FrameBuffer, 0, 0, this);
	}
	
	//draw a shape in arraylist
	public void draw(Drawable shape, Graphics g, Vector center) {
		if(shape.getColor()!= Colors.NOCOLOR){
			setColor(g,shape.getColor());
		}
		center.add(shape.getCenter());
		
		//adjust center for the edge of screen
		if(center.getxComponent()<0) {
			center.setxComponent(center.getxComponent()+utils.Utils.SCREEN_WIDTH);
		}else if(center.getxComponent()>utils.Utils.SCREEN_WIDTH) {
			center.setxComponent(center.getxComponent()-utils.Utils.SCREEN_WIDTH);
		}
		if(center.getyComponent()<0) {
			center.setyComponent(center.getyComponent()+utils.Utils.SCREEN_HIEGHT);
		}else if(center.getyComponent()>utils.Utils.SCREEN_HIEGHT) {
			center.setyComponent(center.getyComponent()-utils.Utils.SCREEN_HIEGHT);
		}
		
		if(shape.getRadius()>0) {
			this.draw_circle(center, shape.getRadius(), g);
		}
		if(shape.getWidth()>0 && shape.getHeight()>0) {
			this.draw_rectangle(center, shape.getWidth(), shape.getHeight(), g);
		}
		if(shape.getlines()!=null) {
			this.draw_polygon(center, shape.getlines(), g);
		}
		
		//draw_center(center, g);
		
		if(shape.getDrawables()!=null) {
			for(int i=0;i<shape.getDrawables().size();i++) {
				Vector subCenter = new Vector(0,0);
				subCenter.copy(center);
				draw(shape.getDrawables().get(i),g,subCenter);
			}
		}
	}

	public void setColor(Graphics g, Colors color) {
		
		switch(color) {
			case RED:
				g.setColor(Color.RED);
				break;
			case BLUE:
				g.setColor(Color.BLUE);
				break;
			case YELLOW:
				g.setColor(Color.YELLOW);
				break;
			case GREEN:
				g.setColor(Color.GREEN);
				break;
			case ORANGE:
				g.setColor(Color.ORANGE);
				break;
			case PURPLE:
				g.setColor(Color.MAGENTA);
				break;
			case GRAY:
				g.setColor(Color.GRAY);
				break;
			case WHITE:
				g.setColor(Color.WHITE);
				break;
			case BLACK:
				g.setColor(Color.BLACK);
				break;
			default:
				g.setColor(Color.BLACK);
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

	public Vector getViewPoint() {
		return viewPoint;
	}
}
