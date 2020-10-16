package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

import java.util.ArrayList;

public class ProjectDescriptionCommand extends Command {

    private String projectDescription;
    private int projectIndex;


    public ProjectDescriptionCommand(String projectDescription, int projectIndex) {
        this.projectDescription = projectDescription;
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ArrayList<Project> projects) {
        Project project = projects.get(projectIndex);
        project.addDescription(projectDescription);
        return "Project description added \"" + project.getDescription() + "\".";
    }

    public Boolean isExit() {
        return false;
    }
}
