package seedu.ezmanager.commands.task;

import seedu.ezmanager.EzExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import java.util.ArrayList;

import seedu.ezmanager.ui.Ui;

/**
 * Prints the Project View which shows list of tasks and members within a project.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    /**
     * Constructor for TaskListCommand. Calls parse() method.
     * @param projectIndex
     * @throws EzExceptions
     */
    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    /**
     * Executes command that displays project view.
     * @param projects
     * @param teamMembers
     * @return projectView
     * @throws EzExceptions
     */
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws EzExceptions {
        Project selectedProject = projects.get(projectIndex);
        String projectView = Ui.projectViewMessage(selectedProject);
        return projectView;
    }

    /**
     * Checks if command will exit program.
     * @return isExit status.
     */
    public Boolean isExit() {
        return false;
    }
}
