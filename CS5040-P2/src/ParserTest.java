import java.io.File;
import student.TestCase;

/**
 * 
 */

/**
 * @author ngunn15 Gunnar Nelson
 * @version 2020-09-10
 *
 */
public class ParserTest extends TestCase {

    /**
     * Test Parser method
     */
    public void testParser() {
        Rect<Key, Data> tBST;
        tBST = new Rect<Key, Data>();
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(tBST.root(), null);
        
        File tFile = new File("src//ParserTestFile.txt");
        
        assertNotNull(tFile);
        
        Parser myParse = new Parser(tFile, tBST);
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(myParse.mBST.root(), null);
    }

    /**
     * Testing Execute method
     */
    public void testExecute() {
        Rect<Key, Data> tBST;
        tBST = new Rect<Key, Data>();
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(tBST.root(), null);
        
        File tFile = new File("src//ParserTestFile.txt");
        
        assertNotNull(tFile);
        
        Parser myParse = new Parser(tFile, tBST);
        myParse.execute();
        
        assertEquals(tBST.nodeCount(), 1);
    }

}

