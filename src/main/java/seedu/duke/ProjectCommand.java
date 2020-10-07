package seedu.duke;

public class ProjectCommand extends Command {

    private String description;
    private String currentInput;

    public ProjectCommand(String currentInput, String description) {
        this.description = description;
        this.currentInput = currentInput;
    }

    public void executeCommand(ProjectList projects) {
        projects.createProject(currentInput, projects);
    }

    public Boolean isExit() {
        return false;
    }
}
