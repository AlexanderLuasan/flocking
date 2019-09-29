package vector;
import utils.Utils;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class VectorJunitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "TestCreation.csv")
	public void TestCreation(String points, double px1, double py1, double px2, double py2, String polor, double radians, double length, String cartesian, double cx1, double cy1, String direction) {
		Vector firstV = new Vector(px1, py1, px2, py2);
		Vector secondV = new Vector(radians, length, true);
		Vector thirdV = new Vector(cx1, cy1);
		String msg = direction;
		assertEquals(true, firstV.isEqual(secondV), msg);
		assertEquals(true, secondV.isEqual(thirdV), msg);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "TestFunctions.csv")
	public void TestFunctions(String vectorInit, double xc, double yc, String function, String param1, String param2, String returnIfAny, String vectorResult, double rxc, double ryc, String msg) {
		Vector firstV = new Vector(xc, yc);
		Vector resultV = new Vector(rxc, ryc);
		double p1, p2;
		if(function.equals("add")) {
			p1 = Double.parseDouble(param1);
			p2 = Double.parseDouble(param2);
			Vector secondV = new Vector(p1, p2);
			boolean addVector = firstV.add(secondV);
			assertEquals(returnIfAny, addVector, msg);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("subtract")){
			p1 = Double.parseDouble(param1);
			p2 = Double.parseDouble(param2);
			Vector secondV = new Vector(p1, p2);
			boolean subtractVector = firstV.subtract(secondV);
			assertEquals(returnIfAny, subtractVector, msg);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if (function.equals("limit")) {
			p1 = Double.parseDouble(param1);
			p2 = Double.parseDouble(param2);
			boolean limitReturnVal = firstV.limit(p1, p2);
			assertEquals(returnIfAny, limitReturnVal, msg);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("scale")) {
			p1 = Double.parseDouble(param1);
			firstV.scale(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if (function.equals("rotate")) {
			p1 = Double.parseDouble(param1);
			firstV.rotate(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("divide")) {
			p1 = Double.parseDouble(param1);
			firstV.divide(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("multiply")) {
			p1 = Double.parseDouble(param1);
			firstV.multiply(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("setLength")) {
			p1 = Double.parseDouble(param1);
			firstV.setLength(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("setAngle")) {
			p1 = Double.parseDouble(param1);
			firstV.setAngle(p1);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("getLength")) {
			double returnLength = firstV.getLength();
			returnLength = utils.Utils.round(returnLength);
			double result = Double.parseDouble(returnIfAny);
			assertEquals(result, returnLength, msg);
		}else if(function.equals("getAngle")) {
			double returnAngle = firstV.getAngle();
			double result = Double.parseDouble(returnIfAny);
			assertEquals(result, utils.Utils.round(returnAngle), msg);
		}else if(function.equals("setComponents")) {
			p1 = Double.parseDouble(param1);
			p2 = Double.parseDouble(param2);
			firstV.setComponents(p1, p2);
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("invert")) {
			firstV.invert();
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.equals("normalize")) {
			firstV.normalize();
			assertEquals(true, firstV.isEqual(resultV), msg);
		}else if(function.contentEquals("setZero")) {
			firstV.setZero();
			assertEquals(true, firstV.isEqual(resultV), msg);
		}
	}

}
