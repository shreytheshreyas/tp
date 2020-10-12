package seedu.duke.Commands.MemberCommands;

import seedu.duke.Commands.Command;
import seedu.duke.ProjectStuff.ProjectList;
import seedu.duke.MemberStuff.TeamMemberList;

public class AddTeamMemberCommand extends Command {

    private String name;

    public AddTeamMemberCommand(String name) {
        this.name = name;
    }

    public void executeCommand(ProjectList projects) {
        TeamMemberList.addTeamMember(name);
    }

    public Boolean isExit() {
        return false;
    }
}
