package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

public class DeleteTeamMemberCommand extends Command {
    private int memberIndex;

    public DeleteTeamMemberCommand(int memberIndex) {
        this.memberIndex = memberIndex;
    }

    @Override
    public String executeCommand(ProjectList projects) {
        String isNamePresent = (TeamMemberList.isMemberPresent(memberIndex)) ? "Member removed" : "Member not present";
        TeamMemberList.removeTeamMember(memberIndex);
        return isNamePresent;
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
