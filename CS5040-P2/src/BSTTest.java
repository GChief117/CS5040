import java.io.File;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the BST function
 *
 * @author ngunn15 Gunnar Nelson
 * @version 2020-06-10
 */
public class BSTTest extends TestCase {

    /**
     * Test BST method
     */
    
    public void testBST() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        assertEquals(mytree.nodeCount(), 0);
        assertEquals(mytree.root(), null);
    }

    /**
     * Test clear method
     */
    
    public void testClear() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key = new Key("test");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key, d));
        assertEquals(mytree.nodeCount(), 1);
        assertNotNull(mytree.root());
        mytree.clear();
        
        assertEquals(mytree.nodeCount(), 0);
        assertNull(mytree.root());
    }  

    /**
     * Test insert method
     */
    
    public void testInsert() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key = new Key("test");
        Key key2 = new Key("az");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key, d));
        mytree.insert(new Node<Key, Data>(key, d));
        mytree.insert(new Node<Key, Data>(key2, d));
        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().key().name(), "test");
        assertEquals(mytree.nodeCount(), 3);
    }

    /**
     * Test Dump method
     */
    public void testDump() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key1 = new Key("e");
        Key key2 = new Key("d");
        Key key3 = new Key("f");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key1, d));
        mytree.insert(new Node<Key, Data>(key2, d));
        mytree.insert(new Node<Key, Data>(key3, d));
        
        mytree.dump();

        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "e");
        assertEquals(mytree.root().left().key().name(), "d");
        assertEquals(mytree.root().right().key().name(), "f");
        
        assertEquals(mytree.nodeCount(), 3);
    }

    /**
     * Test Search method
     */
    public void testSearch() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key1 = new Key("e");
        Key key2 = new Key("d");
        Key key3 = new Key("f");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key1, d));
        mytree.insert(new Node<Key, Data>(key2, d));
        mytree.insert(new Node<Key, Data>(key3, d));
        
        Key test = new Key("e");
        mytree.search(test);

        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "e");
        assertEquals(mytree.root().left().key().name(), "d");
        assertEquals(mytree.root().right().key().name(), "f");
        
        assertEquals(mytree.nodeCount(), 3);
    }

    /**
     * Test method for {@link BST#root()}.
     */
    public void testRoot() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key1 = new Key("b");
        Key key2 = new Key("a");
        Key key3 = new Key("c");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key1, d));
        mytree.insert(new Node<Key, Data>(key2, d));
        mytree.insert(new Node<Key, Data>(key3, d));
        
        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "b");
        assertEquals(mytree.root().left().key().name(), "a");
        assertEquals(mytree.root().right().key().name(), "c");
    }

    /**
     * Test nodeCount method
     */
    public void testnodeCount() {
        BST<Key, Data> mytree = new BST<Key, Data>();
        Key key1 = new Key("e");
        Key key2 = new Key("d");
        Key key3 = new Key("f");
        Key key4 = new Key("g");
        Key key5 = new Key("h");
        Key key6 = new Key("i");
        int[] c = { 1, 1, 4, 5 };
        Data d = new Data(c);
        mytree.insert(new Node<Key, Data>(key1, d));
        mytree.insert(new Node<Key, Data>(key2, d));
        mytree.insert(new Node<Key, Data>(key3, d));
        mytree.insert(new Node<Key, Data>(key4, d));
        mytree.insert(new Node<Key, Data>(key5, d));
        mytree.insert(new Node<Key, Data>(key6, d));
        assertEquals(mytree.nodeCount(), 6);
    }
    
    /**
     * Test Execution method
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