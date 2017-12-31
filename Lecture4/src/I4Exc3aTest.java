import java.util.LinkedList; //for LinkedList
import java.util.List; //for adding in the list
import org.junit.Test; // for testing
import static org.junit.Assert.*; // assertEqualsArray

public class I4Exc3aTest { // programmer defined class

    @Test // Test case
    public void testCase1() { // test case method
        List<String> str = new LinkedList<String>(); // initialize a new list to pass to compute
        str.add("A B C"); // element 1
        str.add("This is a test"); // element 2
        str.add("1 2 3 5"); // numbers
        str.add("abc");
        str.add("abcd");
        str.add("@"); // symbols
        str.add("@@");
        String[] str1 = I4Exc3a.computeList(str); // calling class method to convert to string
        // assert test
        assertArrayEquals(str1, 
                new String[] { "1 2 3 5", "@", "@@", "A B C", "This is a test", "abc", "abcd" });

    }

}
