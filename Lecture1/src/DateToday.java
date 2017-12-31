import java.text.SimpleDateFormat; //standard package
import java.util.Date; //standard package

public class DateToday { // Class name 'Date' is a standard identifier and would result in errors
    public static void main(String[] args) { // main method
        Date todaysDate; // Creates an instance 'todaysDate'of standard class Date
        SimpleDateFormat sdFormat; // defining an instance of standard class 'SimpleDateFormat'
        todaysDate = new Date(); // assigns today's date to 'todaysDate'
        sdFormat = new SimpleDateFormat("dd MMMM yyyy"); // blank arg would give the default output
        System.out.println(sdFormat.format(todaysDate)); // Formats'todaysDate'into required o/p

    }

}
