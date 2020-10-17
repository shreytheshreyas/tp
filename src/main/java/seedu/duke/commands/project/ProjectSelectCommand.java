package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ProjectSelectCommand extends Command {

    private int projectIndex;

    public ProjectSelectCommand(int itemIndex) {
        this.projectIndex = itemIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        try {
            Ui.printProjectSelectedMessage(projects, projectIndex);
            return projects.get(projectIndex).toString();
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
                return "Project List is Empty!";
            } else {
                return "Project ID does not exist!";
            }
        }
    }

    public Boolean isExit() {
        return false;
    }

}
