package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

import java.util.ArrayList;

public class ProjectSelectCommand extends Command {

    private int projectIndex;

    public ProjectSelectCommand(int itemIndex) {
        this.projectIndex = itemIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        try {
            System.out.println("Switched to Project \"" + projects.get(projectIndex) + "\"");
            if (projects.get(projectIndex).getDescription().equals("")) {
                return "<project description empty> | <project deadline empty> | "
                        + "<team members involved empty>";
            } else {
                return projects.get(projectIndex).getDescription()
                        + " | <project deadline empty> | <team members involved empty>";
            }
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.size() == 0) {
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
