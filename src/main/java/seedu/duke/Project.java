package seedu.duke;

public class Project {
    protected String description;
    protected boolean isDone;
    protected String deadline;

    public Project(String description, String deadline) {
        this.description = description;
        this.isDone = false;
        this.deadline = deadline;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Returns details of the specified task.
     *
     * @return Details of task
     */
    @Override
    public String toString() {
        return description + " | " + deadline;
    }
}
