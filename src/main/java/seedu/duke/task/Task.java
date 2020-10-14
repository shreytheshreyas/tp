package seedu.duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    protected String description;
    protected boolean isDone;
    protected LocalDate date;

    public Task(String description, LocalDate date) {
        this.description = description;
        this.isDone = false;
        this.date = date;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDateString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Returns details of the specified task.
     *
     * @return Details of task
     */
    @Override
    public String toString() {
        return description + " | " + getDateString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            return ((task.description.equals(this.description))
                    && (task.isDone == this.isDone) && (task.date.equals(this.date)));
        } else {
            return false;
        }
    }
}
