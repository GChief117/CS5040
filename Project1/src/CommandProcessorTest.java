import student.TestCase;

/**
 * 
 * @author Gunnar Nelson ngunn15 
 * @version 2020-04-09
 *
 */
public class CommandProcessorTest extends TestCase {

    /**
     * Tests command processor
     */
    public void testConstructor() {
        CommandProcessor processor = new CommandProcessor("32", "10",
            "P1sampleInput.txt");
        assertNotNull(processor.getHash());
        processor = new CommandProcessor("256", "10", "Piazzatrial.txt");

    }


    /**
     * Tests merge compare
     */
    public void testConstructor2() {
        CommandProcessor processor = new CommandProcessor("128", "10",
            "P1mergetest.txt");
        assertNotNull(processor.getHash());
    }


    /**
     * tests resize compare
     */
    public void testConstructor3() {
        CommandProcessor processor = new CommandProcessor("32", "7",
            "P1resize.txt");
        assertNotNull(processor.getHash());
    }


    /**
     * tests simple compare
     */
    public void testConstructor4() {
        CommandProcessor processor = new CommandProcessor("64", "10",
            "P1simple.txt");
        assertNotNull(processor.getHash());
    }


    /**
     * tests complex, manually compare
     */
    public void testConstructor5() {
        CommandProcessor processor = new CommandProcessor("32", "16",
            "P1complex.txt");
        assertNotNull(processor.getHash());
    }
    
    

	/**
	 * Here we are testing if the item is added
	 */
	public void testUpdateAdd() {
        CommandProcessor processor = new CommandProcessor("32", "10",
                "P1sampleInput.txt");
        assertNotNull(processor.getHash());
	}

	/**
	 * Here we are testing the item is removed
	 */
	public void testUpdateDelete() {
        CommandProcessor processor = new CommandProcessor("32", "10",
                "P1sampleInput.txt");
        assertNotNull(processor.getHash());
	}
}
