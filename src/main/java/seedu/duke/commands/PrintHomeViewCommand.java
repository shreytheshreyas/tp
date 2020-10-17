package seedu.duke.commands;

import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

public class PrintHomeViewCommand extends Command {

    public String executeCommand(ProjectList projects) {
        return Ui.printHomeView(projects);
    }

    public Boolean isExit() {
        return false;
    }

}
