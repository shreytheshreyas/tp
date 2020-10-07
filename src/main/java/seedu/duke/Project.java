package seedu.duke;

import java.util.ArrayList;

public class Project {
    protected String description;
    protected boolean isDone;
    protected String deadline;
    private TaskList tasks;

    public Project(String description, String deadline) {
        this.description = description;
        this.isDone = false;
        this.deadline = deadline;
        this.tasks = new TaskList();
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public ArrayList<Task> getTasks() {return tasks.getTaskList();}

    public void createTask(String description, String deadline) {
        tasks.createTask(description, deadline);
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
