package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

public class DeleteProjectCommand extends Command {

    private Integer itemIndex;

    public DeleteProjectCommand(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String executeCommand(ProjectList projects) {
        projects.deleteProject(itemIndex);
        return "Project deleted";
    }

    public Boolean isExit() {
        return false;
    }
}
