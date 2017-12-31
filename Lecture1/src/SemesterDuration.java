import java.util.Calendar; //import standard package objects
import java.util.GregorianCalendar; //import standard package objects
import java.util.Scanner; //import standard package objects

public class SemesterDuration { // user defined class
    public static void main(String[] args) { // main method
        Scanner scan = new Scanner(System.in); // instantiating scan
        GregorianCalendar grCal1; // creating class object for first set of dates
        GregorianCalendar grCal2; // creating class object for second set of dates

        int year1 = scan.nextInt();
        int month1 = scan.nextInt();
        int date1 = scan.nextInt();

        int year2 = scan.nextInt();
        int month2 = scan.nextInt();
        int date2 = scan.nextInt();

        grCal1 = new GregorianCalendar(year1, month1 - 1, date1); // creating Greg.Cal as per format
        grCal2 = new GregorianCalendar(year2, month2 - 1, date2); // creating Greg.Cal as per format

        System.out.print(grCal2.get(Calendar.DAY_OF_YEAR) - grCal1.get(Calendar.DAY_OF_YEAR) + 1);

        scan.close();

    }

}
