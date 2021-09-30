import student.TestCase;

/**
 * 
 * @author Gunnar Nelson ngunn15
 * @version 2020-04-09
 *
 */
public class MemManTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testRInit() {
        MemMan recstore = new MemMan();
        assertNotNull(recstore);
        MemMan.main(null);
        String[] run = { "256", "10", "Piazzatrial.txt" };
        MemMan.main(run);
        String[] dum = { "23", "sf" };
        MemMan.main(dum);
    }
}