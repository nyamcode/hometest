import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;

public class WageParser {

    final Jobs jobs;
    final Employees employees;

    public WageParser() throws IOException {

        final FileReader fileReader = new FileReader("src/main/resources/City_of_Seattle_Wage_Data.csv");

        final CSVReader reader = new CSVReader(fileReader, ',', '"', 1);

        jobs = new Jobs();

        employees = new Employees();

        String[] data;

        while ((data = reader.readNext()) != null) {

            String department = data[0];

            String firstName = data[2];

            String jobTitle = cleanJobTitle(data[3]);

            String hourlyRate = data[4];

            // Creating the lists of job titles and collecting data for calculating average paying job title
            jobs.put(jobTitle, hourlyRate);

            // Creating the lists of unique first names with the highest hourly rates
            employees.put(firstName, department, jobTitle, hourlyRate);
        }

        fileReader.close();

    }

    public void output() {

        String firstName;
        String department;
        String jobTitle;
        String averageHourlyRate;

        HashMap<String, HashMap<String, String>> outputMap = new HashMap<String, HashMap<String, String>>();

        // Formatting Output Data according with the example
        for (Map.Entry<String, Employee> entry : employees.getSet()) {

            firstName = entry.getKey();

            department = entry.getValue().getDepartment();

            jobTitle = entry.getValue().getJobTitle();

            averageHourlyRate = jobs.getMap().get(jobTitle).getAverageWage();

            LinkedHashMap<String, String> employeeData = new LinkedHashMap<String, String>();

            employeeData.put("Department", department);
            employeeData.put("Job Title", jobTitle);
            employeeData.put("Average Hourly Rate", averageHourlyRate);

            outputMap.put(firstName, employeeData);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String employeeJSON = gson.toJson(outputMap);

        // Printing json formatted output. SORTING IS NOT IN SCOPE OF WORK
        System.out.println(employeeJSON);
    }

    private String cleanJobTitle(String jobTitle) {

        // Removing "Sr" from job title
        jobTitle = jobTitle.replaceAll("\\W+Sr", "");

        // Removing roman numerals from job title. ASSUMING THAT "CC" IS NOT ROMAN NUMERAL BUT "CII" IS.
        jobTitle = jobTitle.replaceAll("(\\W)C?(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})(\\W|$)", "$1$4");

        // Fixing extraspaces after removing "Sr" and roman numerals
        jobTitle = jobTitle.replaceAll("  ", " ");
        jobTitle = jobTitle.replaceAll(" -", "-");

        return jobTitle;

    }
}