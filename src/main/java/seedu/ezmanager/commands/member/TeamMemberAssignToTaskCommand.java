package seedu.ezmanager.commands.member;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.ezmanager.Parser.getHashValue;

public class TeamMemberAssignToTaskCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberAssignToTaskCommand(HashMap<String, String> params, int projectIndex)
            throws EZExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
        } catch (NumberFormatException e) {
            throw new EZExceptions("invalidTaskID");
        }
        try {
            memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
        } catch (NumberFormatException e) {
            throw new EZExceptions("invalidTeamMemberID");
        }
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws EZExceptions {
        Task selectedTask;
        TeamMember teamMember;
        assert projectIndex >= 0 : "projectIndex should be minus one "
                + "of the current project it was selected";
        Project project = projects.get(projectIndex);
        try {
            if (project.getTaskList().isEmpty()) {
                throw new EZExceptions("emptyTaskList");
            }
            selectedTask = project.getTask(taskIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new EZExceptions("invalidTaskID");
        }

        try {
            if (project.getTeamMembers().isEmpty()) {
                throw new EZExceptions("emptyTeamMembersList");
            }
            teamMember = project.getTeamMembers().get(memberIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new EZExceptions("invalidTeamMemberID");
        }
        selectedTask.setMember(teamMember);
        return Ui.printMemberAssignedToTaskMessage(teamMember.getName(), selectedTask.getTaskDescription());
    }

    public Boolean isExit() {
        return false;
    }
}
