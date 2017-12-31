import java.text.SimpleDateFormat; //standard package
import java.util.Scanner; //standard package
import java.util.Date; //standard package

public class BirthDate { // user defined class
    public static void main(String[] args) { // main method

        Scanner scanner = new Scanner(System.in); // Instantiating Scanner object
        SimpleDateFormat sdFormat; // creating an instance of standard class SimpleDateFormat
        sdFormat = new SimpleDateFormat("EEEE"); // setting the format to 'Day only'
        // System.out.print("Enter DOB(yyyy-mm-dd):");
        Date date1 = java.sql.Date.valueOf(scanner.next()); // Inputting string and
        // converting it to date. It is important to write java.sql.Date to specify
        // which class
        // method we wish to use
        System.out.print(sdFormat.format(date1)); // outputting date in required format
        scanner.close(); // for ignoring the warning, elaboration required..
    }

}
