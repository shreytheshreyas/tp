package seedu.duke;

public class ProjectDescriptionCommand extends Command {

    private String projectDescription;
    private int projectIndex;


    public ProjectDescriptionCommand(String projectDescription, int projectIndex) {
        this.projectDescription = projectDescription;
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);
        project.addDescription(projectDescription);
        System.out.println(project + " description added - " + project.getDescription());
    }

    public Boolean isExit() {
        return false;
    }
}
