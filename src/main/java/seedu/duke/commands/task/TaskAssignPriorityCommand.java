package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskAssignPriorityCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    private String priority;
    HashMap<String, String> params;

    public TaskAssignPriorityCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            priority = getHashValue(params, "p");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        Task selectedTask = projects.get(projectIndex).getTask(taskIndex);
        selectedTask.setPriority(priority);
        return Ui.printPriorityAssignedToTaskMessage(priority, selectedTask.getTaskDescription());
    }

    public Boolean isExit() {
        return false;
    }

}
