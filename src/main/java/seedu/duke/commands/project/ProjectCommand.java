package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectCommand extends Command {

    private String description;
    HashMap<String, String> params;

    public ProjectCommand(HashMap<String, String> params) throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        this.description = getHashValue(params, "n");
    }

    /**
     * Adds a new Project object into the ArrayList of Projects.
     * Prints project created message.
     *
     * @param projects ArrayList of Projects.
     * @param teamMembers ArrayList of TeamMembers in the program.
     * @return Prints project created message.
     */
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        assert description != null : "description should not be null";
        Project newProject = new Project(description);
        projects.add(newProject);
        return Ui.printProjectCreatedMessage(newProject.getProjectName());
    }

    public Boolean isExit() {
        return false;
    }
}
