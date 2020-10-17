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

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void addDeadline(LocalDate date) {
        this.date = date;
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
        String taskStatus = description;
        if (date != null) {
            taskStatus += " | " + getDateString();
        }
        return taskStatus;
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
