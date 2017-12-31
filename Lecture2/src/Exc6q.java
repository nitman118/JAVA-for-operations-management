import java.util.Scanner; //import scanner package

public class Exc6q { // programmer defined class
    public static void main(String[] args) { // main method
        Scanner s = new Scanner(System.in); // create new scanner object
        System.out.println("Enter the lower and upperbound: "); // print line
        System.out.println("Number of Primes in between: " + new Exc6q().doIt(s)); // method call
    }

    public int doIt(Scanner s) { // class method
        int count = 0; // initialize count
        int in1 = s.nextInt(); // input lower value
        int in2 = s.nextInt(); // input upper value
        if (in1 < 2) {
            in1 = 2;
        }
        int comp = 0; // variable to facilitate counting of prime numbers
        for (int p = in1; p <= in2; p++) { // for checking all numbers in between
            for (int q = 2; q <= p / 2 && comp == 0; q++) { // check for prime number
                if (p % q == 0) { // if remainder is 0
                    comp++; // increase comp by 1
                }
            }
            if (comp == 0) { // check if comp is 0, i.e the number 'p' is prime
                count++; // increase by 1 for every 'p' encountered in the loop
            }
            comp = 0; // reinitialize comp to 0 for new loop
        }
        return count; // return final value of prime numbers
    } // close method
} // close public class
