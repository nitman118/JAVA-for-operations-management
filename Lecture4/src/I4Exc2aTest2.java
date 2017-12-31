
import static org.junit.Assert.*;
import org.junit.Test;

public class I4Exc2aTest2 {
    @Test // test 1, default
    public void testSelectionSort1() {
        String[] arr = new String[] { "a", "z", "a", "x", "m", "ab", "az", "aa", "ax", "am" };
        String[] arrCopy = arr.clone();
        I4Exc2a.selectionSortString(arrCopy);
        assertArrayEquals(java.util.Arrays.toString(arr) + " not properly sorted", arrCopy,
                new String[] { "a", "a", "aa", "ab", "am", "ax", "az", "m", "x", "z" });
    }

    @Test // test 2, default
    public void testSelectionSort2() {
        String[] arr = new String[] { "a", "z", "a", "x", "m", "ab", "az", "aa", "ax", "am" };
        String[] arrCopy = arr.clone();
        I4Exc2a.selectionSortString(arrCopy);
        assertArrayEquals(java.util.Arrays.toString(arr) + " not properly sorted", arrCopy,
                new String[] { "a", "a", "aa", "ab", "am", "ax", "az", "m", "x", "z" });
    }

    @Test // test 3, for Capital Letters, symbol and Integer
    public void testSelectionSort3() {
        String[] arr = new String[] { "2", "<", "d", "F", "n", "P", "x", "Z", "(", };
        String[] arrCopy = arr.clone();
        I4Exc2a.selectionSortString(arrCopy);
        assertArrayEquals(java.util.Arrays.toString(arr) + " not properly sorted", arrCopy,
                new String[] { "(", "2", "<", "F", "P", "Z", "d", "n", "x" });

    }
}
