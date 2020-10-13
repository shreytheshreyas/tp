package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

public class DeleteTeamMemberCommand extends Command {
    private String name;

    public DeleteTeamMemberCommand(String name) {
        this.name = name;
    }

    @Override
    public void executeCommand(ProjectList projects) {
        TeamMemberList.removeTeamMember(name);
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
