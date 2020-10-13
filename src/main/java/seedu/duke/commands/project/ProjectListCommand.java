package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public String executeCommand(ProjectList projects) {
        if (projects.getProjectList().size() == 0) {
            return "Project list is empty!!";
        } else {
            String output = "";
            output += "List of Projects:";
            for (int i = 0; i < projects.getProjectList().size(); i++) {
                output += "\n     " + (i + 1) + "." + projects.getProjectList().get(i);
            }
            return output;
        }
    }

    public Boolean isExit() {
        return false;
    }
}

