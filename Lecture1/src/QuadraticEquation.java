import java.util.Scanner; // package declaration

public class QuadraticEquation { // user defined class

    public static void main(String[] args) { // main method

        double a; // Variable type declaration
        double b; // Variable type declaration
        double c; // Variable type declaration
        double x1; // Variable type declaration
        double x2; // Variable type declaration
        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        x1 = (-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
        // arithmetic expression
        x2 = (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);

        System.out.print("x1:" + " " + x1 + "\n" + "x2:" + " " + x2); // "\n":next line

        scan.close(); // to prevent scanner warning
    }

}
