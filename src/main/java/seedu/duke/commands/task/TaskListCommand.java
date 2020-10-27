package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import java.util.ArrayList;
import java.util.Arrays;
import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        Project project = projects.get(projectIndex);
        int numberOfTasks = project.getTaskList().size();
        if (numberOfTasks == 0) {
            throw new DukeExceptions("emptyTaskList");
        } else {
            return Ui.printTaskListMessage(project);
        }
    }

    public Boolean isExit() {
        return false;
    }
}
