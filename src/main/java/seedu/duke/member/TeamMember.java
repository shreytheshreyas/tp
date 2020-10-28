package seedu.duke.member;

import seedu.duke.task.Task;

import java.util.ArrayList;

public class TeamMember {
    private String name;
    private int assignedProjectId;
    private ArrayList<Task> tasks;

    public TeamMember(String name) {
        this.name = name;
        assignedProjectId = -1;
        tasks = new ArrayList<>();
    }

    public void setAssignedProjectId(int assignedProjectId) {
        this.assignedProjectId = assignedProjectId;
    }

    public void setTask(Task selectedTask) {
        tasks.add(selectedTask);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getAssignedProjectId() {
        return assignedProjectId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
