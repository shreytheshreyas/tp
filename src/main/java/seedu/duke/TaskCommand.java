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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskCommand) {
            TaskCommand taskCommand = (TaskCommand) obj;
            return (this.description.equals(taskCommand.description) && this.deadline.equals(taskCommand.deadline)
                    && (this.projectIndex == taskCommand.projectIndex));
        } else {
            return false;
        }
    }
}
