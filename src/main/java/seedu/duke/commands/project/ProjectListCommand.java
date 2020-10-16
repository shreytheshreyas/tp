package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;

import java.util.ArrayList;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public String executeCommand(ArrayList<Project> projects) {
        if (projects.size() == 0) {
            return "Project list is empty!!";
        } else {
            String output = "";
            output += "List of Projects:";
            for (int i = 0; i < projects.size(); i++) {
                output += "\n     " + (i + 1) + "." + projects.get(i);
            }
            return output;
        }
    }

    public Boolean isExit() {
        return false;
    }
}

