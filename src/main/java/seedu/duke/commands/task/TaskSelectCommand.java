package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class TaskSelectCommand extends Command {

    private int taskIndex;
    private int projectIndex;

    public TaskSelectCommand(int taskIndex, int projectIndex) {
        this.taskIndex = taskIndex;
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        try {
            String selectedTask = projects.get(projectIndex).selectTask(taskIndex);
            return Ui.printTaskSelectedMessage(selectedTask);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
                return ("Project List is Empty!"); //----------REPLACE WITH EXCEPTION
            } else {
                return ("Task ID does not exist!"); //----------REPLACE WITH EXCEPTION
            }
    
        }
    }

    public Boolean isExit() {
        return false;
    }

}
