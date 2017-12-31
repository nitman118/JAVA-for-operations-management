
public class HtmlFormatter { //programmer defined class

    private static String inputstream; //data member
    private java.io.PrintStream o;
    boolean toggle;

    public HtmlFormatter(java.io.PrintStream out, boolean togglerint, String title) {
        o = out;
        toggle = togglerint;
     

    }

    public Object toHTMLpage() {
        java.io.PrintStream outone = null;
        boolean togglerintone = false;
        String titleone = null;
        HtmlFormatter html = new HtmlFormatter(outone, togglerintone, titleone);
        titleone = "<html><head><title></title></head><body></body></html>";
        return titleone;
    }

    public String print(String test) {
        if (toggle == true) {
            o.print(test);

        }
        return inputstream;
    }

    public void togglePrint() {
        if (toggle == false) {
            toggle = true;
        } else if (toggle == true) {
            toggle = false;
        }
    }

    public void settogglerint(boolean b) {
        toggle = b;
    }

    public static String convertToHTML(String test) {

        inputstream = test.replace("&", "&amp;");
        inputstream = inputstream.replace("<", "&lt;");
        inputstream = inputstream.replace(">", "&gt;");
        inputstream = inputstream.replace("\n", "<br>");
        inputstream = inputstream.replace("\"", "&quot;");
               inputstream = inputstream.replace("'", "&prime;");
              return inputstream;

    }

}