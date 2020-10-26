package seedu.duke.commands;

import seedu.duke.Parser;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class HomeCommand extends Command {

    private int projectIndex;

    public HomeCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    @Override
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        if (projectIndex == -1) {
            return Ui.printInHomeViewMessage();
        } else {
            Parser.setProjectIndex(-1);
            return Ui.printSwitchedToHomeViewMessage();
        }

    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
