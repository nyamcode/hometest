import java.util.HashMap;
import java.util.Map;

public class Jobs {
    private Map<String, Job> jobs;

    public Jobs() {

        this.jobs = new HashMap<String, Job>();
    }

    public void put(final String jobTitle, final String hourlyRate) {

        if (!jobs.containsKey(jobTitle)) {

            jobs.put(jobTitle, new Job(hourlyRate));

        } else {

            Job job = jobs.get(jobTitle);
            job.set(hourlyRate);

        }

    }

    public Map<String, Job> getMap() {
        return jobs;
    }

}