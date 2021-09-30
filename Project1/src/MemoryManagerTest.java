import student.TestCase;

/**
 * 
 * @author Gunnar Nelson ngunn15
 * @version 2020-04-09
 *
 */
public class MemoryManagerTest extends TestCase {
	private MemoryManager manager1;
	private MemoryManager manager2;

	/**
	 * Sets up the tests that follow. 
	 * In general, used for initialization
	 */
	public void setUp() {
		// Nothing Here
	}

	/**
	 * tests insert method
	 */
	public void testComplexCase() {
		manager1 = new MemoryManager(32);
		assertEquals(1, manager1.getBlockList().size());
		String input = "Christian";
		assertEquals(0, manager1.insert(input.getBytes(), 
				input.getBytes().length, input).getMemPool());
		assertEquals(1, manager1.getBlockList().size());
		String input2 = "p";
		assertEquals(1, manager1.insert(input2.getBytes(), 
				input2.getBytes().length, input2).getLength());
		String input3 = "A Really Long Word";
		assertEquals(18, manager1.insert(input3.getBytes(), 
				input3.getBytes().length, input3).getLength());
		manager2 = new MemoryManager(0);
		String input4 = "Christian";
		assertEquals(0, manager2.insert(input4.getBytes(), 
				input4.getBytes().length, input4).getMemPool());
	}

	/**
	 * tests the remove method
	 */
	public void testUpdateBlocks() {
		manager1 = new MemoryManager(32);
		assertEquals(1, manager1.getBlockList().size());
		String input = "Christian";
		Handle testHandle = manager1.insert(input.getBytes(), 
				input.getBytes().length, input);
		manager1.remove(testHandle);
		assertEquals(32, manager1.getBlockList().get(0).getSize());
		String inputA = "Another rally long String";
		manager1.insert(inputA.getBytes(), inputA.getBytes().length, inputA);

		manager2 = new MemoryManager(32);
		String input2 = "Christian";
		Handle testHandle2 = manager2.insert(input2.getBytes(), 
				input2.getBytes().length, input2);
		String input3 = "William Bao";
		Handle testHandle3 = manager2.insert(input3.getBytes(), 
				input3.getBytes().length, input3);
		manager2.remove(testHandle2);
		assertEquals(16, manager2.getBlockList().get(0).getSize());
		manager2.remove(testHandle3);
		assertEquals(32, manager2.getBlockList().get(0).getSize());

		MemoryManager manager13 = new MemoryManager(32);
		String dk = "Death Note<SEP>Genre<SEP>Anime";
		Handle dkHandle = manager13.insert(dk.getBytes(), 
				dk.getBytes().length, dk);
		String cyh = "Can You Handle?";
		manager13.insert(cyh.getBytes(), cyh.getBytes().length, cyh);
		String atest = "Another Test";
		Handle atestHandle = manager13.insert(atest.getBytes(), 
				atest.getBytes().length, atest);
		manager13.remove(dkHandle);
		String dn = "Death Note";
		manager13.insert(dn.getBytes(), dn.getBytes().length, dn);
		manager13.remove(atestHandle);
		manager13.dump();
		assertEquals(2, manager13.getBlockList().get(0).getList().size());

	}

	/**
	 * tests the length method
	 */
	public void testCommunication() {
		manager1 = new MemoryManager(32);
		assertEquals(1, manager1.getBlockList().size());
		String input = "Christian";
		Handle testHandle = manager1.insert(input.getBytes(), 
				input.getBytes().length, input);
		assertEquals(9, manager1.length(testHandle));
	}

	/**
	 * Here we are testing when putting a big string
	 */
	public void testBigStringMemoryInsert() {
		manager1 = new MemoryManager(32);
		String input1 = "A really long string";
		assertEquals(20, manager1.insert(input1.getBytes(), 
				input1.getBytes().length, input1).getLength());
	}

	/**
	 * We are testing the small memory value in mem class
	 */
	public void testSmallStringMemoryInsert() {
		manager1 = new MemoryManager(32);
		String input2 = "a";
		assertEquals(1, manager1.insert(input2.getBytes(), 
				input2.getBytes().length, input2).getLength());
	}

	/**
	 * Here we are testing the merge blocks method
	 */
	public void testMergeBlocks() {
		manager1 = new MemoryManager(32);
		String input1 = "A really long string";
		assertEquals(20, manager1.insert(input1.getBytes(), 
				input1.getBytes().length, input1).getLength());

	}

	/**
	 * Here we are testing the simply memory method
	 */
	public void testSimplyMemory() {
		manager1 = new MemoryManager(32);
		String input1 = "A really long string";
		assertEquals(20, manager1.insert(input1.getBytes(), 
				input1.getBytes().length, input1).getLength());
	}

	/**
	 * Here we are testing the simple memory tomb
	 */
	public void testSimpleMemoryTomb() {
		manager1 = new MemoryManager(32);
		String input1 = "A really long string";
		assertEquals(20, manager1.insert(input1.getBytes(), 
				input1.getBytes().length, input1).getLength());
	}

}