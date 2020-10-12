package seedu.duke.Commands.MemberCommands;

import seedu.duke.Commands.Command;
import seedu.duke.ProjectStuff.ProjectList;
import seedu.duke.MemberStuff.TeamMemberList;

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
