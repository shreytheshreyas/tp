package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

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
