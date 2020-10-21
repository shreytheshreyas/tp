package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class TeamMemberDeleteCommand extends Command {
    private int memberIndex;

    public TeamMemberDeleteCommand(int memberIndex) {
        this.memberIndex = memberIndex;
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
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
