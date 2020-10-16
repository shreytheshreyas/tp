package seedu.duke.commands;

import seedu.duke.project.Project;

import java.util.ArrayList;

/**
 * Displays goodbye message when application is terminated by the user.
 */
public class ExitCommand extends Command {
    public String executeCommand(ArrayList<Project> projects) {
        return printGoodbyeMessage();
    }

    public Boolean isExit() {
        return true;
    }

    private String printGoodbyeMessage() {
        return "See you again!";
    }
}
