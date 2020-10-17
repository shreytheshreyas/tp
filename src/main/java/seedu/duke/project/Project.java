package seedu.duke.project;

import seedu.duke.member.TeamMember;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Project {
    protected String projectName;
    protected boolean isDone;
    private ArrayList<Task> tasks;
    private String projectDescription;
    private static ArrayList<TeamMember> members = new ArrayList<>();
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
        tasks.add(task);
    }

    public void deleteTask(int taskIndex) {
        tasks.remove(taskIndex);
    }

    public void addDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDescription() {
        return projectDescription;
    }

    public String selectTask(int index) {
        return tasks.selectTask(index);
    }

    public static ArrayList<TeamMember> getMembers() {
        return members;
    }

    public String deleteTask(int index) {
        return tasks.deleteTask(index);
    public int getNumberTasks() {
        return tasks.size();
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
