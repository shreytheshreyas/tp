package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

public class DeleteTeamMemberCommand extends Command {
    private String name;

    public DeleteTeamMemberCommand(String name) {
        this.name = name;
    }

    @Override
    public String executeCommand(ProjectList projects) {
        String isNamePresent = (TeamMemberList.isNamePresent(name)) ? "Member removed" : "Member not present";
        TeamMemberList.removeTeamMember(name);
        return isNamePresent;
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
