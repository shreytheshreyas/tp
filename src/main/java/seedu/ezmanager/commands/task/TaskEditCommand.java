package seedu.ezmanager.commands.task;

import seedu.ezmanager.EzExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.ezmanager.Parser.getHashValue;

/**
 * Command that update the name of a specific task.
 */
public class TaskEditCommand extends Command {

    private int taskIndex;
    private String taskName;
    private int projectIndex;
    HashMap<String, String> params;

    /**
     * Constructor for TaskEditCommand. Calls parse() method.
     * @param params Hashmap of parameters the command requires.
     * @param projectIndex
     * @throws EzExceptions
     */
    public TaskEditCommand(HashMap<String, String> params, int projectIndex)
            throws EzExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    /**
     * Retrieves task index and task name from hashmap passed to it from constructor.
     * @throws EzExceptions
     */
    public void parse() throws EzExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            taskName = getHashValue(params, "n");
        } catch (NumberFormatException e) {
            throw new EzExceptions("invalidTaskID");
        }
    }

    /**
     * Executes command to update name of task.
     * @param projects
     * @param teamMembers
     * @return task name updated UI message.
     * @throws EzExceptions
     */
    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws EzExceptions {
        if (projects.size() == 0) {
            throw new EzExceptions("emptyProjectList");
        }
        try {
            Task selectedTask = projects.get(projectIndex).getTask(taskIndex);
            String oldTaskName = selectedTask.getTaskDescription();
            selectedTask.setTaskDescription(taskName);
            return Ui.printTaskNameUpdatedMessage(oldTaskName, taskName);
        } catch (IndexOutOfBoundsException e) {
            throw new EzExceptions("invalidTaskID");
        }
    }

    /**
     * Checks if command will exit program.
     * @return isExit status.
     */
    public Boolean isExit() {
        return false;
    }
}
