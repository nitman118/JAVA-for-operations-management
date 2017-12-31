import java.util.Scanner;

public class Ch2StringProcessing2 {
	public static void main(String[] args) {
		String fullName,firstName,lastName,space,f1,f2;
		System.out.print("Enter your Name: ");
		Scanner scanner = new Scanner(System.in);
		f1= scanner.next();
		f2=scanner.next();
		fullName= f1 + " " + f2;
		space = new String(" ");
		firstName = fullName.substring(0, fullName.indexOf(space));
		lastName= fullName.substring(fullName.indexOf(space)+1,fullName.length());
		System.out.println("Full Name: " + fullName);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName +", has "+ lastName.length() + " characters.");
	}

}
	