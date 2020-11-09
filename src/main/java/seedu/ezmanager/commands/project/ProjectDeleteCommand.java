package seedu.ezmanager.commands.project;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.ezmanager.Parser.getHashValue;

public class ProjectDeleteCommand extends Command {

    private int projectIndex;
    HashMap<String, String> params;

    public ProjectDeleteCommand(HashMap<String, String> params)
            throws EZExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
        } catch (NumberFormatException e) {
            throw new EZExceptions("invalidProjectID");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws EZExceptions {
        if (projects.size() == 0) {
            throw new EZExceptions("emptyProjectList");
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
            throw new EZExceptions("invalidProjectID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
