package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
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
            return projects.get(projectIndex).selectTask(taskIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
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
