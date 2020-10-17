package seedu.duke.commands;

import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

/**
 * Displays goodbye message when application is terminated by the user.
 */
public class ExitCommand extends Command {
    public String executeCommand(ProjectList projects) {
        return printGoodbyeMessage();
    }

    public Boolean isExit() {
        return true;
    }

    private String printGoodbyeMessage() {
        return Ui.printGoodbyeMessage();
    }
}
