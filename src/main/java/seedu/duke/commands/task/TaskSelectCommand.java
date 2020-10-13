package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

public class TaskSelectCommand extends Command {

    private int itemIndex;
    private int projectIndex;

    public TaskSelectCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        try {
            projects.getProject(projectIndex).selectTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                System.out.println("I am empty!!!"); //----------REPLACE WITH EXCEPTION
            } else {
                System.out.println("Invalid project ID"); //----------REPLACE WITH EXCEPTION
            }
        }
    }

    public Boolean isExit() {
        return false;
    }

}
