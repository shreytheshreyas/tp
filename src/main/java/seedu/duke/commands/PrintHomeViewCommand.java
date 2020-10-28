package seedu.duke.commands;

import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class PrintHomeViewCommand extends Command {

    @Override
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        return Ui.printHomeView(projects, teamMembers);
    }

    public Boolean isExit() {
        return false;
    }

}
