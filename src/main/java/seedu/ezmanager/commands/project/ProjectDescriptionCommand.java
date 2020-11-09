package seedu.ezmanager.commands.project;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.ezmanager.Parser.getHashValue;

public class ProjectDescriptionCommand extends Command {

    private String projectDescription;
    private int projectIndex;
    HashMap<String, String> params;

    public ProjectDescriptionCommand(HashMap<String, String> params) throws EZExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws EZExceptions {
        projectDescription = getHashValue(params, "d");
        try {
            projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
        } catch (NumberFormatException e) {
            throw new EZExceptions("indexNonInteger");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws EZExceptions {
        try {
            Project project = projects.get(projectIndex);
            project.addDescription(projectDescription);
            return Ui.printProjectDescriptionAddedMessage(project);
        } catch (IndexOutOfBoundsException e) {
            throw new EZExceptions("invalidProjectID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
