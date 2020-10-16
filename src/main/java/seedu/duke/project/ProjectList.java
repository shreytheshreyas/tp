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

    public int getNumberOfProjects() {
        return projects.size();
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
        System.out.println("Switched to Project \"" + this.getProject(projectIndex) + "\"");
        if (this.getProject(projectIndex).getDescription().equals("")) {
            return "<project description empty> | <project deadline empty> | "
                    + "<team members involved empty>";
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
