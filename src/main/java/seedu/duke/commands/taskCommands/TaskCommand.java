package seedu.duke.commands.taskCommands;

import seedu.duke.commands.Command;
import seedu.duke.projectStuff.Project;
import seedu.duke.projectStuff.ProjectList;

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
