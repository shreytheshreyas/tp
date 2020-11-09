package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectDeleteCommand extends Command {

    private int projectIndex;
    HashMap<String, String> params;

    public ProjectDeleteCommand(HashMap<String, String> params)
            throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    /**
     * Parse user parameter inputs for execution.
     *
     * @throws DukeExceptions Invalid index when parameter values entered is not an integer.
     */
    public void parse() throws DukeExceptions {
        try {
            projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
        } catch (NumberFormatException e) {
            throw new DukeExceptions("indexNonInteger");
        }
    }

    /**
     * Deletes a Project from the ArrayList of Projects.
     * Removes the Project object from the ArrayList of Projects of each assigned TeamMember.
     * Print project deleted message.
     *
     * @param projects ArrayList of Projects.
     * @param teamMembers ArrayList of TeamMembers in the program.
     * @return Prints project deleted message.
     * @throws DukeExceptions
     */
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            Project projectToBeDeleted = projects.get(projectIndex);
            projects.remove(projectIndex);
            ArrayList<TeamMember> membersInProjectToBeDeleted = projectToBeDeleted.getTeamMembers();
            for (TeamMember member : membersInProjectToBeDeleted) {
                member.getAssignedProjects().remove(projectToBeDeleted);
            }
            return Ui.printProjectDeletedMessage(projectToBeDeleted);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidProjectID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
