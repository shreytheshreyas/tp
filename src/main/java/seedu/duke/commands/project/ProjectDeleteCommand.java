package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectDeleteCommand extends Command {

    private int projectIndex;
    HashMap<String, String> params;

    public ProjectDeleteCommand(HashMap<String, String> params)
            throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
    }

    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            Project projectToBeDeleted = projects.get(projectIndex);
            projects.remove(projectIndex);
            return Ui.printProjectDeletedMessage(projectToBeDeleted);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
