package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);

        int numberOfTasks = project.getNumberTasks();

        if (numberOfTasks == 0) {
            return "Task list is empty!!";
        } else {
            String output = "List of Tasks:";
            for (int i = 0; i < numberOfTasks; i++) {
                output += "\n     " + (i + 1) + "." + project.getTask(i);
            }
            return output;
        }
    }

    public Boolean isExit() {
        return false;
    }
}
