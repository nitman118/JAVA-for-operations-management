import java.text.DecimalFormat; //import package objects
import java.util.Scanner; //import package objects

public class LoanCalculator { // user defined class
    public static void main(String[] args) { // main method
        int period; // defining period as int, for number of months
        double interest; // float data type for rate of interest
        int amount; // int for number of cents

        Scanner scan = new Scanner(System.in);

        amount = scan.nextInt();
        interest = scan.nextDouble() / (12 * 100); // converting yearly interest rate to monthly
        period = scan.nextInt() * 12; // changing years to months

        
        float monthlyPayments =(float)((amount * interest) / 
                (1 - Math.pow(1 / (1 + interest), period))); // Loan calculation, note
        // that (float) typecasting has been done to convert double integer type

        float fullPayment = monthlyPayments * period;
        
        DecimalFormat df = new DecimalFormat("0.00"); // to get 2 decimal points
        
              
        System.out.println("Monthly payment is $ " + df.format((monthlyPayments) / 100));
        System.out.println("TOTAL payment is $ " + df.format((fullPayment)/100)); 
        // division by 100 is done to convert cents to dollars
        
        scan.close();

    }

}
