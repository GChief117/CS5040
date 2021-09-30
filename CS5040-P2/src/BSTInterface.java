/**
 * Interface for BST
 * 
 * @author ngunn15 Gunnar Nelson
 * @param <T> the generic type; extends Comparable
 * @version 2020-06-10
 * @param <D>
 *      the generic type; extends Comparable, for data
 * @param <K>
 *      the generic type; extends Comparable, for key
 */
public interface BSTInterface<T extends Comparable<T>, D, K> {

    /**
     * returns whether tree is empty
     * 
     * @return status of tree as empty
     */
    public boolean isEmpty();


    /**
     * finds a given object within the BST
     * 
     * @param object
     *            object to find within the tree
     * @return whether the object was found
     */
    public Object[] find(Node<K, D> object);


    /**
     * insert an object into the tree
     * 
     * @param input
     *            the object to insert
     * @return whether the object was inserted
     */
    public boolean insert(Node<K, D> input);


    /**
     * remove an object from the tree
     * 
     * @param removed
     *            object to be removed
     * @return whether the object was removed
     */
    public Node<K, D> remove(Node<K, D> removed);


    /**
     * resets the tree
     */
    public void clear();
}
