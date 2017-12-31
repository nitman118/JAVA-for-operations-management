import static org.junit.Assert.*;
import org.junit.Test;
/** PUBLIC in PEACH */
public class I4Exc2Test {
  @Test
  public void testSelectionSortInt1() {
    int arr[]= new int[]{2, 1, 5, 4, 665, 0, -1, -22222};
    int arrCopy[]= arr.clone();
    I4Exc2.selectionSortInt(arrCopy);
    assertArrayEquals(java.util.Arrays.toString(arr)+
        " not properly sorted", arrCopy, 
        new int[]{-22222, -1, 0, 1, 2, 4, 5, 665});
  }
  /** should fail
  @Test
  public void testSelectionSortInt2() {
    int arr[]= new int[]{2, 1, 5, 4, 665, 0, -1, -22222};
    int arrCopy[]= arr.clone();
    I5Exc1.selectionSortInt(arrCopy);
    assertArrayEquals(java.util.Arrays.toString(arr)+
      " not properly sorted", arrCopy, 
      new int[]{-22222, 0, -1, 1, 2, 4, 5, 665});
  }*/
}
