package seedu.ezmanager.commands;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;

public class PrintHomeViewCommand extends Command {

    @Override
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws EZExceptions {
        return Ui.printHomeView(projects, teamMembers);
    }

    public Boolean isExit() {
        return false;
    }

}
