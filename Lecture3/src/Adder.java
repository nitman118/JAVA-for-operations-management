
public class Adder { // programmer defined class

    // data members

    private int sum = 0; // class variable with initial value as 0
    private int count = 0; // class variable with initial value as 0

    // constructors

    public Adder() { // constructor 1, explicit, when arguments are not passed
    }

    public Adder(int s) { // constructor 2, when arguments are passed
        this.setSum(s);
    }

    // class instance methods

    private void setSum(int s) { // private method to set sum and count when values are passed
        // this class is private, a client programmer should not be able to initialize
        // sum twice
        sum += s; // adds sum
        this.setNumValues(); // counter method
    }

    public int getSum() { // returns sum
        return sum;
    }

    private void setNumValues() { // private method, executed whenever values are passed
        count++; // this class is private to avoid tampering with count from outside the class
    }

    public int getNumValues() { // return count
        return count;
    }

    public void add(int add) { // add method for addition operation on initialized sum
        this.setSum(add); // this(optional) points to class instance
    }

    public void plusOne() { // method to increase sum by 1

        sum += 1;

    }

}
