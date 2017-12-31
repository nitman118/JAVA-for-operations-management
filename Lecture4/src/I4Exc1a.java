
public class I4Exc1a { // programmer defined class

    public static int[] reverse(int[] number) { // static method reverse, accepts array reference

        int[] revnumber = new int[number.length]; // initialize a new array, eventually returned
        int j = 0; // integer variable to index the revnumber array

        for (int i = number.length - 1; i >= 0; i--) { // for-loop that begins with last
            // element of passed array and assigns it to revnumber
            revnumber[j] = number[i]; // operation
            j++; // increments j
        }

        return revnumber; // returns array reference

    }
}
