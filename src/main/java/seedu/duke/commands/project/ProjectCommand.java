package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

public class ProjectCommand extends Command {

    private String description;

    public ProjectCommand(String description) {
        this.description = description;
    }

    public String executeCommand(ProjectList projects) {
        return projects.createProject(description);
    }

    public Boolean isExit() {
        return false;
    }
}
