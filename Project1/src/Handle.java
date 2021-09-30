/**
 * 
 */

/**
 * 
 * @author Gunnar Nelson ngunn15 
 * @version 2020-04-09
 *
 */
public class Handle {
	private int memPool;
	private int length;
	private String key; 
	private boolean tombstone;

	/**
	 * constructor for our handle
	 * 
	 * @param tokyo
	 * 	      is the memory pool location
	 * 
	 * @param thatsprettybig
	 *        is the size of the record
	 *        
	 * @param catlinjenner
	 *        is the name of the record
	 * 
	 */
	public Handle(int tokyo, int thatsprettybig, String catlinjenner) {
		//now we set the objects to our parameters
		memPool = tokyo;
		length = thatsprettybig;
		key = catlinjenner;
		this.tombstone = false;
		
	}
	
	/**
	 * Here we 
	 * @return the memory pool's location
	 * since the value is an integer
	 * 
	 * return method
	 */
	public int getMemPool() {
		return memPool;
	}
	
	/**
	 * Here we
	 * @return the length of the record
	 * return method
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Here we create our constructor for our key
	 * Because this is the value we want to return
	 * @return our key
	 * return method
	 */
	public String key() {
		return key;
	}
	
	/**
	 * This method exclusively to this class
	 * creates the tombstone object's method
	 * 
	 * In this method for our object,
	 * we set the deletion state of the handle.
	 * 
	 * If deleted, the tombstone will be true
	 * 
	 * @param condition
	 *         is the deletion state
	 */
	public void setDeleted(boolean condition) {
		this.tombstone = condition;
	}
	
	/**
	 * Here we set up a constructor for our
	 * deleted value of tombstone
	 * @return condition of deletion
	 * return method
	 */
	
	public boolean getDeleted() {
		return this.tombstone;
	}
	

}
