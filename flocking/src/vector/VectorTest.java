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
		Vector test1 = new Vector(1,2);
		test1.invert();
		mylog.print(test1.toString(),DEBUG_CODE);
		Vector test2 = new Vector(1,1,3,3);
		test2.normalize();
		mylog.print(test2.toString(), DEBUG_CODE);
	}

}
