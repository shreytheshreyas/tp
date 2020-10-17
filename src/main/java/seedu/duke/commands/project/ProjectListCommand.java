package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import java.util.ArrayList;
import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public String executeCommand(ArrayList<Project> projects) {
        if (projects.size() == 0) {
           return Ui.printEmptyProjectListMessage(); //----------REPLACE WITH EXCEPTION
        } else {
            return Ui.printProjectListMessage(projects);
        }
    }

    public Boolean isExit() {
        return false;
    }
}

