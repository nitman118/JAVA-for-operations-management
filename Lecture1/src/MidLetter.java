import java.util.Scanner; //standard package

public class MidLetter { // user defined class
    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in); // creating a new instance of Scanner class
        String text = scanner.next(); // initializing text
        System.out.println(text.substring(text.length() / 2, text.length() / 2 + 1));
        // substring clause is initialized and start number is given as length/2
        // output length, as given in documentation is end index - begin index, and
        // hence the '+1'
        scanner.close(); // to avoid scanner warning

    }

}
