package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

public class TaskDeleteCommand extends Command {

    private int itemIndex;
    private int projectIndex;

    public TaskDeleteCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    @Override
    public void executeCommand(ProjectList projects) {
        try {
            projects.getProject(projectIndex).deleteTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                System.out.println("Task list is empty!!!"); //----------REPLACE WITH EXCEPTION
            } else {
                System.out.println("Invalid Task number"); //----------REPLACE WITH EXCEPTION
            }
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
