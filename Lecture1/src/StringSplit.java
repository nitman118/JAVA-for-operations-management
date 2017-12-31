import java.util.Scanner; //Standard Package

public class StringSplit { // User Defined Class
    public static void main(String[] args) { // main method
        String text; // Initializing instance of String Class
        Scanner scanner = new Scanner(System.in); // Initializing scanner instance
        scanner.useDelimiter(System.getProperty("line.separator")); // Changing delimiter to
        // system standard for line separator ('Enter'), otherwise the first word would
        // be taken as input
        text = scanner.next(); // Initializing string value in ''text
        System.out.println(text.substring(0, text.indexOf("!"))); // substring prints part of string
        // indexOf provides the value when '!'is encountered
        System.out.println(text.substring(text.indexOf("!") + 1, text.length())); // searches '!',
        // and prints from one character ahead till the end
        scanner.close(); // checked on google, to fix the scanner error

    }

}
