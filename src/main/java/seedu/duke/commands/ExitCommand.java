package seedu.duke.commands;


import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import java.util.ArrayList;
import seedu.duke.ui.Ui;

/**
 * Displays goodbye message when application is terminated by the user.
 */
public class ExitCommand extends Command {
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        return printGoodbyeMessage();
    }

    public Boolean isExit() {
        return true;
    }

    private String printGoodbyeMessage() {
        return Ui.printGoodbyeMessage();
    }
}
