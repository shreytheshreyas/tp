package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.project.Project;

import java.util.ArrayList;
import java.util.HashMap;

import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import static seedu.duke.Parser.getHashValue;


public class TaskDeleteCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    HashMap<String, String> params;

    public TaskDeleteCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        Project selectedProject = projects.get(projectIndex);
        //Get task before deletion
        String taskToBeDeleted = selectedProject.getTask(taskIndex).getTaskDescription();
        selectedProject.deleteTask(taskIndex);
        return Ui.printTaskDeletedMessage(taskToBeDeleted);
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
