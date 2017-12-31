import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFileChooser;

public class Example {

    public static void main(String[] args) throws IOException {

        File infile = new File("../name.txt");
        FileOutputStream output = new FileOutputStream(infile);
        
        

        if (infile.exists()) {
            System.out.println("File is present");

        }else {
            System.out.println("File is absent");    
        }
        

   
    
    File file, directory;
    String current = System.getProperty("user.dir");

    JFileChooser chooser = new JFileChooser(current);
    int status = chooser.showDialog(null, "Compie");
    
    if(status==JFileChooser.APPROVE_OPTION)
    {
        file = chooser.getSelectedFile();
        directory = chooser.getCurrentDirectory();
        System.out.println("Directory: " + directory.getName());
        System.out.println("File selected to open: " + file.getName());
        System.out.println("Full path name: " + file.getAbsolutePath());
    }else
    {
        System.out.println("Open File dialog canceled");
    }
    
    byte [] bytedata =  {'h','e'};
    
    output.write(bytedata);
    
    
}
}

