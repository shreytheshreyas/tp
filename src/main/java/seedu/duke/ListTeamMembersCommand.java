package seedu.duke;

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
