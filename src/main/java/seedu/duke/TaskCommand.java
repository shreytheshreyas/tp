package seedu.duke;

public class TaskCommand extends Command {

    private String description;
    private String deadline;
    private int projectIndex;

    public TaskCommand(String description, String deadline, int projectIndex) {
        this.description = description;
        this.deadline = deadline;
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);
        project.createTask(description, deadline);
    }

    public Boolean isExit() {
        return false;
    }
}
