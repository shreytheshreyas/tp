package seedu.duke.commands.task;

import seedu.duke.Duke;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskDoneCommand extends Command {

    private int projectIndex;
    private int taskIndex;
    HashMap<String, String> params;

    public TaskDoneCommand(HashMap<String, String> params, int projectIndex) throws DukeExceptions {
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

    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        Project project = projects.get(projectIndex);
        try {
            Task selectedTask = project.getTask(taskIndex);
            selectedTask.markAsDone();
            return Ui.printTaskDoneMessage(selectedTask.toString());
        }  catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskDoneCommand) {
            TaskDoneCommand taskCommand = (TaskDoneCommand) obj;
            return ((this.taskIndex == taskCommand.taskIndex)
                    && (this.projectIndex == taskCommand.projectIndex));
        } else {
            return false;
        }
    }
}
