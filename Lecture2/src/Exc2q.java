import java.util.Scanner; //importing package

public class Exc2q { // programmer defined class

    public static void main(String[] args) { // main method

        Scanner s = new Scanner(System.in); // creating a new class object

        System.out.println("Enter an INT: "); // Input selection

        new Exc2q().doIt(s); // calling class method and passing class variable

    }

    public String doIt(Scanner s) { // class method

        int selection = s.nextInt();
        String out = "ERR"; // initializing out

        switch (selection) { // switch selection on

        case 0:
            out = "You selected Magenta"; // case 0
            break; // terminate
        case 1:
            out = "You selected Cyan"; // case 1
            break; // terminate
        case 2:
            out = "You selected Red"; // case 2
            break; // terminate
        case 3:
            out = "You selected Blue"; // case 3
            break; // terminate
        case 4:
            out = "You selected Green"; // case4
            break; // terminate
        default:
            out = "Invalid selection"; // for all other cases
            break;
        }

        System.out.println(out); // print output
        return out; // return string
    }

}
