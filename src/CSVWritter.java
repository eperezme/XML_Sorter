
// Java program to illustrate
// for Writing Data in CSV file
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVWritter {
    private static final String CSV_FILE_PATH
            = "./parsed_output.csv";
    public static void writeToCSV(List<String[]> input)
    {
        addDataToCSV(CSV_FILE_PATH, input);
    }
    public static void addDataToCSV(String Output,List<String[]> input)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(Output);
        Scanner sc = new Scanner(System.in);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains Data
            List<String[]> data = input;

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

