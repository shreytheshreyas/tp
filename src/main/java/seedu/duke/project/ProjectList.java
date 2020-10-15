package seedu.duke.project;

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

    public String createProject(String description) {
        try {
            Project newProject = new Project(description);
            projects.add(newProject);
            return ("Project \"" + description + "\" created!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            return ("There is an ERROR in PROJECTLIST!!");
        }
    }

    public String selectProject(int projectIndex) {
        System.out.println("Switched to Project \"" + this.getProjectList().get(projectIndex) + "\"");
        if (this.getProjectList().get(projectIndex).getDescription().equals("")) {
            return "<project description empty> | <project deadline empty> | "
                    + "<team members involved empty>";
        } else {
            return this.getProjectList().get(projectIndex).getDescription()
                    + " | <project deadline empty> | <team members involved empty>";
        }
    }

    public void deleteProject(int projectIndex) {
        projects.remove(projectIndex);
    }

    public Project getProject(int projectIndex) {
        return this.getProjectList().get(projectIndex);
    }

    public int getProjectIndex() {
        return projectIndex;
    }

    public void setProjectIndex(int index) {
        projectIndex = index;
    }
}
