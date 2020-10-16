package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

import java.util.ArrayList;

public class DeleteProjectCommand extends Command {

    private Integer itemIndex;

    public DeleteProjectCommand(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        projects.remove(itemIndex);
        return "Project deleted";
    }

    public Boolean isExit() {
        return false;
    }
}
