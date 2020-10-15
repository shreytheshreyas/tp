package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

public class TaskSelectCommand extends Command {

    private int taskIndex;
    private int projectIndex;

    public TaskSelectCommand(int taskIndex, int projectIndex) {
        this.taskIndex = taskIndex;
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ProjectList projects) {
        try {
            Project project = projects.getProject(projectIndex);
            return "Selected Task: " + project.getTask(taskIndex);
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
