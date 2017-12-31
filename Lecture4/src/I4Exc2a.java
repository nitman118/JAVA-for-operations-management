
public class I4Exc2a { // programmer defined class
    /*
     * public static void selectionSortString(String[] str1) { Arrays.sort(str1);
     * //leveraging standard sort method from java.util library for(int i=0;
     * i<str1.length;i++) { System.out.println(str1[i]); } }
     * 
     */
    public static void selectionSortString(String[] str) { // static method to perform selection
        // sort on string array
        int minI; // to define the index of lowest element
        int length = str.length; // initialize variable 'length' with str array length
        String temp; // to perform swap if necessary
        for (int startI = 0; startI <= length - 2; startI++) { // outer for-loop
            // each iteration of the for loop is one pass
            minI = startI;
            // find the smallest in this pass at
            // position minIndex
            for (int i = startI + 1; i <= length - 1; i++) { // inner for-loop
                if (str[i].compareTo(str[minI]) < 0) { // if ascii value of str[x+1] is lesser
                    // than str[x] then the position is swapped
                    minI = i;
                }
            }
            // exchange operation
            temp = str[startI];
            str[startI] = str[minI];
            str[minI] = temp;

            // assert 1 - confirms that the smallest element in that pass
            // moved to the beginning position
            assert minStart(str, startI) : "Error: " + str[startI] + " at position " + startI + 
                                   " is not the smallest.";
        }

        // assert 2 - to verify that no elements are out of place after the sorting is
        // complete
        assert isSorted(str) : "Error: not sorted properly";
    }

    private static boolean minStart(String[] str1, int startI) { // assert method 1
        for (int i = startI + 1; i < str1.length; i++) {
            if (str1[startI].compareTo(str1[i]) > 0) { // if the preceding object
                // is lexicographically more than the following one
                return false;
            }
        }
        return true;
    }

    private static boolean isSorted(String[] str1) { // assert method 2
        for (int i = 0; i < str1.length - 1; i++) {
            if (str1[i].compareTo(str1[i + 1]) > 0) { //
                return false;
            }
        }
        return true;
    }

}
