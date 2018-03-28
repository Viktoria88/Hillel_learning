import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CSVDataStore implements DataStore {

    String pathName;
    String spliter = ";(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    private static CSVDataStore instance;

    public static CSVDataStore getInstance() {
        if (instance == null) {
            instance = new CSVDataStore();
        }
        return instance;
    }


    @Override
    public List<Employee> readFile(String pathName, ArrayList<Employee> empList) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(pathName));
            while ((line = br.readLine()) != null) {

                Employee emp = new Employees();

                String[] s = line.split(spliter);

                for (int i = 0; i < s.length; i++) {
                    if (i == 0) {
                        emp.setName(s[0]);
                    } else if (i == 1) {
                        emp.setSalary(s[1]);
                    } else if (i == 2) {
                        emp.setRole(s[2]);
                    }
                }
                empList.add(emp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return empList;
    }

    @Override
    public void writeFile(String pathName, ArrayList<Employee> empList) throws IOException {

        FileWriter writer = new FileWriter(pathName, true);

        String datACsv = empList.stream()
                .map(Employee::toCsvRow)
                .collect(Collectors.joining(System.getProperty("line.separator")));

        writer.write(datACsv);
        writer.write("\n");
        writer.close();
    }
}
