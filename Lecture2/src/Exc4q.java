import java.util.Scanner; //importing package

public class Exc4q { // programmer defined class
    public static boolean isPrime(int in) { // class method 1

        if (in == 1) { // 1 is not prime nor composite
            return false;
        } else {
            for (int p = 2; p <= in / 2; p++) { // checking division by all numbers from 2 to
                // (number / 2), if none of the numbers divide, it is prime
                if (in % p == 0) {
                    return false; // return false for prime if a number divides 'in'
                }
            }
            return true; // else return true
        }
    }

    public void doIt(Scanner scan) { // doIt method

        int in = scan.nextInt();
        while (in > 0) { // run the program until a value lesser than 1 is entered
            if (isPrime(in)) { // if (true)
                System.out.println("Prime");

            } else {
                System.out.println("Not Prime");
            }

            in = scan.nextInt();
        }
    }

    public static void main(String[] args) { // main method
        Scanner scan = new Scanner(System.in); // creating new instance of Scanner class
        System.out.println("Enter positive INTs to be checked: ");
        new Exc4q().doIt(scan); // call instance diIt of class Exc4q

    }
}
