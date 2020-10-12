package seedu.duke.commands.memberCommands;

import seedu.duke.commands.Command;
import seedu.duke.projectStuff.ProjectList;
import seedu.duke.memberStuff.TeamMemberList;

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
