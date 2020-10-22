package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class TeamMemberAddCommand extends Command {

    private String name;

    public TeamMemberAddCommand(String name) {
        this.name = name;
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        TeamMember newMember = new TeamMember(name);
        teamMembers.add(newMember);
        return Ui.printMemberAddedMessage(name);
    }

    public Boolean isExit() {
        return false;
    }
}
