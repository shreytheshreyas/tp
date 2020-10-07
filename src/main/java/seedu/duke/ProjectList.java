package seedu.duke;

import java.util.ArrayList;

public class ProjectList {

    private ArrayList<Project> projects;

    /**
     * Creates an empty task list.
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

    public void createProject(String currentInput, ProjectList projects) {
        try {
            String deadline = currentInput.split(" /by ")[1];
            String projectDescription = currentInput.split(" /by ")[0].split(" ", 2)[1];
            Project newProject = new Project(projectDescription, deadline);
            projects.getProjectList().add(newProject);
            System.out.println("Project \"" + projectDescription + " by " + deadline + "\" created!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an ERROR in PROJECTLIST!!");
        }
    }

    public void selectProject(int projectIndex) {
        System.out.println(this.getProjectList().get(projectIndex));
    }

}
