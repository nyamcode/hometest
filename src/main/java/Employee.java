public class Employee {

    private String department;
    private String jobTitle;
    private Double hourlyRate;

    public Employee(
            final String department,
            final String jobTitle,
            final String hourlyRate) {

        this.department = department;
        this.jobTitle = jobTitle;
        this.hourlyRate = Double.parseDouble(hourlyRate);
    }

    public Employee(
            final String department,
            final String jobTitle,
            final Double hourlyRate) {

        this.department = department;
        this.jobTitle = jobTitle;
        this.hourlyRate = hourlyRate;
    }

    public void set(String department, String jobTitle, String hourlyRate) {

        this.department = department;
        this.jobTitle = jobTitle;
        this.hourlyRate = Double.parseDouble(hourlyRate);
    }

    public void set(String department, String jobTitle, Double hourlyRate) {

        this.department = department;
        this.jobTitle = jobTitle;
        this.hourlyRate = hourlyRate;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

}