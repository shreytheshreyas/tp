package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ProjectList projects) {
        Project project = projects.getProject(projectIndex);

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
