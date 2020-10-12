package seedu.duke.commands.projectCommands;

import seedu.duke.commands.Command;
import seedu.duke.projectStuff.ProjectList;

public class ProjectCommand extends Command {

    private String description;

    public ProjectCommand(String description) {
        this.description = description;
    }

    public void executeCommand(ProjectList projects) {
        projects.createProject(description);
    }

    public Boolean isExit() {
        return false;
    }
}
