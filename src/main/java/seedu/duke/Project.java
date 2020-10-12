package seedu.duke;

import java.util.ArrayList;

public class Project {
    protected String description;
    protected boolean isDone;
    private TaskList tasks;
    //private static final String TICK_MARK = "\u2713";
    //private static final String CROSS_MARK = "\u2718";


    public Project(String description) {
        this.description = description;
        this.isDone = false;
        this.tasks = new TaskList();
    }

    public String getStatusIcon() {
        
        return (isDone ? "done" : "not done"); //return tick or X symbols
        
    }

    public TaskList getTaskList() {
        return tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks.getTaskList();
    }

    public void createTask(String description) {
        tasks.createTask(description);
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
