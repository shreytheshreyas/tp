package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.Parser;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectSelectCommand extends Command {

    private int projectIndex;
    HashMap<String, String> params;

    public ProjectSelectCommand(HashMap<String, String> params) throws DukeExceptions {
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
     * Selects a specified Project object and move into its project view.
     * Set projectIndex in Parser class with the new project index.
     * Prints project view.
     *
     * @param projects ArrayList of Projects.
     * @param teamMembers ArrayList of TeamMembers in the program.
     * @return Prints project view.
     * @throws DukeExceptions Empty project list if the ArrayList of Project is empty
     * or Invalid Project ID if when parameter values provided is outside
     * the range of the Project list.
     */
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            Project selectedProject = projects.get(projectIndex);
            Parser.setProjectIndex(projectIndex);
            String projectView = Ui.projectViewMessage(selectedProject);
            return projectView;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidProjectID");
        }
    }

    public Boolean isExit() {
        return false;
    }

}
