package seedu.duke.member;

import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class TeamMember {
    private String name;
    private int assignedProjectId;
    private ArrayList<Project> assignedProjects;
    private ArrayList<Task> tasks;

    public TeamMember(String name) {
        this.name = name;
        assignedProjectId = -1;
        tasks = new ArrayList<>();
        this.assignedProjects = new ArrayList<>();
    }

    public void assignProject(Project project) {
        assignedProjects.add(project);
    }
    
    public void setTask(Task selectedTask) {
        tasks.add(selectedTask);
    }
    
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
