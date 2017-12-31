import java.io.*; // import package for all input/output operations and exception handling
import java.util.Scanner; // scanner package

/**
 * 
 * @author #1283901, Nitish Singh
 *
 */
public class I5Exc2 { // programmer defined class

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        textMenu(); // calls the menu
    }

    private static void writePersons(Person[] person, String filePerson) throws IOException {
        // method to write person objects
        File outFile = new File(filePerson); // create new file
        FileOutputStream fileOutputStream = new FileOutputStream(outFile); // new stream
        // to connect data to file
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream); // new
        // data stream, to write the number of objects
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // new object stream, to write object

        dataOutputStream.writeInt(person.length); // put length of array

        for (int x = 0; x < person.length; x++) { // serialize output
            objectOutputStream.writeObject(person[x]); // write to file
        }

        dataOutputStream.close(); // close data output stream
        objectOutputStream.close(); // close object output stream

        // Success message
        System.out.println(Integer.toString(person.length) + // number of people
                " Person written successfully to " + filePerson); // print
    }

    /**
     * Reads from filePerson an array of Person.
     * 
     * @param filePerson
     * @return readPersons
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Person[] readPersons(String filePerson) // programmer defined class
            throws IOException, ClassNotFoundException { // throw exception to textbox()
        File inFile = new File(filePerson); // open existing file
        FileInputStream inFileStream = new FileInputStream(inFile); // connect file stream
        ObjectInputStream objectInputStream = new ObjectInputStream(inFileStream);
        // read objects from file
        DataInputStream dataInputStream = new DataInputStream(inFileStream);
        // read data(int) from file

        int n1 = dataInputStream.readInt(); // initialize n1 with number of data objects
        Person[] personA = new Person[n1]; // initialize new array

        // Success message
        for (int i = 0; i < n1; i++) {
            personA[i] = (Person) objectInputStream.readObject(); // assign class objects serially

        }
        System.out.println(/* Integer.toString(n1) */ n1 + // output
                "Person read successfully from file " + filePerson); // output
        objectInputStream.close(); // close object input stream
        dataInputStream.close(); // close data input stream
        return personA; // return array reference

    }

    /**
     * Displays to console the contents of an array of Persons.
     * 
     * @param personB
     * @throws IOException
     */
    private static void displayPersons(Person[] personB) {
        // class method to display person from array
        for (Person p : personB) { // for-each to access each object
            System.out.println(p.getName() + "     " + p.getAge() + // output
                    "     " + p.getGender()); // output
        }
    }

    private static Person[] createPersons(int n) { // class method
        // File outFile = new File("File12.dat");
        // FileOutputStream outFileStream = new FileOutputStream(outFile);
        // ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

        Person[] person = new Person[n]; // create person array

        for (int i = 0; i < n; i++) { // create N person object
            person[i] = new Person("Mr. Espresso" + i, 20 + i, 'M'); // initialize person
            // and assign it to class array
            // outObjectStream.writeObject(person[i]); // write
        }

        // outObjectStream.close(); // close stream
        return person; // close stream
    }

    private static void textMenu() { // class method
        // handle user commands
        boolean quit = false; // boolean
        int menuItem = 0; // initialize variable
        Scanner sc = new Scanner(System.in); // to scan user input
        sc.useDelimiter(System.lineSeparator()); // use as delimiter new line,
        // behaviour as nextInt or nextDoublemaking scanner.next to have the same
        Person[] person = null; // no address
        do {
            printMenu(); // class method to print menu
            menuItem = sc.nextInt(); // input for switch case

            switch (menuItem) { // switch case
            case 1:// 1. Read File containing objects of class Person
                System.out.println("Input <Persons file> name");
                String filePerson = sc.next(); // input file name
                try { // try catch for exception handling
                    person = readPersons(filePerson); // get array reference after reading
                    // from file
                } catch (IOException e) { // exception handling
                    System.out.println("Person file not found.");
                    System.out.println(e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("File <" + filePerson + // output
                            "> does not contains valid Person object"); // output
                    System.out.println(e.getMessage());
                }
                break; // break
            case 2:// 2. Create p objects of class Person
                System.out.println("Input number of objects to be created");
                int n = sc.nextInt(); // input persons to create
                person = createPersons(n); // class method call and pass array reference
                break;
            case 3: // 3. Write File with objects of class Person
                System.out.println("Input <Persons file> name");
                String filePersonW = sc.next(); // Input name of file to write data in
                if (person == null) { // if person array does not point to objects
                    System.out.println("Nothing to write.");
                } else {
                    try { // exception handling
                        writePersons(person, filePersonW); // if correct, send array and file name
                    } catch (IOException e) { // exception handling
                        System.out.println("Person file not found."); // custom output
                        System.out.println(e.getMessage());
                    }

                }
                break;
            case 4:// 4. Display p objects of class Person
                System.out.println("");
                if (person == null) { // if array refers to null
                    System.out.println("Nothing to show");
                } else {
                    displayPersons(person); // class method call
                }
                break;
            case 5:
                quit = true; // to exit
                break;
            default:
                System.out.println("Invalid choice."); // input mismatch
            }
        } while (!quit); // repeat loop until loop becomes true
        System.out.println("Bye-bye!"); // after loop ends
        sc.close(); // close scanner
    }

    private static void printMenu() { // class method
        System.out.println("Choose menu item: "); // console display
        System.out.println("1. Read File containing objects of class Person");
        System.out.println("2. Create p objects of class Person");
        System.out.println("3. Write File with objects of class Person");
        System.out.println("4. Display p objects of class Person");
        System.out.println("5. Exit");
    }

}
