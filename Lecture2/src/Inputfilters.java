import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputfilters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = "Enter Value of age: ";
        
        boolean keepgoing = true;
        
        while(keepgoing)
        {
                   
        try {
            System.out.print(string);

            int age = scan.nextInt();
            keepgoing = false;

        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry, Enter Again");
            scan.next();
        }
        }

    }

}
