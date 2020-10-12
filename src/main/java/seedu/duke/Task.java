package seedu.duke;

public class Task {
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            return ((task.description.equals(this.description)) && (task.isDone == this.isDone));
        } else {
            return false;
        }
    }
}
