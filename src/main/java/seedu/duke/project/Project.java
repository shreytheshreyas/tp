package seedu.duke.project;

import seedu.duke.member.TeamMember;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Project {
    protected String projectName;
    protected boolean isDone;
    private ArrayList<Task> tasks;
    private String projectDescription;
    private String projectDeadline;
    private static ArrayList<TeamMember> members;
    //private static final String TICK_MARK = "\u2713";
    //private static final String CROSS_MARK = "\u2718";


    public String getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(String projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public Project(String projectName) {
        this.projectName = projectName;
        this.isDone = false;
        this.tasks = new ArrayList<>();
        this.projectDescription = "<project description empty>";
        this.projectDeadline = "<project deadline empty>";
        members = new ArrayList<>();
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public void addTask(Task task) {
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


    public static ArrayList<TeamMember> getMembers() {
        return members;
    }

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

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public String selectTask(int taskId) {
        return tasks.get(taskId).toString();
    }

    public boolean getStatus() {
        if (isDone) {
            return isDone;
        }

        for(Task task : tasks) {
            if (!(task.getStatus())) {
                return false;
            }
        }

        return true;
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
