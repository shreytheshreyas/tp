package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class AddTeamMemberCommand extends Command {

    private String name;

    public AddTeamMemberCommand(String name) {
        this.name = name;
    }

    public String executeCommand(ArrayList<Project> projects) {
        TeamMember newMember = new TeamMember(name);
        Project.getMembers().add(newMember);
        return Ui.printMemberAddedMessage(name);
    }

    public Boolean isExit() {
        return false;
    }
}
