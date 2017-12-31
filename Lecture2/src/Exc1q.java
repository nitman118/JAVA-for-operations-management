import java.util.Scanner; //importing class objects

public class Exc1q { // user defined class
    public static void main(String[] args) { // main method
        Scanner s = new Scanner(System.in); // instantiating scanner object
        System.out.println("Enter an INT: "); // obtaining input
        new Exc1q().doIt(s); // calling method doIt and passing object 's'
    }

    public int doIt(Scanner s) { // class method with scanner object being received

        int i = s.nextInt(); // input
        int a = 0; // initializing a
        int b = 0; // initializing b

        if (i < 8 || i > 10) { // condition 1
            a = 5;
        }

        else if (i == 8) { // nested if
            a = 3;
            b = 4;
        }

        else { // if both the conditions fail, i.e. i is either 9 or 10
            a = 1;
            b = 2;

        }

        int out = i + a + b; // compute output

        System.out.println("in = " + i);
        System.out.println("out = " + out);
        return out; // returns value of out to main method from where the doIt was called.
    }
}
