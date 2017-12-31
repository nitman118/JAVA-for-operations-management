import java.util.Scanner;

public class AdderNumbers {

    // data members

    private Adder adder;

    public AdderNumbers() {

    }

    public void start() {

        this.describeProgram();
        this.getInput();
        this.displayOutput();

    }

    private void describeProgram() {

        System.out.println("This is describeProgram");
    }

    private void getInput() {

        adder = new Adder();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number to add:");
        int number = scan.nextInt();
        adder.add(number);
        
        System.out.println("Want to add another (Y/N);");
        String s = scan.next();

        while (s.equals("Y")) {
            System.out.println("Next number:");
            number = scan.nextInt();
            adder.add(number);
            
            System.out.println("Want to add another (Y/N);");
            s = scan.next();

        }

    }

    private void displayOutput() {
        System.out.println("Total sum:" + adder.getSum());
        System.out.println("Count:" + adder.getNumValues());
    }
    
    public static void main(String[] args) {
        
        AdderNumbers addit = new AdderNumbers();
        addit.start();
        
    }

}
