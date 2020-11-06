package seedu.duke.member;

import seedu.duke.DukeExceptions;
import seedu.duke.project.Project;

import java.util.ArrayList;

public class TeamMember {
    private String name;
    private int assignedProjectId;
    private ArrayList<Project> assignedProjects;

    public TeamMember(String name) {
        this.name = name;
        assignedProjectId = -1;
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
