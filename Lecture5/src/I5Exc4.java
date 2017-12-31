import java.awt.Color; // package for Color
import java.io.DataInputStream; // package for data input
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell; // apache POI package
import org.apache.poi.ss.usermodel.FillPatternType; // apache POI package
import org.apache.poi.ss.usermodel.HorizontalAlignment; // apache POI package
import org.apache.poi.ss.usermodel.Row; // apache POI package
import org.apache.poi.ss.usermodel.VerticalAlignment; // apache POI package
import org.apache.poi.xssf.usermodel.XSSFCellStyle; // apache POI package
import org.apache.poi.xssf.usermodel.XSSFColor; // apache POI package
import org.apache.poi.xssf.usermodel.XSSFFont; // apache POI package 
import org.apache.poi.xssf.usermodel.XSSFSheet; // apache POI package
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // apache POI package

public class I5Exc4 { // programmer defined class
    public static void main(String[] args) {
        // main method
        System.out.println("Input <Persons file>"); // input file.dat
        Scanner scan = new Scanner(System.in); // input file.dat
        String fileName = scan.next(); // input file.dat
        System.out.println("Input <Excel file>"); // initialize excel workbook
        String workBook = scan.next(); // initialize excel workbook
        System.out.println("Input <worksheet>"); // initialize sheet
        String workSheet = scan.next(); // initialize sheet

        try { // exception handling
            Person[] p = readPersons(fileName); // initialize Person array by reading from file
            writePersons(p, workBook, workSheet); // class method call, pass relevant values
        }

        catch (IOException e) { // exception handling
            System.out.println("Input/Output files not found");
            System.out.println(e.getMessage());

        }

        catch (ClassNotFoundException e) { // exception handling 2
            System.out.println("File <" + fileName + "> does not contains valid Person object");
            System.out.println(e.getMessage());
        }

        scan.close(); // close scan

    }

    private static void writePersons(Person[] person, String filePerson, String sheetLabel) //
            throws IOException { // static class method
        // method to write person objects
        File outFile = new File(filePerson); // create new file
        FileOutputStream fileOutputStream = new FileOutputStream(outFile); // new stream

        XSSFWorkbook book = new XSSFWorkbook(); // Apache POI object initialization
        XSSFSheet sheet = book.createSheet(sheetLabel); // create sheet
        Row row = sheet.createRow(0); // create Header row
        // create header cells
        Cell cell = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        Cell cell3 = row.createCell(3);

        // Cell styling parameters for headers, style
        // style 1

        XSSFCellStyle style = book.createCellStyle(); // initialize 'style'
        style.setAlignment(HorizontalAlignment.CENTER); // horizontal alignment
        style.setVerticalAlignment(VerticalAlignment.CENTER); // vertical alignment
        style.setFillForegroundColor(new XSSFColor(Color.BLUE)); // set cell colour
        style.setFillPattern(FillPatternType.LESS_DOTS); // as instructed in assignment
        XSSFFont font = book.createFont(); // create new font
        font.setBold(true); // bold
        font.setFontHeightInPoints((short) 10); // font size
        style.setFont(font); // apply 'font' to 'style'

        // style 2
        XSSFCellStyle style1 = book.createCellStyle(); // initialize 'style1'
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setFillForegroundColor(new XSSFColor(Color.GREEN));
        style1.setFillPattern(FillPatternType.LESS_DOTS);
        style1.setFont(font);

        cell.setCellValue("Name"); // set value to header 1
        cell.setCellStyle(style);
        cell1.setCellValue("Age"); // set value to header 2
        cell1.setCellStyle(style);
        cell2.setCellValue("Gender"); // set value to header 3
        cell2.setCellStyle(style);
        cell3.setCellValue("Over 21"); // set value to header 4
        cell3.setCellStyle(style);

        int last = person.length + 11; // to length + header = 10 spaces

        for (int i = 1; i <= person.length; i++) { // looping over cells to read value
            Row rowx = sheet.createRow(i); // creates new row with each loop

            for (int j = 0; j < 4; j++) { // for traversing over columns
                Cell cellx = rowx.createCell(j); // create cellx for use in subsequent lines
                if (j == 0) // if name
                {
                    cellx.setCellValue(person[i - 1].getName());
                }
                if (j == 1) // if age
                {
                    cellx.setCellValue(person[i - 1].getAge());
                }
                if (j == 2) // if Gender
                {
                    cellx.setCellValue(String.valueOf(person[i - 1].getGender()));
                } // without
                // string.value, it shows ASCII value
                if (j == 3) { // for age
                    if (person[i - 1].getAge() > 21) {
                        cellx.setCellValue(true);
                    } else {
                        cellx.setCellValue(false);
                    }

                }
            }

        }
        row = sheet.createRow(last); // creates row for summary
        Row row2 = sheet.createRow(last + 1); // next row
        for (int p = 0; p < 4; p++) { // for loop to put formula and summary headings

            cell = row.createCell(p);
            if (p == 0) { // first cell
                cell.setCellValue("Summary");
                cell.setCellStyle(style1);
            }
            if (p == 1) { // second cell
                cell.setCellValue("Average");
                cell.setCellStyle(style1);
                cell = row2.createCell(p);
                cell.setCellFormula("SUM(B2:B" + (last - 1) + ")/" + person.length);
                // formula to calculate average, cell is of type - formula

            }
            if (p == 2) {
                cell.setCellValue("F/M Ratio");
                cell.setCellStyle(style1); // apply style1
                cell = row2.createCell(p); // cell for formula
                cell.setCellFormula("COUNTIF(C2:C" + (last - 1) + ",\"F\")" + // formula
                        "/" + "COUNTIF(C2:C" + (last - 1) + ",\"M\")"); // to calculate ratio
            }
            if (p == 3) {
                cell.setCellValue("Persons over 21");
                cell.setCellStyle(style1); // apply style1
                cell = row2.createCell(p); // create cell for formula
                cell.setCellFormula("COUNTIF(D2:D" + (last - 1) + ",\"TRUE\")"); // formula
            }
        }

        book.write(fileOutputStream); // write
        fileOutputStream.close(); // close output stream
        book.close(); // close book
        System.out.println(filePerson + " written successfully"); // status
    }

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
                " Persons read successfully from file " + filePerson); // output
        objectInputStream.close(); // close object input stream
        dataInputStream.close(); // close data input stream
        return personA; // return array reference

    }

}