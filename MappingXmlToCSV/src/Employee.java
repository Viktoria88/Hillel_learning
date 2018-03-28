public interface Employee {

    String getName();
    void setName(String name);
    String getRole();
    void setRole(String role);
    String getSalary();
    void setSalary(String salary);
    String toCsvRow();
}
