package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskEditCommand extends Command {

    private int taskIndex;
    private String taskName;
    private int projectIndex;
    HashMap<String, String> params;

    public TaskEditCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            taskName = getHashValue(params, "n");
        } catch (NumberFormatException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            Task selectedTask = projects.get(projectIndex).getTask(taskIndex);
            String oldTaskName = selectedTask.getTaskDescription();
            selectedTask.setTaskDescription(taskName);
            return Ui.printTaskNameUpdatedMessage(oldTaskName, taskName);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
