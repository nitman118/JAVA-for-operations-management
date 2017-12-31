/** >>>NOT<<< FOR PEACH. See other 2 testcases! */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
public class I4Exc4aShowedTests {
  WebGraph wg;
  /** 
   * This will be invoked before each testcase. 
   * Ensure to copy/paste the content of file
   * 'ext/web1.txt' to the Eclipse console. 
   * In L6, we will teach you how to automate that!
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    Scanner s = new Scanner(System.in);
    System.out.println("Please copy/paste the content of "
        + "file 'ext/web1.txt' to this console. "
        + "Then, press ENTER.");
    wg = WebGraph.initFromScanner(s);
  }

  @Test
  public void testGetNodeSize() {
    assertEquals(50, wg.getNodeSize());
  }
  @Test
  public void testHasLink1() {
   // assertFalse(wg.hasLink(0, 0));
  }
  @Test
  public void testHasLink2() {
  //  assertTrue(wg.hasLink(0, 7));
  }
  @Test
  public void testLinkWeight1() {
   // assertEquals(1, wg.linkWeight(0, 7));
  }
  @Test
  public void testLinkWeight2() {
    //assertEquals(1, wg.linkWeight(0, 34));
  }
  @Test
  public void testLinkWeight3() {
   // assertEquals(2, wg.linkWeight(1, 22));
  }
  
//  @Test
//  public void testSuccessorsSortedList() {
//	  List<Integer> a = wg.successorsSortedList(1);
//	  List<Integer> expected = Arrays.asList(new Integer(14), new Integer(22), new Integer(22), new Integer(45));
//	  assertTrue("Expected 'a' and 'expected' to be equal."+
//	              "\n  'a'        = "+a+
//	              "\n  'expected' = "+expected, 
//	              expected.equals(a));
//  }
//  
//  @Test
//  public void testSuccessorsSortedSet() {
//	  Set<Integer> a = wg.successorsSortedSet(1);
//	  Set<Integer> expected = new java.util.TreeSet<Integer>(Arrays.asList(new Integer(14), new Integer(22), new Integer(45)));
//	  assertTrue("Expected 'a' and 'expected' to be equal."+
//	              "\n  'a'        = "+a+
//	              "\n  'expected' = "+expected, 
//	              expected.equals(a));
//  }
  // tests for asMatrix not shown

}
