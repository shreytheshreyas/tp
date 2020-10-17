package seedu.duke.commands;

import seedu.duke.Parser;
import seedu.duke.project.Project;

import java.util.ArrayList;

public class HomeCommand extends Command {

    private int projectIndex;

    public HomeCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) {
        if (projectIndex == -1) {
            return "Already in Home View!";
        } else {
            Parser.setProjectIndex(-1);
            return "Switched to Home View";
        }

    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
