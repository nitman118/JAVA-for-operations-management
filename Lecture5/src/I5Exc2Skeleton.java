import java.io.*;
import java.util.Scanner;


/**
 * Skeleton of the solution to Assignment 6, Exercise 2, 
 * File I-O and display to console of classes Person.
 * 
 * Note: Currently not working, IOException should be caught.
 * 
 * @author #StudentNumber, StudentName
 *
 */
public class I5Exc2Skeleton {

	/**
	 * Initializes and shows the menu for the solution to Assignment 6, Exercise 2. 
	 * 
	 * @param args
	 * @throws IOException, ClassNotFoundException 
	 */
	public static void main(String[] args) {
		TextMenu();
	}


	/**
	 * Writes an array Person to file filePerson.
	 * 
	 * @param person
	 * @param filePerson
	 * @return 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void writePersons(Person[] person, String filePerson) {
		//TODO
		System.out.println("To be implemented - write to " + filePerson);
		//Success message
		System.out.println(Integer.toString(person.length) + " Person written successfully to " + filePerson);
	}


	/**
	 * Reads from filePerson an array of Person. 
	 * 
	 * @param filePerson
	 * @return readPersons
	 * @throws IOException
	 */
	private static Person[] readPersons(String filePerson) {
		//TODO
		System.out.println("To be implemented - read from "+filePerson);
		//STUB delete when implementing
		int N1 = 1;
		Person personA[] = new Person[N1]; //Array to save in AddressBook
		//Success message
		System.out.println(Integer.toString(N1) + " Person read successfully from file " + filePerson);
		return personA;

	}


	/** 
	 * Displays to console the contents of an array of Persons.
	 * 
	 * @param personB
	 */
	private static void displayPersons(Person[] personB) {
		//TODO
		System.out.println("To be implemented - display Person");
	}

	/**
	 * Creates an array of Person of size N.
	 * 
	 * @param N
	 * @return createPersons
	 */
	private static Person[] createPersons(int N) {
		//TODO
		System.out.println("To be implemented - create "+N+" Person");
		//STUB
		Person person[] = new Person[N];
		return person;
	}

	/**
	 * Handles the user choices from the menu.
	 * 
	 * @param N
	 * @return void
	 */
	private static void TextMenu() {
		// handle user commands
		boolean quit = false;
		int menuItem = 0;
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.lineSeparator());//use as delimiter new line, making scanner.next to have the same behaviour as nextInt or nextDouble.
		Person person[] = null;
		do {
			printMenu();
			menuItem = sc.nextInt();

			switch (menuItem) {
			case 1://1. Read File containing objects of class Person		
				System.out.println("Input <Persons file> name");
				String filePerson = sc.next();
				//Catch or propagate exception?
				person = readPersons(filePerson);
				break;
			case 2://2. Create p objects of class Person
				System.out.println("Input number of objects to be created");
				int N = sc.nextInt();
				person = createPersons(N);
				break;
			case 3: //3. Write File with objects of class Person
				System.out.println("Input <Persons file> name");
				String filePersonW = sc.next();
				if (person == null) {
					System.out.println("Nothing to write.");
				} else {
					//Catch or propagate exception?
					writePersons(person,filePersonW);
				}
				break;
			case 4://4. Display p objects of class Person
				System.out.println("");
				displayPersons(person);
				break;
			case 5:
				quit = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (!quit);
		System.out.println("Bye-bye!");
		sc.close();
	}
	
	/**
	 * Prints the menu choices available. 
	 */
	private static void printMenu() {
		System.out.println("Choose menu item: ");
		System.out.println("1. Read File containing objects of class Person");		
		System.out.println("2. Create p objects of class Person");
		System.out.println("3. Write File with objects of class Person");
		System.out.println("4. Display p objects of class Person");
		System.out.println("5. Exit");
	}

}

