
/**
 * 
 */

import student.TestCase;

/**
 * 
 * @author Gunnar Nelson ngunn15
 * @version 2020-04-09
 *
 */
public class HandleTest extends TestCase {
	/**
	 * Setting up the birdie!
	 */
	public void setUp() {
		// Setting up the test case for Handle Class
	}

	/**
	 * Just testing all the methods in the Handle 
	 * Class Which are just mostly return
	 * values Along with our return methods, 
	 * which are not public void in the Handle
	 * Class. Public void in this test class, 
	 * since exclusively to this class
	 */
	public void testHandles() {
		Handle test = new Handle(1, 3, "test");
		assertEquals(test.getMemPool(), 1);
		assertEquals(test.getLength(), 3);
		assertEquals(test.key(), "test");
		assertEquals(test.getDeleted(), false);
		test.setDeleted(true);
		assertEquals(test.getDeleted(), true);
	}

	/**
	 * Setting up simple tomb hash
	 */
	public void testSimpleTombHash() {
		Handle test = new Handle(1, 3, "test");
		assertEquals(test.getMemPool(), 1);

	}

}
