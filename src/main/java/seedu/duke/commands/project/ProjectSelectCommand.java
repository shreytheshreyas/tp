package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;

public class ProjectSelectCommand extends Command {

    private int itemIndex;

    public ProjectSelectCommand(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String executeCommand(ProjectList projects) {
        try {
            return projects.selectProject(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                return "I am empty!!!";
            } else {
                return "Invalid project ID";
            }
        }
    }

    public Boolean isExit() {
        return false;
    }

}
