package seedu.duke.Commands.ProjectCommands;

import seedu.duke.Commands.Command;
import seedu.duke.ProjectStuff.ProjectList;

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
