import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Employees {
    private Map<String, Employee> employees;

    public Employees() {
        this.employees = new HashMap<String, Employee>();
    }

    public void put(final String firstName, final String department, final String jobTitle, final String hourlyRate) {

        if (!employees.containsKey(firstName)) {

            employees.put(firstName, new Employee(department, jobTitle, hourlyRate));

        } else {

            Employee employee = employees.get(firstName);

            Double newHourlyRate = Double.parseDouble(hourlyRate);

            if (newHourlyRate > employee.getHourlyRate()) {

                employee.set(department, jobTitle, newHourlyRate);

            }
        }
    }

    public Set<Map.Entry<String, Employee>> getSet() {
        return employees.entrySet();
    }

}