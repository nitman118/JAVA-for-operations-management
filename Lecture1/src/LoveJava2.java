import javax.swing.JFrame;

public class LoveJava2 {
	public static void main(String[] args) {
		
		String text;
		text = "Nitish Singh"; // String Class objects do not need new for creating a new instance
		System.out.println(text.substring(2, 10)); // Substring defines the starting point ( exclusive of starting position, as the first position is 0), till the end of the string
		System.out.println(text.indexOf("S"));// index of return the position of cases sensitive match of the searched string
	
	}

}
