package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.Parser;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TeamMemberAddCommand extends Command {

    private String name;
    HashMap<String, String> params;

    public TeamMemberAddCommand(HashMap<String, String> params) throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        name = getHashValue(params, "m");
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
