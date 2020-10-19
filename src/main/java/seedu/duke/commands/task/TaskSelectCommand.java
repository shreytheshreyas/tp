package seedu.duke.commands.task;

import seedu.duke.Duke;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskSelectCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    HashMap<String, String> params;

    public TaskSelectCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
    }

    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            String selectedTask = projects.get(projectIndex).selectTask(taskIndex);
            return Ui.printTaskSelectedMessage(selectedTask);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }

}
