package seedu.duke.member;

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

    public void assignProject(Project project) {
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

    public String saveFormat() {
        String memberString = "";
        memberString += this.toString();
        memberString += "\npS\n";
        if (assignedProjects.size() > 0) {
            for (Project project : assignedProjects) {
                memberString += project.getProjectName();
            }
        }
        memberString += "\npE";
        return memberString;
    }
}
