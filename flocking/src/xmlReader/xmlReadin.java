package xmlReader;

import shape.*;
import org.w3c.dom.*;
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
	
	public xmlReadin(String fileLocation) {
		try {
			File inputFile = new File("CS3343.tmx");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        
	        NodeList screen = doc.getElementsByTagName("map");
	        // should read width and height times them by 50 to get the width and height pixel
	        
	        NodeList nList = doc.getElementsByTagName("objectgroup");
	        for (int temp = 0; temp < nList.getLength(); temp++) { 
	        	Node nNode = nList.item(temp);
	        	//add all the element in the object group to the listofshapes
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
