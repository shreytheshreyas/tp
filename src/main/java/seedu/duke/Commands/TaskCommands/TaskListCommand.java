package seedu.duke.Commands.TaskCommands;

import seedu.duke.Commands.Command;
import seedu.duke.ProjectStuff.Project;
import seedu.duke.ProjectStuff.ProjectList;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);

        if (project.getTasks().size() == 0) {
            System.out.println("Task list is empty!!");
        } else {
            System.out.println("List of Tasks:");
            for (int i = 0; i < project.getTasks().size(); i++) {
                System.out.println("     " + (i + 1) + "." + project.getTasks().get(i));
            }
        }
    }

    public Boolean isExit() {
        return false;
    }
}
