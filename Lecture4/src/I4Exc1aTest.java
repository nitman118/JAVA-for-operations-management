import static org.junit.Assert.*;
import org.junit.Test;

/** Public in PEACH */
public class I4Exc1aTest {
    @Test // test 1
    public void testReverse1() {
        assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, 
                I4Exc1a.reverse(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test // test 2
    public void testReverse2() {
        assertArrayEquals(new int[] { 5, 4, 4, 2, 1, 2 }, 
                I4Exc1a.reverse(new int[] { 2, 1, 2, 4, 4, 5 }));
    }

    @Test // test with a few negative integers and a 0
    public void testReverse3() {
        assertArrayEquals(new int[] { 3, 4, 5, -1, -2, 0, 21 }, 
                I4Exc1a.reverse(new int[] { 21, 0, -2, -1, 5, 4, 3 }));
    }

    @Test // array with null values
    public void testReverse4() {

        assertArrayEquals(new int[7], 
                I4Exc1a.reverse(new int[7]));
    }

    @Test // empty array with 1 null
    public void testReverse5() {

        assertArrayEquals(new int[] {}, I4Exc1a.reverse(new int[] {}));
    }
}