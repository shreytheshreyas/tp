package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

public class TaskDeleteCommand extends Command {

    private int itemIndex;
    private int projectIndex;

    public TaskDeleteCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    @Override
    public String executeCommand(ProjectList projects) {
        try {
             Project project = projects.getProject(projectIndex);
             project.deleteTask(itemIndex);
            return "Task " + (itemIndex + 1) + " removed!!";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "There is an ERROR in TASKLIST!!";
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                return ("Task list is empty!!!"); //----------REPLACE WITH EXCEPTION
            } else {
                return ("Invalid Task number"); //----------REPLACE WITH EXCEPTION
            }
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
