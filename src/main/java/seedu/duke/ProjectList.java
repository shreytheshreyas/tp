package seedu.duke;

import java.util.ArrayList;

public class ProjectList {

    private ArrayList<Project> projects;

    /**
     * Creates an empty project list.
     */
    public ProjectList() {
        projects = new ArrayList<>();
    }

    /**
     * Gets the arraylist that contains existing tasks.
     *
     * @return Arraylist that contains existing tasks.
     */
    public ArrayList<Project> getProjectList() {
        return projects;
    }

    public void createProject(ProjectList projects, String description, String deadline) {
        try {
            Project newProject = new Project(description, deadline);
            projects.getProjectList().add(newProject);
            System.out.println("Project \"" + description + " by " + deadline + "\" created!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an ERROR in PROJECTLIST!!");
        }
    }

    public void selectProject(int projectIndex) {
        System.out.println(this.getProjectList().get(projectIndex));
    }

}
