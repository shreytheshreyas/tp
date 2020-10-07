package seedu.duke;

public class ProjectCommand extends Command {

    private String description;
    private String deadline;

    public ProjectCommand(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public void executeCommand(ProjectList projects) {
        projects.createProject(description, deadline);
    }

    public Boolean isExit() {
        return false;
    }
}
