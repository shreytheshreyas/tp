package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;

import java.util.ArrayList;

public class ProjectCommand extends Command {

    private String description;

    public ProjectCommand(String description) {
        this.description = description;
    }

    public String executeCommand(ArrayList<Project> projects) {
        try {
            Project newProject = new Project(description);
            projects.add(newProject);
            return ("Project \"" + description + "\" created!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            return ("There is an ERROR in PROJECTLIST!!");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
