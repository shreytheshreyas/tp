package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;

import java.util.ArrayList;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;


public class TaskDeleteCommand extends Command {

    private int itemIndex;
    private int projectIndex;

    public TaskDeleteCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) {
        try {
            Project selectedProject = projects.get(projectIndex);
            String taskToBeDeleted = selectedProject.getTask(itemIndex).getTaskDescription();
            selectedProject.deleteTask(itemIndex);
            return Ui.printTaskDeletedMessage(taskToBeDeleted);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "There is an ERROR in TASKLIST!!";
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) { // TODO: this should be changed to check the number of tasks
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
