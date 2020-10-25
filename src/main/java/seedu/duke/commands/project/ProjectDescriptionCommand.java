package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ProjectDescriptionCommand extends Command {

    private String projectDescription;
    private int projectIndex;


    public ProjectDescriptionCommand(String projectDescription, int projectIndex) {
        this.projectDescription = projectDescription;
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        Project project = projects.get(projectIndex);
        project.addDescription(projectDescription);
        return Ui.printProjectDescriptionAddedMessage(project);
    }

    public Boolean isExit() {
        return false;
    }
}
