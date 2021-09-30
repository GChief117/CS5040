/**
 * 
 * @author Gunnar Nelson ngunn15
 * @version 2020-04-09
 *
 */
public class MemoryManager {
	private int poolSize;
	private byte[] memPool;
	private LinkedList<Freeblock> free;

	/**
	 * Constructor. poolsize 
	 * defines the size of the memory 
	 * pool in bytes
	 * 
	 * @param poolsize is the size of the memory pool
	 */
	public MemoryManager(int poolsize) {
		if (poolsize <= 0) {
			poolSize = 1;
		} 
		else {
			poolSize = poolsize;
		}
		memPool = new byte[poolSize];
		free = new LinkedList<>();
		Freeblock size = new Freeblock(poolSize);
		size.getList().add(0);
		free.add(size);

	}

	/**
	 * Return the length of the 
	 * record associated with theHandle
	 * 
	 * @param handle the handle to get the length of
	 * @return the handle's record's length
	 */
	public int length(Handle handle) {
		return handle.getLength();
	}

	/**
	 * Free a block at the position 
	 * specified by theHandle. 
	 * Merge adjacent free
	 * blocks.
	 * 
	 * @param theHandle the handle of the record to be removed
	 */
	public void remove(Handle theHandle) {
		int location = theHandle.getMemPool();
		int blockSize = findBlockSize(theHandle.getLength());
		for (int i = location; i < location + blockSize; i++) {
			memPool[i] = 0;
		}
		addFreeblock(blockSize, location);
		mergeBlocks();
		sortFreeList();
	}

	/**
	 * 
	 * @return poolSize
	 */
	public int getPoolSize() {
		return poolSize;
	}

	/**
	 * Insert a record and return its position handle.
	 * 
	 * @param item record to be inserted
	 * @param size size of the record
	 * @param name name of the record
	 * @return a handle containing the record's position, size and name
	 */
	public Handle insert(byte[] item, int size, String name) {
		int blockSize = findBlockSize(size);
		int blockLocation = findBlockLocation(blockSize);
		for (int i = 0; i < size; i++) {
			memPool[blockLocation + i] = item[i];
		}
		removeFreeblock(blockSize, blockLocation);
		Handle handle = new Handle(blockLocation, size, name);
		sortFreeList();
		return handle;
	}

	/**
	 * Finds the correct block 
	 * size given a record size
	 * 
	 * @param recordSize the size of the record
	 * @return the size of the block
	 */
	private int findBlockSize(int recordSize) {
		int i = 0;
		while (Math.pow(2, i) < recordSize) {
			i++;
		}
		return (int) Math.pow(2, i);
	}

	/**
	 * Finds the location of a suitable block 
	 * from the free block list. If the found
	 * block is larger than expected it is 
	 * resized. If there is no suitable block
	 * found the memPool is expanded 
	 * and the search is repeated.
	 * 
	 * @param blockSize the desired size of the block
	 * @return the location of the block
	 */
	private int findBlockLocation(int blockSize) {
		int blockLocation = 0;
		Freeblock blocks = null;
		for (int i = blockSize; i <= poolSize; i = i * 2) {
			for (int j = 0; j < free.size(); j++) {
				if (free.get(j).getSize() == i) {
					blocks = free.get(j);
					j = free.size();
					i = poolSize + 1;
				}
			}
		}
		if (blocks != null) {
			blockLocation = blocks.getList().get(0);
			if (blocks.getSize() > blockSize) {
				resizeBlock(blocks, blockSize);
			}

		} 
		else {
			expandmemPool();
			blockLocation = findBlockLocation(blockSize);
		}

		return blockLocation;
	}

	/**
	 * Expands the memPool by doubling 
	 * its size and adds a new block to the free
	 * blocks list.
	 */
	private void expandmemPool() {
		addFreeblock(poolSize, poolSize);
		poolSize = poolSize * 2;
		byte[] newPool = new byte[poolSize];
		for (int i = 0; i < memPool.length; i++) {
			newPool[i] = memPool[i];
		}
		memPool = newPool;
		mergeBlocks();
		System.out.println("Exp. by " + poolSize + " bytes.");
	}

	/**
	 * Resizes blocks by splitting 
	 * them in half until desired size.
	 * 
	 * @param blocks           the Freeblock w/correct sized blocks
	 * @param desiredBlockSize the desired block size
	 */
	private void resizeBlock(Freeblock blocks, int desiredBlockSize) {
		int blockSize = blocks.getSize();
		int blockLocation = blocks.getList().get(0);
		while (blockSize != desiredBlockSize) {
			removeFreeblock(blockSize, blockLocation);
			blockSize = blockSize / 2;
			addFreeblock(blockSize, blockLocation);
			addFreeblock(blockSize, blockLocation + blockSize);
		}
	}

