import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class XMLParserSAX {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Remember to replace the following lines using a text editor prior");
            System.out.println(" to the execution: ");
            System.out.println();
            System.out.println("Search for:");
            System.out.println("<INSDQualifier_name>isolate</INSDQualifier_name>");
            System.out.println("Change it for:");
            System.out.println("<INSDQualifier_isolate>isolate</INSDQualifier_isolate>");
            System.out.println();
            System.out.println("Search for:");
            System.out.println("<INSDQualifier_name>country</INSDQualifier_name>");
            System.out.println("Change it for:");
            System.out.println("<INSDQualifier_country>country</INSDQualifier_country>");
            System.out.println();
            System.out.println("Search for:");
            System.out.println("<INSDQualifier_name>isolation_source</INSDQualifier_name>");
            System.out.println("Change it for:");
            System.out.println("<INSDQualifier_isolation>isolation_source</INSDQualifier_isolation>");
            System.out.println();
            System.out.println("Enter full XML file path: ");
            String filename = keyboard.nextLine();
            Scanner inputFile = new Scanner(new File(filename));
            saxParser.parse(filename, handler);
            //Get Employees list
            List<GenBankEntry> gbList = handler.getGbList();
            //print employee information

            String[] headers = {"Accesion", "Title", "Locus", "Sp","Isolate","Country", "Source", "Date","Article_1", "Doi_1", "Article_2", "Doi_2", "Article_3", "Doi_3", "Article_4", "Doi_4", "Article_5", "Doi_5","SeqLength", "Sequence"};
            toCSV.add(headers);

            for(GenBankEntry gb : gbList)
            {
                System.out.println(gb.getAccession() + " " + gb.getTitle() + " " + gb.getLocus() + " " + gb.getSpecies() + " " + gb.getIsolate() + " " + gb.getDateCreate() + " " + gb.getCountry() + " " + gb.getIsolation());// + gb.getIsolation() + " " + gb.getCountry() + " " + String.valueOf(gb.getSeqLength()));
                String[] rowcsv = {gb.getAccession().replace(";"," "), gb.getTitle().replace(";"," "), gb.getLocus().replace(";"," "), gb.getSpecies().replace(";"," "), gb.getIsolate(), gb.getCountry(), gb.getIsolation(),gb.getDateCreate().replace(";"," "),gb.getPaper_1(), gb.getDoi_1(), gb.getPaper_2(), gb.getDoi_2(), gb.getPaper_3(), gb.getDoi_3(), gb.getPaper_4(), gb.getDoi_4(), gb.getPaper_5(), gb.getDoi_5(), String.valueOf(gb.getSeqLength()), gb.getSequence()};
                toCSV.add(rowcsv);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        CSVWritter.writeToCSV(toCSV);

    }

    private static final List<String[]> toCSV = new ArrayList<String[]>();

}
