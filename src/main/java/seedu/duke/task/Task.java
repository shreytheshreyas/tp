package seedu.duke.task;

import seedu.duke.member.TeamMember;

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
    protected TeamMember member;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void addDeadline(LocalDate date) {
        this.date = date;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getTaskDescription() {
        return description;
    }

    public String getDateString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public TeamMember getMember() {
        return member;
    }

    public void setMember(TeamMember newMember) {
        member = newMember;
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
