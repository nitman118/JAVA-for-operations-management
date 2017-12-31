import java.util.InputMismatchException; //import package for exception handling
import java.util.Scanner; //importing package

public class Exc7q { // programmer defined class
    public static boolean isPrime(int in) { // class method 1

        if (in == 1) { // 1 is not prime nor composite
            return false; // return boolean
        } else {
            for (int p = 2; p <= in / 2; p++) // checking division by all numbers from 2 to
            // (number / 2), if none of the numbers divide, it is prime
            {
                if (in % p == 0) {
                    return false; // return false for prime if a number divides 'in'
                }
            }
            return true; // if none of the numbers divide in, return true
        }
    }

    public void doIt(Scanner scan) { // class method, accepting scanner object

        boolean keepgoing = true; // defining boolean to terminate the loop when in = 0

        while (keepgoing) {
            try { // try open
                int in = scan.nextInt(); // input value
                while (in > 0) { // loop until value of in is not less than 1
                    if (isPrime(in)) { // if (true)
                        System.out.println("Prime");
                    } else {
                        System.out.println("Not Prime");
                    }
                    in = scan.nextInt(); // input for next variable
                }
                keepgoing = false; // if in < 1, this line is executed and in turn terminates the
                // outer loop
            } catch (InputMismatchException e) { // type mismatch handling
                System.out.println("Invalid input: " + scan.next()); // print the invalid output
                // and to clear garbage value from input buffer
            }
        }
    }

    public static void main(String[] args) { // main method
        Scanner scan = new Scanner(System.in); // creating new instance of Scanner class
        System.out.println("Enter positive INTs to be checked: ");
        new Exc7q().doIt(scan); // call instance doIt of class Exc7q
    }
}
