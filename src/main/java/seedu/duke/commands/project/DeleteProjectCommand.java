package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

public class DeleteProjectCommand extends Command {

    private Integer itemIndex;

    public DeleteProjectCommand(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String executeCommand(ProjectList projects) {
        Project projectToBeDeleted = projects.getProject(itemIndex);
        projects.deleteProject(itemIndex);
        return Ui.printProjectDeletedMessage(projectToBeDeleted);
    }

    public Boolean isExit() {
        return false;
    }
}
