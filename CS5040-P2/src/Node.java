/**
 * Stub for Node class
 * 
 * @author ngunn15 Gunnar Nelson
 * @param <D>
 *      the generic type; extends Comparable, for data
 * @param <K>
 *      the generic type; extends Comparable, for key
 * @version 2020-06-10
 */

public class Node<K, D> implements Comparable<Node<K, D>> {

    /**
     * Constructor for node
     */
    Node() {
        left = null;
        right = null;
    }

    /**
     * Constructor w/parameters
     * 
     * @param inputKey
     *            the key value used to set private member key
     * @param inputData
     *            the data value used to set pivate member data
     */
    Node(K inputKey, D inputData) {
        key = inputKey;
        data = inputData;
        left = null;
        right = null;
    }


    /**
     * Constructor w/parameters
     * 
     * @param k
     *            the key value in the created node
     * @param d
     *            the data value in the created node
     * @param l
     *            the left node of the created node
     * @param r
     *            the right node of the created node
     */
    Node(K k, D d, Node<K, D> l, Node<K, D> r) {
        key = k;
        data = d;
        left = l;
        right = r;
    }


    /**
     * Provides access to the node's key value
     * 
     * @return the key value
     */
    public K key() {
        return key;
    }


    /**
     * Sets the node's key to input parameter value
     * 
     * @param inputKey
     *            the key value to set
     */
    public void setKey(K inputKey) {
        key = inputKey;
    }


    /**
     * Provides access to the node's data value
     * 
     * @return the data value
     */
    public D data() {
        return data;
    }


    /**
     * Sets the node's data to input parameter value
     * 
     * @param inputData
     *            the data value to set
     */
    public void setData(D inputData) {
        data = inputData;
    }


    /**
     * Provides access to the node's right child
     * 
     * @return the right child node
     */
    public Node<K, D> right() {
        return right;
    }


    /**
     * Sets the node's right child to input value
     * 
     * @param inputNode
     *            the node used to set right child
     */
    public void setRight(Node<K, D> inputNode) {
        right = inputNode;
    }


    /**
     * Provides access to the node's left child
     * 
     * @return the left child node
     */
    public Node<K, D> left() {
        return left;
    }


    /**
     * Sets the node's left child to input value
     * 
     * @param inputNode
     *            the node used to set left child
     */
    public void setLeft(Node<K, D> inputNode) {
        left = inputNode;
    }


    /**
     * Helper function to check if the node is a leaf
     * leaf meaning both left and right children are null
     * 
     * @return true if node is a leaf, else false
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }


    /**
     * Override for compareTo to check if two
     * nodes are equal to each other
     * A node is defined to 
     * be equal if both key and data are identical
     * 
     * @param input
     *            is the node being compared against
     * @return 0 if nodes are equal, else 1
     */
    @Override
    public int compareTo(Node<K, D> input) {
        if (key == input.key() && data == input.data()) {
            return 0;
        }
        return 1;
    }


    /**
     * Override for toString to print a node
     * 
     * @return prints (name, x, y, w, h)
     */
    @Override
    public String toString() {
        return "(" + key.toString() + ", " + data.toString() + ")";
    }

    // private data members
    private Node<K, D> left; // left child node
    private Node<K, D> right; // right child node
    private K key; // key value (contains name of rectangle)
    private D data; // data value (contains xywh of rectangle)
}
