import java.text.DecimalFormat; //importing package
import java.util.Scanner; //importing package

public class TemperatureConversion { // user defined class
    public static void main(String[] args) { // main method

        DecimalFormat decForm = new DecimalFormat("0.00"); // an instance is created
        // to view 2 decimal points
        float celsius; // variable declaration
        float fahrenheit; // variable declaration
        Scanner scan = new Scanner(System.in);
        fahrenheit = scan.nextFloat();
        celsius = (float) ((fahrenheit - 32) / 1.8); // arithmetic expression, typecast operator
        // (float) prevents type mismatch
        System.out.println(decForm.format(celsius) + " C"); // displaying required formatted output
        scan.close(); // to avoid warning

    }

}
