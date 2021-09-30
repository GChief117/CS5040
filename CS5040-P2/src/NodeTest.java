/**
 * 
 */
import student.TestCase;
/**
 * @author ngunng15 Gunnar
 * @version 2020-07-10
 *
 */
public class NodeTest extends TestCase {

    /**
     * Test Node method
     */
    public void testNode() {
        n1 = new Node<Key, Data>();
        assertEquals(n1.left(), null);
        assertEquals(n1.right(), null);
    }

    /**
     * Test Node for Key and Data 
     */
    public void testNodeKD() {
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data);
        assertEquals(n1.left(), null);
        assertEquals(n1.right(), null);
        assertEquals(n1.data(), data);
        assertEquals(n1.key(), key);
    }

    /**
     * Test for Node inside of BST
     */
    public void testCompareTo() {
        Node<Key, Data> left;
        left = new Node<Key, Data>();
        Node<Key, Data> right;
        right = new Node<Key, Data>();
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data, left, right);
        assertEquals(n1.left(), left);
        assertEquals(n1.right(), right);
        assertEquals(n1.data(), data);
        assertEquals(n1.key(), key);
    }

    /**
     * Test setKey method
     */
    public void testsetKey() {
        n1 = new Node<Key, Data>();
        Key newKey = new Key("new_name");
        n1.setKey(newKey);
        assertEquals(n1.key(), newKey);
    }

    /**
     * Test setData method
     */
    public void testSetData() {
        n1 = new Node<Key, Data>();
        int[] c = {10, 3, 7, 32};
        Data newData = new Data(c);
        n1.setData(newData);
        assertEquals(n1.data(), newData);
    }

    /**
     * Test method for left and Right of Node
     */
    
    public void testRightandLeft() {
        Key keyl = new Key("l_name");
        int[] a = {1, 1, 1, 1};
        Data datal = new Data(a);
        Key keyr = new Key("r_name");
        int[] b = {1, 2, 3, 43};
        Data datar = new Data(b);
        Node<Key, Data> left;
        left = new Node<Key, Data>(keyl, datal);
        Node<Key, Data> right;
        right = new Node<Key, Data>(keyr, datar);
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data, left, right);
        assertEquals(n1.left(), left);
        assertEquals(n1.right(), right);
        assertEquals(n1.left().key().name(), "l_name");
        assertEquals(n1.right().data().coordinates(), b);
    }

    /**
     * Test method for right of Node
     */
    public void testsetRight() {
        Node<Key, Data> right;
        right = new Node<Key, Data>();
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data);
        assertEquals(n1.right(), null);
        n1.setRight(right);
        assertEquals(n1.right(), right);
    }

    /**
     * Test setLeaf method
     */
    public void testsetLeft() {
        Node<Key, Data> left;
        left = new Node<Key, Data>();
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data);
        assertEquals(n1.left(), null);
        n1.setLeft(left);
        assertEquals(n1.left(), left);
    }

    /**
     * Test isLeaf method
     */
    public void testIsLeaf() {
        Node<Key, Data> right;
        right = new Node<Key, Data>();
        Node<Key, Data> left;
        left = new Node<Key, Data>();
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data);
        assertEquals(n1.isLeaf(), true);
        n1.setRight(right);
        assertEquals(n1.isLeaf(), false);
        n1.setLeft(left);
        assertFalse(n1.isLeaf());
    }

    /**
     * Test toString method
     */
    public void testToString() {
        Key key = new Key("node_name");
        int[] c = {1, 2, 3, 4};
        Data data = new Data(c);
        n1 = new Node<Key, Data>(key, data);
        String res = n1.toString();
        assertEquals(res, "(node_name, 1, 2, 3, 4)");
    }
    private Node<Key, Data> n1;
}
