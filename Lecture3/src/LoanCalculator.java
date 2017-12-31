import java.util.Scanner;

public class LoanCalculator {
   
    // Data members
    private Loan loan;
   
    //constructor
    public LoanCalculator() {
        
    }
  
    //Instance methods
    public void start(){
       
    
    describeProgram();
    getInput();
    displayOutput();
    }
 
    private void describeProgram() {
       
        System.out.println("Inside describeProgram");
       
    }
   
    private void getInput() {
        double loanAmount;
        double annualInterest;
        int loanPeriod;
        
        Scanner scanner= new Scanner(System.in);
        
        System.out.println("Loan Amount (Dollars + Cents):")	;
        loanAmount = scanner.nextDouble();
        
        System.out.println("Annual Interest Rate:");
        annualInterest = scanner.nextDouble();
        
        System.out.println("Loan Period:");
        loanPeriod = scanner.nextInt();
        
        loan= new Loan(loanAmount,annualInterest,loanPeriod);
        
      
        System.out.println("Loan Amount: $" + loan.getAmount());
        System.out.println("Annual Interest Rate:"
        + loan.getRate() + "%");
        System.out.println("Loan Period (years):" + loan.getPeriod());
        
        scanner.close();
        
        		
    }
   
   
   
    private void displayOutput() {
    	System.out.println("Monthly payment is $ " +
    			loan.getMonthlyPayment() );
    			System.out.println(" TOTAL payment is $ " +
    			loan.getTotalPayment() );
       
    }
   
    
    
    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator();
        calculator.start();
    }
   
 
}