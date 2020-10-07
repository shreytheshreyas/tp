package seedu.duke;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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
        return description;
    }
}
