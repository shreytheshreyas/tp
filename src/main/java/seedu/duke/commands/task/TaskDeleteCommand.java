package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;

import java.util.ArrayList;

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
            return projects.get(projectIndex).deleteTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
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
