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
    Project selectedProject;

    public TaskDeleteCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) {
        try {
            selectedProject = projects.get(projectIndex);
            //Get task before deletion
            String taskToBeDeleted = selectedProject.getTask(itemIndex).getTaskDescription();
            selectedProject.deleteTask(itemIndex);
            return Ui.printTaskDeletedMessage(taskToBeDeleted);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
                return ("Project List is Empty!"); //----------REPLACE WITH EXCEPTION
            } else {
                return ("Task ID does not exist!"); //----------REPLACE WITH EXCEPTION
            }
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
