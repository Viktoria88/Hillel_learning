import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DataStore {

    List<Employee> readFile(String pathName, ArrayList<Employee> emp);
    void writeFile(String pathName, ArrayList<Employee> empList) throws IOException;
}
