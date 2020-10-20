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

    public String createProject(String projectName) {
        try {
            Project newProject = new Project(projectName);
            projects.add(newProject);
            return Ui.printProjectCreatedMessage(projectName);
        } catch (ArrayIndexOutOfBoundsException e) {
            return ("There is an ERROR in PROJECTLIST!!"); //----------REPLACE WITH EXCEPTION
        }
    }

    public String selectProject(int projectIndex) {
        System.out.println("Switched to Project \"" + this.getProject(projectIndex).getProjectName() + "\"");
        if (this.getProject(projectIndex).getDescription().equals("")) {
            return Ui.printEmptyAdditionalProjectInformationMessage();
        } else {
            return this.getProject(projectIndex).getDescription()
                    + " | <project deadline empty> | <team members involved empty>";
        }
    }

    public void deleteProject(int projectIndex) {
        projects.remove(projectIndex);
    }

    public Project getProject(int projectIndex) {
        return projects.get(projectIndex);
    }

}
