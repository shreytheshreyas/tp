//@@author thatseant

package seedu.duke.commands.member;

import java.util.HashMap;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import static seedu.duke.Parser.getHashValue;
import static seedu.duke.Util.INDEX_NON_INTEGER;
import static seedu.duke.Util.INVALID_PROJECT_ID;
import static seedu.duke.Util.INVALID_TEAM_MEMBER_ID;
import static seedu.duke.Util.MEMBER_INDEX_KEY;
import static seedu.duke.Util.PROJECT_INDEX_KEY;
import static seedu.duke.Util.USER_JAVA_INDEX_DIFF;

import java.util.ArrayList;

public class AssignMemberToProjectCommand extends Command {
    private int memberIndex;
    private int projectIndex;
    private HashMap<String, String> paramsList;

    public AssignMemberToProjectCommand(HashMap<String,String> paramsList, int projectIndex)
            throws DukeExceptions {
        this.paramsList = paramsList;
        assert projectIndex == -1 : "projectIndex must be -1";
        parse();
    }

    public void parse() throws DukeExceptions {
        try {
            projectIndex = Integer.parseInt(getHashValue(paramsList, PROJECT_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
            memberIndex = Integer.parseInt(getHashValue(paramsList, MEMBER_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
        } catch (NumberFormatException e) {
            throw new DukeExceptions(INDEX_NON_INTEGER);
        }
    }

    @Override
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (memberIndex >= teamMembers.size() || memberIndex < 0) {
            throw new DukeExceptions(INVALID_TEAM_MEMBER_ID);
        }
        if (projectIndex >= projects.size() || projectIndex < 0) {
            throw new DukeExceptions(INVALID_PROJECT_ID);
        }

        TeamMember teamMember = teamMembers.get(memberIndex);
        Project projectToAdd = projects.get(projectIndex);
        teamMember.assignProject(projectToAdd);
        projectToAdd.addTeamMemberToProject(teamMember);
        return Ui.printMemberAssignedToProjectMessage(teamMember.getName(), projectToAdd.getProjectName());
    }

    public Boolean isExit() {
        return false;
    }
}
