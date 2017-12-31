/**
 * Variant on Exercise 6 from book chapter 11
 */
public class I4Exc2 {
  /**
   * Static adapted version of book code
   * @author pvgorp
   * @param number
   */
  public static void selectionSortInt(int[] number) {
    /** BEGIN copy/paste book (w/ minor changes) */
    int minI, length, temp;
    length = number.length;
    for (int startI = 0; startI <= length - 2; startI++) {
      // each iteration of the for loop is one pass
      minI = startI;
      // find the smallest in this pass at
      // position minIndex
      for (int i = startI + 1; i <= length - 1; i++) {
        if (number[i] < number[minI])
          minI = i;
      }
      // exchange number[startIndex] and number[minIndex]
      temp = number[startI];
      number[startI] = number[minI];
      number[minI] = temp;
      assert minStart(number, startI) : "Error: " + 
          number[startI] + " at position " + startI + 
          " is not the smallest.";
    }
    assert isSorted(number) : "Error: not sorted properly";
  }
  /**
   * Static adapted version of book code
   * @author pvgorp
   * @param number
   */
  private static boolean minStart(int[] number, int startI) {
    for (int i = startI + 1; i < number.length; i++) {
      if (number[startI] > number[i]) {
        return false;
      }
    }
    return true;
  }
  /**
   * Static adapted version of book code
   * @author pvgorp
   * @param number
   */
  private static boolean isSorted(int[] number) {
    for (int i = 0; i < number.length - 1; i++) {
      if (number[i] > number[i + 1]) {
        return false;
      }
    }
    return true;
  }
  /** END copy/paste book */
  public static void main(String[] args) {
    int [] arr= new int[] {2,1,5,4,665,0,-1,-22222};
    System.out.println("Input version of arr="+
                java.util.Arrays.toString(arr));
    selectionSortInt(arr);
    System.out.println("Sorted version of arr="+
                java.util.Arrays.toString(arr));
  }

}
