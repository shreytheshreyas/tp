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

    public String executeCommand(ProjectList projects) {
        try {
            return projects.getProject(projectIndex).selectTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                return ("I am empty!!!"); //----------REPLACE WITH EXCEPTION
            } else {
                return ("Invalid project ID"); //----------REPLACE WITH EXCEPTION
            }
        }
    }

    public Boolean isExit() {
        return false;
    }

}
