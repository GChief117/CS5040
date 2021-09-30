import student.TestCase;

/**
 * 
 */

/**
 * @author ngunn15 Gunnar Nelson
 * @version 2020-09-10
 */
public class KeyTest extends TestCase {

    /**
     * Tests Key Method
     */
    public void testKey() {
        Key a = new Key("test");

        assertEquals("test", a.name());
    }

    /**
     * Test CompareTo method
     */
    public void testCompareTo() {
        Key a = new Key("name");
        Key b = new Key("name");

        int same = a.compareTo(b);

        assertEquals(0, same);
    }

    /**
     * Test ToString method 
     */
    public void testToString() {
        Key key = new Key("rect1");

        String ans = key.toString();

        assertEquals("rect1", ans);
    }

    /**
     * Test Name method
     */
    public void testName() {
        Key a = new Key("n1");
        Key b = a;

        assertEquals("n1", a.name());
        assertEquals("n1", b.name());
    }
}
