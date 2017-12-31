public class TutorialClass { //user defined class
    void show() { //class object
        System.out.println("Hello world...");
        System.out.println("This is a working Java program!");
    }

    public static void main(String[] args) { //main method
        TutorialClass hw = new TutorialClass();
        hw.show();
    }
}