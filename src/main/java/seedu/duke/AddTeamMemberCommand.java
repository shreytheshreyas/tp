package seedu.duke;

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
