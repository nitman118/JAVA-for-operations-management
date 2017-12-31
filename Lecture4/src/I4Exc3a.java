import java.util.LinkedList; //for LinkedList
import java.util.List; // for modifying list
import java.util.Scanner; // package for scanner

public class I4Exc3a { // programmer defined class

    public static void main(String[] args) { // main method

        Scanner scan = new Scanner(System.in); // initialize scanner
        scan.useDelimiter(System.getProperty("line.separator")); // change line-separator to'Enter'
        System.out.println("Please enter Strings to be sorted. Enter 'SORT!' "
                + "(without quotes) to stop reading String inputs.");
        List<String> str = new LinkedList<String>(); // create new list of type LinkedList
        // Linked lists are better for storing and manipulating data
        String input = scan.nextLine(); // input

        while (!"SORT!".equals(input)) { // while the string is not equal to 'SORT!'
            str.add(input); // apends data to linked list 'str'
            input = scan.nextLine();
        }
        computeList(str); // calls class method and passes linked list
        scan.close(); // to avoid warning

    }

    public static String[] computeList(List<String> str) { // class method 1
        System.out.println("Input strings=" + str); // displays element of linked list
        String[] sorStr = str.toArray(new String[str.size()]); // converts list to String Array
        selectionSortString(sorStr); // sends reference of string array and selection sorts it
        System.out.println("Sorted version=" + java.util.Arrays.toString(sorStr)); // output
        return sorStr; // for test

    }

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

        }

    }
}
