package seedu.duke.commands.memberCommands;

import seedu.duke.commands.Command;
import seedu.duke.projectStuff.ProjectList;
import seedu.duke.memberStuff.TeamMemberList;

public class ListTeamMembersCommand extends Command {

    private String name;

    public ListTeamMembersCommand() {
    }

    public void executeCommand(ProjectList projects) {
        System.out.println(TeamMemberList.listTeamMembers());
    }

    public Boolean isExit() {
        return false;
    }
}
