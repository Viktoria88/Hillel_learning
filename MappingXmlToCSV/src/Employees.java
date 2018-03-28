import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employees implements Employee {

    private String name;
    private String role;
    private String salary;

    public Employees(String name, String role, String salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public Employees() {
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getSalary() {
        return salary;
    }

    @Override
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String toCsvRow() {
        return Stream.of(name, salary, role)
                .map(value -> value.replaceAll("\"", "\"\""))
                .map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
                .collect(Collectors.joining(";"));
    }

}
