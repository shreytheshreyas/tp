package seedu.duke.commands;

import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class PrintHomeViewCommand extends Command {

    public String executeCommand(ArrayList<Project> projects) {
        return Ui.printHomeView(projects);
    }

    public Boolean isExit() {
        return false;
    }

}
