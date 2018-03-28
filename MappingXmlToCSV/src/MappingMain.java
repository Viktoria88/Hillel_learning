import java.io.IOException;
import java.util.ArrayList;

public class MappingMain {

    public static void main(String[] args) {

        final String csvFileRead = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/elemenaty_19/sidenko_vika/MappingXmlToCSV/test.csv";
        final String xmlWriteRead = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/elemenaty_19/sidenko_vika/MappingXmlToCSV/writeXmlToCSV.xml";
        final String csvWrite = "/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/elemenaty_19/sidenko_vika/MappingXmlToCSV/writeCsvToXml.csv";

        ArrayList<Employee> emp = new ArrayList<>();


        CSVDataStore csvDataStore = CSVDataStore.getInstance();
//        csvDataStore.readFile(csvFileRead, emp);

        XMLDataStore xmlDataStore = XMLDataStore.getInstance();
//        xmlDataStore.writeFile(xmlWriteRead, emp);
        xmlDataStore.readFile(xmlWriteRead, emp);

        try {
            csvDataStore.writeFile(csvWrite, emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
