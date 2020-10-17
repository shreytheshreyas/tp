package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

import java.util.ArrayList;

public class DeleteTeamMemberCommand extends Command {
    private int memberIndex;

    public DeleteTeamMemberCommand(int memberIndex) {
        this.memberIndex = memberIndex;
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) {
        boolean isMemberPresent = memberIndex < Project.getMembers().size();
        String memberMessage = (isMemberPresent) ? "Member removed" : "Member not present";
        Project.getMembers().remove(memberIndex);
        return memberMessage;
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
