package xmlReader;

import shape.*;
import utils.Utils;
import vector.Vector;

import org.w3c.dom.*;

import graphics.Screen;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

/*
class xmlReadin{

	public xmlReadin(String fileLocation) //inialize the read in
	
	public ArrayList<Shape> getEnviroment() get a list of all shape to be draw and used as obstacles
	
	public ArrayList<BoidStructure> getAllboids() //get a list of shapes
	
	public int getWidth();					//to be used in the screensize
	public int getHeight();
	
	private BoidStructure mk_boid (xml element); interal seperation
	private shape mk_rect (xml element);
	private shape mk_polygon (xml element);
	private shape mk_circle (xml element);




}
 */


public class xmlReadin {
	private ArrayList<Shape> listofshapes = new ArrayList<Shape>();
	private int width;
	private int height;
	
	public static void main(String args[]) {
		System.out.println("xml");
		xmlReadin xml1 = new xmlReadin("CS3343.tmx");
		
		Screen Window = new Screen(Utils.SCREEN_WIDTH,Utils.SCREEN_HIEGHT);
		
		for(int i = 0; i< xml1.listofshapes.size(); i++) {
			Window.getToDraw().add(xml1.listofshapes.get(i));
		}
		Window.getToDraw().add(new Circle(new Vector(100,100),50));
		Window.updateFrameBuffer();
		Window.repaint();
		
		
		
	}
	
	public xmlReadin(String fileLocation) {
		try {
			File inputFile = new File(fileLocation);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        
	        NodeList screen = doc.getElementsByTagName("map");
	        // should read width and height times them by 50 to get the width and height pixel
	        
	        NodeList nList = doc.getElementsByTagName("object");
	        for (int temp = 0; temp < nList.getLength(); temp++) { 
	        	Node nNode = nList.item(temp);
	        	//add all the element in the object group to the listofshapes
	        	if(nNode.getNodeType() == Node.ELEMENT_NODE) {
	        		Element eElement = (Element) nNode;
	        		if(eElement.getAttribute("name").equals("rectangle")) {
	        			double x = Double.parseDouble(eElement.getAttribute("x")); 
	        			double y = Double.parseDouble(eElement.getAttribute("y"));
	        			int width = Integer.parseInt(eElement.getAttribute("width"));;
	        			int height = Integer.parseInt(eElement.getAttribute("height"));;
	        			Vector point = new Vector(x,y);
	        			Rectangle rect = new Rectangle(point, width, height);
	        			listofshapes.add(rect);
	        			System.out.print("test");
	        			
	        		} else if(eElement.getAttribute("name").equals("circle")) {
	        			
	        		} else if(eElement.getAttribute("name").equals("polygon")) {
	        			
	        		}
	        		System.out.print("test");
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Shape> getEnvironment() {
		return this.listofshapes;
		
	}
	
	public ArrayList<BoidStructure> getAllboids() {
		return null;
		
	}
	
	public int getWidth() {
		return this.width;
		
	}
	
	public int getHeight() {
		return this.height;
		
	}
}
