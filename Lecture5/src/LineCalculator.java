import java.io.BufferedReader; // package for buffered reading from file
import java.io.File; // for File processing
import java.io.FileNotFoundException; //for handling exception
import java.io.FileReader; // for using FileReader
import java.io.IOException; // for handling IO exception
import java.text.DecimalFormat; // for Decimal formatting
import java.util.Scanner; // for scanner

import javax.swing.JFileChooser; // for another way of selecting file

public class LineCalculator { // programmer defined class

    private static final String Empty = ""; // static string variable

    public static String getFile() throws IOException { // method, not used in this assignment
        String path = Empty;
        JFileChooser choose = new JFileChooser(); // JFile Chooser
        int reply = choose.showOpenDialog(null); // to show open, with Open heading

        if (reply == JFileChooser.APPROVE_OPTION) { // if input is valid
            path = choose.getSelectedFile().getAbsolutePath(); // returns path of selected file
        }
        return path; // returns full path for processing
    }

    public static void main(String[] args) { // main method

        try { // to catch exceptions
            Scanner s = new Scanner(System.in); // to get file name
            System.out.println("Enter the name of the input file: ");
            String str = s.next(); // input
            /*
             * String str = LineCalculator.getFile(); System.out.println(str);
             */
            int sum = 0; // intialize sum for calculating average
            int counter = 0; // couunter to calculate average
            DecimalFormat df = new DecimalFormat("0.00"); // to get 2 decimal points

            File inFile = new File(str); // assign file to inFile
            FileReader fileReader = new FileReader(inFile); // assign inFile to fileReader
            BufferedReader bufRead = new BufferedReader(fileReader); // fileReader to bufRead

            String str1 = bufRead.readLine(); // to store first line in Str1
            String shortestWord = str1; // for comparison
            String longestWord = str1; // for comparison
            while (str1 != null) { // while end of program is not reached

                if (str1.length() > longestWord.length()) { // compares lengths of 2 words
                    longestWord = str1; // if true, reinitialize longestWord
                } else {
                    if (str1.length() < shortestWord.length()) { // compares lengths of 2 words
                        shortestWord = str1; // if true, reinitialize shortestWord
                    }
                }
                sum = sum + str1.length(); // to calculate string length of all strings in file
                str1 = bufRead.readLine();
                counter++; // counter
            }
            bufRead.close(); // close BufferedReader
            s.close(); // close scanner

            System.out.println("Shortest line: " + shortestWord); // print result
            System.out.println("Longest line: " + longestWord); // print result
            System.out.println("Average length of the lines: " + // print result
                    df.format(((double) sum / counter))); // cast to double and set DecFormat
        }

        catch (FileNotFoundException f) { // exception handling
            System.out.println("File  not found");

        } catch (IOException e) { // exception handling
            System.out.println("Input/Output mismatch");

        }

    }
}