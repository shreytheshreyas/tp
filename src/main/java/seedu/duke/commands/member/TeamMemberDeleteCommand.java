package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TeamMemberDeleteCommand extends Command {
    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberDeleteCommand(HashMap<String, String> params) throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
        } catch (NumberFormatException e) {
            throw new DukeExceptions("invalidTeamMemberID");
        }
    }

    @Override
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (teamMembers.size() == 0) {
            throw new DukeExceptions("emptyTeamMembersList");
        }
        try {
            TeamMember memberToBeRemoved = teamMembers.get(memberIndex);
            teamMembers.remove(memberIndex);
            return Ui.printMemberRemovedMessage(memberToBeRemoved.getName());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTeamMemberID");
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
