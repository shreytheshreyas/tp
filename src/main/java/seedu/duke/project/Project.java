package seedu.duke.project;

import seedu.duke.task.Task;

import java.util.ArrayList;

public class Project {
    protected String projectName;
    protected boolean isDone;
    private ArrayList<Task> tasks;
    private int numberTasks;
    private String projectDescription;
    //private static final String TICK_MARK = "\u2713";
    //private static final String CROSS_MARK = "\u2718";


    public Project(String projectName) {
        this.projectName = projectName;
        this.isDone = false;
        this.tasks = new ArrayList<>();
        this.projectDescription = "";
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public void createTask(Task task) {
        numberTasks += 1;
        tasks.add(task);
    }

    public void deleteTask(int taskIndex) {
        numberTasks -= 1;
        tasks.remove(taskIndex);
    }

    public void addDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDescription() {
        return projectDescription;
    }

    public int getNumberTasks() {
        return numberTasks;
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