	/**
	 * Adds a block to the free block list.
	 * 
	 * @param size     size of the block being added
	 * @param location location value of the block being added
	 * @return true if block is added.
	 */
	private boolean addFreeblock(int size, int location) {
		for (int i = 0; i < free.size(); i++) {
			if (free.get(i).getSize() == size) {
				free.get(i).getList().add(location);
				return true;
			}
		}
		Freeblock newBlock = new Freeblock(size);
		newBlock.getList().add(location);
		free.add(newBlock);
		return true;
	}

	/**
	 * Removes a block from the free block list.
	 * 
	 * @param size     size of the block being removed
	 * @param location location value of the block being removed
	 */
	private void removeFreeblock(int size, int location) {
		for (int i = 0; i < free.size(); i++) {
			if (free.get(i).getSize() == size) {
				Integer removed = location;
				free.get(i).getList().remove(removed);
				if (free.get(i).getList().isEmpty()) {
					free.remove(i);
				}
			}
		}
	}

	/**
	 * Merges adjacent free blocks with the same size.
	 */
	public void mergeBlocks() {
		boolean check = false;
		for (int i = 0; i < free.size(); i++) {
			int count = 0;
			sortFreeList();
			while (free.get(i).getList().size() > 1 && count < 
					(free.get(i).getList().size() - 1)) {
				int size = free.get(i).getSize();
				int loc = free.get(i).getList().get(count);
				if (loc + size == free.get(i).getList().get(count + 1)
						&& ((loc | size) == 
						(size | free.get(i).getList().get(count + 1)))) {
					addFreeblock(size * 2, loc);
					removeFreeblock(size, loc + size);
					removeFreeblock(size, loc);
					check = true;
				}
				count++;
			}
			if (check) {
				i = -1;
				check = false;
			}
		}

	}

	/**
	 * Return the record with handle posHandle, 
	 * up to size bytes, by copying it into
	 * item.
	 * 
	 * @param handle is the record for the handle
	 * @return the number of bytes actually copied into item.
	 */
	public String getRecord(Handle handle) {
		byte[] record = new byte[handle.getLength()];
		for (int i = 0; i < handle.getLength(); i++) {
			record[i] = memPool[handle.getMemPool() + i];
		}
		String str = new String(record);
		return str.trim().replaceAll("[\u0000-\u001f]", "");
	}

	/**
	 * Dump a printout of the freeblock list
	 */
	public void dump() {
		if (free.isEmpty()) {
			System.out.println("No free blocks are available.");
		} 
		else {
			for (int i = 0; i < free.size(); i++) {
				StringBuilder builder = new StringBuilder();
				builder.append(free.get(i).getSize());
				builder.append(":");
				for (int j = 0; j < free.get(i).getList().size(); j++) {
					builder.append(" ");
					builder.append(free.get(i).getList().get(j));
				}
				if (free.size() > 1 && i == 0) {
					builder.append(" ");
				}
				System.out.println(builder.toString());
			}
		}
	}

	/**
	 * gets freeblock list for testing purposes
	 * 
	 * @return the free block list
	 */
	public LinkedList<Freeblock> getBlockList() {
		return free;
	}

	/**
	 * 'Here we sort the freeblock's internal list list.
	 */
	private void sortInternalList(Freeblock block) {
		LinkedList<Integer> temp = new LinkedList<>();
		while (block.getList().size() > 0) {
			Integer min = block.getList().get(0);
			for (int j = 0; j < block.getList().size(); j++) {
				if (block.getList().get(j) < min) {
					min = block.getList().get(j);

				}
			}
			block.getList().remove(min);
			temp.add(min);
		}
		block.setList(temp);
	}

	/**
	 * Sorts outer lists of the free block 
	 * list by size and the inner lists by
	 * location. Both are least to greatest.
	 */
	private void sortFreeList() {
		LinkedList<Freeblock> temp = new LinkedList<>();
		while (free.size() > 0) {
			Freeblock min = free.get(0);
			for (int j = 0; j < free.size(); j++) {
				sortInternalList(free.get(j));
				if (free.get(j).getSize() < min.getSize()) {
					min = free.get(j);
				}
			}
			free.remove(min);
			temp.add(min);
		}
		free = temp;

	}

}
