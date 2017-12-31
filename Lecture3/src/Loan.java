/*
 * Write a loan calculator program that computes both monthly and total payments
for a given loan amount, annual interest rate, and loan period.

1. Get three input values: loanAmount, interestRate, and loanPeriod.
2. Compute the monthly and total payments.
3. Output the results.


 */

public class Loan { // programmer defined class

    // data members

    private static final int MONTHS_IN_YEAR = 12; // private constant
    private double loanAmount; // private variable
    private double monthlyInterestRate; // private variable
    private int numberOfPayments; // private variable

    // constructor

    public Loan(double amount, double rate, int period) { // accepts double, double, integer
        setAmount(amount); // calls instance method
        setPeriod(period); // calls instance method
        setRate(rate); // calls instance method
    }

    // instance methods

    public void setPeriod(int periodInYear) { // class instance method to set period
        numberOfPayments = periodInYear * MONTHS_IN_YEAR; // mutator
    }

    public int getPeriod() { // class instance method to get period
        return (numberOfPayments / MONTHS_IN_YEAR); // accessor
    }

    public void setAmount(double amount) { // class instance method to set Amount
        loanAmount = amount; // mutator
    }

    public double getAmount() { // class instance method to get amount
        return loanAmount; // accessor
    }

    public void setRate(double rate) {// class instance method to set rate

        monthlyInterestRate = rate / 100 / MONTHS_IN_YEAR; // mutator
    }

    public double getRate() { // class instance method to get rate of interest
        return monthlyInterestRate * 100 * MONTHS_IN_YEAR; // accessor
    }

    public double getMonthlyPayment() { //// class instance method to get monthly payments
        double monthlyPayment; // local vriable
        monthlyPayment = (loanAmount * monthlyInterestRate)
                / (1 - Math.pow(1 / (1 + monthlyInterestRate), numberOfPayments)); // loan formula
        if (monthlyPayment != monthlyPayment) { // to check for NaN
            return loanAmount / numberOfPayments; // if true
        }
        return monthlyPayment; // else return the formulated value
    }

    public double getTotalPayment() { //// class instance method to get total payment
        double totalPayment; // local variable
        totalPayment = getMonthlyPayment() * numberOfPayments; // formula
        return totalPayment; // return double
    }

}
