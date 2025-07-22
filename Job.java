public class Job implements Comparable<Job> {

    private String name;
    private int priority;

    Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    void execute() {
        System.out.println("Running the job with name " + this.name + " and priority " + this.priority);
    }

    String getName() {
        return this.name;
    }

    int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }
}
