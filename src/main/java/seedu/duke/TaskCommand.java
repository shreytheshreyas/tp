package seedu.duke;

public class TaskCommand extends Command {

    private String description;
    private int projectIndex;

    public TaskCommand(String description, int projectIndex) {
        this.description = description;
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);
        project.createTask(description);
    }

    public Boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskCommand) {
            TaskCommand taskCommand = (TaskCommand) obj;
            return (this.description.equals(taskCommand.description)
                    && (this.projectIndex == taskCommand.projectIndex));
        } else {
            return false;
        }
    }
}
