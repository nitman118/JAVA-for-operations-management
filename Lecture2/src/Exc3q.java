import java.util.Scanner; //import package

public class Exc3q { // programmer defined class
    public static void main(String[] args) { // main method

        Scanner scan = new Scanner(System.in); // class object scan
        System.out.println("Enter a year (as an INT): ");
        new Exc3q().doIt(scan); // calls class method - 'doIt' and passes 'scan' object

    }

    public void doIt(Scanner s) { // Class method accepting scanner object in s

        int selection = s.nextInt(); // input

        if (selection % 400 == 0) // condition 1
        {
            System.out.println("Leap Year");
        }

        else {
            if (selection % 4 == 0 && selection % 100 != 0) // condition 2
            {
                System.out.println("Leap Year");
            }

            else // if both the conditions are false
            {
                System.out.println("Not a Leap Year");
            }
        }
    }
}
