package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class DeleteProjectCommand extends Command {

    private Integer itemIndex;

    public DeleteProjectCommand(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        Project projectToBeDeleted = projects.get(itemIndex);
        projects.remove(itemIndex);
        return Ui.printProjectDeletedMessage(projectToBeDeleted);
    }

    public Boolean isExit() {
        return false;
    }
}
