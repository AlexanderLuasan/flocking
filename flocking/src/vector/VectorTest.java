package vector;
/* vectorTest.h
 * this is the test area for vectors
 * 
 */
import utils.*;

public class VectorTest {

	public static void main(String[] args) {
		Log mylog = utils.Log.getLog();
		int DEBUG_CODE = Log.DEBUG+Log.VECTOR;
		System.out.println("Start Vector Test");
		
		Vector temp1 = new Vector(3, 4);
		Vector temp2 = new Vector(2, 2);
		Vector temp3 = new Vector(6, 8);
		
		Vector test1 = new Vector(1,2);
		test1.invert();
		mylog.println(test1.toString(),DEBUG_CODE);
		
		Vector test2 = new Vector(1,1,3,3);
		test2.normalize();
		mylog.println(test2.toString(), DEBUG_CODE);
		
		Vector test3 = new Vector(1, 1, true);
		mylog.println(test3.toString(), DEBUG_CODE);
		
		Vector test4 = new Vector(1,3);
		test4.add(temp1);
		mylog.println(test4.toString(), DEBUG_CODE);
		
		temp1.subtract(temp2);
		mylog.println(temp1.toString());
		temp1.add(temp2);
		
		temp1.scale(10);
		mylog.println(temp1.toString(), DEBUG_CODE);
		
		temp1.invert();
		mylog.println(temp1.toString(), DEBUG_CODE);
		temp1.invert();
		
		temp1.limit(2, 8);
		mylog.println(temp1.toString(), DEBUG_CODE);
		
		test3.rotate(1);
		mylog.println(test3.toString(), DEBUG_CODE);
		
		temp3.multiply(2);
		mylog.println(temp3.toString(), DEBUG_CODE);
		
		temp3.divide(2);
		mylog.println(temp3.toString(), DEBUG_CODE);

		temp3.setLength(20);
		mylog.println(temp3.toString(), DEBUG_CODE);
		
	}
	
}
