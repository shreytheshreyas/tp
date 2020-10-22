package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import java.util.ArrayList;
import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        Project project = projects.get(projectIndex);
        int numberOfTasks = project.getNumberTasks();
        if (numberOfTasks == 0) {
            return "Task list is empty!!";
        } else {
            return Ui.printTaskListMessage(project);
        }
    }

    public Boolean isExit() {
        return false;
    }
}
