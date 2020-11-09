package seedu.ezmanager.commands.task;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.ezmanager.Parser.getHashValue;

public class TaskEditCommand extends Command {

    private int taskIndex;
    private String taskName;
    private int projectIndex;
    HashMap<String, String> params;

    public TaskEditCommand(HashMap<String, String> params, int projectIndex)
            throws EZExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            taskName = getHashValue(params, "n");
        } catch (NumberFormatException e) {
            throw new EZExceptions("invalidTaskID");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws EZExceptions {
        if (projects.size() == 0) {
            throw new EZExceptions("emptyProjectList");
        }
        try {
            Task selectedTask = projects.get(projectIndex).getTask(taskIndex);
            String oldTaskName = selectedTask.getTaskDescription();
            selectedTask.setTaskDescription(taskName);
            return Ui.printTaskNameUpdatedMessage(oldTaskName, taskName);
        } catch (IndexOutOfBoundsException e) {
            throw new EZExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
