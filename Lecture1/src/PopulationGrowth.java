import java.text.DecimalFormat; //package declaration
import java.util.Scanner; //package declaration

public class PopulationGrowth { // user defined class
    public static void main(String[] args) { // main method

        DecimalFormat dFormat = new DecimalFormat("0"); // Putting '0'outputs integer values
        Scanner scan = new Scanner(System.in);

        double year1;
        double year2;
        double pop1;
        double pop2;
        double k;
        double year3;

        year1 = scan.nextDouble();
        pop1 = scan.nextDouble();
        year2 = scan.nextDouble();
        pop2 = scan.nextDouble();
        year3 = scan.nextDouble();

        // calculate k

        k = (1 / (year2 - year1) * Math.log(pop2 / pop1));

        // calculate new population

        double popPredict = pop1 * Math.pow(Math.E, (k * (year3 - year1)));

        System.out.print(dFormat.format(popPredict));

        scan.close();

    }

}
