/**
 * 
 */

/**
 * 
 * @author Gunnar Nelson ngunn15 
 * @version 2020-04-09
 *
 */
public class Freeblock {

    private int size;
    private LinkedList<Integer> block;


    /**
     * 
     * @param blocksize
     *            is the size of the freeblock
     */
    public Freeblock(int blocksize) {
        size = blocksize;
        block = new LinkedList<Integer>();
    }


    /**
     * 
     * @return the linked list
     */
    public LinkedList<Integer> getList() {
        return block;
    }


    /**
     * Sets the list of the FreeBlock
     * 
     * @param newList
     *            the new list to be used
     */
    public void setList(LinkedList<Integer> newList) {
        block = newList;
    }
    
    /**
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }

}
