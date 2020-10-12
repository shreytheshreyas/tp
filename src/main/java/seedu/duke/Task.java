package seedu.duke;

public class Task {
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDeadline() {
        return deadline;
    }

    protected String description;
    protected boolean isDone;
    protected String deadline;

    public Task(String description, String deadline) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            return ((task.description.equals(this.description)) && (task.isDone == this.isDone)
                    && (task.deadline.equals(this.deadline)));
        } else {
            return false;
        }
    }
}
