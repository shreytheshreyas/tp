package seedu.duke.member;

import seedu.duke.DukeExceptions;
import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class TeamMember {
    private String name;
    private ArrayList<Project> assignedProjects;
    private ArrayList<Task> tasks;

    public TeamMember(String name) {
        this.name = name;
        tasks = new ArrayList<>();
        this.assignedProjects = new ArrayList<>();
    }

    public void assignProject(Project project) throws DukeExceptions {
        for (Project assignedProject : assignedProjects) {
            if (assignedProject == project) {
                throw new DukeExceptions("projectAlreadyAssigned");
            }
        }
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
