package seedu.duke.project;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ProjectList {

    private int projectIndex;
    private ArrayList<Project> projects;

    /**
     * Creates an empty project list.
     */
    public ProjectList() { 
        projects = new ArrayList<>();
        projectIndex = -1;
    }

    /**
     * Gets the arraylist that contains existing projects.
     *
     * @return Arraylist that contains existing projects.
     */
    public ArrayList<Project> getProjectList() {
        return projects;
    }

    public int getNumberOfProjects() {
        return projects.size();
    }

    public Project getProject(int projectIndex) {
        return projects.get(projectIndex);
    }

}
