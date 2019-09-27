package vector;

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
	public void testVector(String points, double px1, double py1, double px2, double py2, String polor, double radians, double length, String cartesian, double cx1, double cy1, String direction) {
		Vector firstV = new Vector(px1, py1, px2, py2);
		Vector secondV = new Vector(radians, length, true);
		Vector thirdV = new Vector(cx1, cy1);
		String msg = direction;
		assertEquals(true, firstV.isEqual(secondV), msg);
		assertEquals(true, secondV.isEqual(thirdV), msg);
	}

}
