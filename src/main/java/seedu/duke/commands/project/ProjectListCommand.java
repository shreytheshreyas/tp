package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public String executeCommand(ProjectList projects) {
        if (projects.getNumberOfProjects() == 0) {
            return Ui.printEmptyProjectListMessage(); //----------REPLACE WITH EXCEPTION
        } else {
            return Ui.printProjectListMessage(projects);
        }
    }

    public Boolean isExit() {
        return false;
    }
}

