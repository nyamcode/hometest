public class Job {

    private Double wageSum;
    private int count;

    public Job(final String wageSum) {

        this.wageSum = Double.parseDouble(wageSum);
        this.count = 1;
    }

    public Job(final Double wageSum) {

        this.wageSum = wageSum;
        this.count = 1;
    }

    public void set(String wageSum) {

        this.wageSum += Double.parseDouble(wageSum);
        this.count++;
    }

    public void set(Double wageSum) {

        this.wageSum += wageSum;
        this.count++;
    }

    public String getAverageWage() {

        return String.format("%.2f", wageSum / count);
    }
}