package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

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
}
