package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.Parser;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.ui.Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectSelectCommand extends Command {

    private int projectIndex;
    HashMap<String, String> params;

    public ProjectSelectCommand(HashMap<String, String> params)
            throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
            Parser.setProjectIndex(projectIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidProjectID");
        }
    }

    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        Project selectedProject = projects.get(projectIndex);
//        System.out.println("Switched to Project \"" + selectedProject + "\"");
        String projectDescription = selectedProject.getDescription();
        String projectDeadline = selectedProject.getProjectDeadline();
        //For small sam => help me implement this
        String projectView = Ui.projectViewMessage(selectedProject);
        String members = "<team members involved empty>";
//        return projectDescription + " | " + projectDeadline + " | " + members;
        return projectView;
    }

    public Boolean isExit() {
        return false;
    }

}
