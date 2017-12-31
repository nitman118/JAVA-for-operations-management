import java.util.Scanner;

public class Halfrepeat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name;
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (true) {
            System.out.print("Name:");

            name = scanner.next();

            if (name.length() != 0) {
                break;
            }

            System.out.println("Invalid,enter one character");
        }

        System.out.println(name);
        scanner.close();
    }

}
