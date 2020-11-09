package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import java.util.ArrayList;
import java.util.Collections;

import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        } else {
            try {
                /*
                int projectCounter = 0;
                int i = 0;
                while (projectCounter < projects.size()) {
                    if (projects.get(i).getProjectDeadline() == null) {
                        Project projectWithNullDeadline = projects.get(i);
                        projects.remove(i);
                        projects.add(projectWithNullDeadline);
                    } else {
                        i++;
                    }
                    projectCounter++;
                }
                Collections.sort(projects);
                */
                return Ui.printProjectListMessage(projects);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeExceptions("invalidProjectID");
            }
        }
    }

    public Boolean isExit() {
        return false;
    }
}

