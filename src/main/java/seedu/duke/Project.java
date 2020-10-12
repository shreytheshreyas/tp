package seedu.duke;

import java.util.ArrayList;

public class Project {
    protected String projectName;
    protected boolean isDone;
    private TaskList tasks;
    private String projectDescription;
    //private static final String TICK_MARK = "\u2713";
    //private static final String CROSS_MARK = "\u2718";


    public Project(String projectName) {
        this.projectName = projectName;
        this.isDone = false;
        this.tasks = new TaskList();
        this.projectDescription = "";
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

    public void addDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDescription() {
        return projectDescription;
    }

    /**
     * Returns details of the specified task.
     *
     * @return Details of task
     */
    @Override
    public String toString() {
        
        return projectName;
        
    }
}
