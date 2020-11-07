package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TeamMemberAssignToTaskCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberAssignToTaskCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
        memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        Task selectedTask;
        TeamMember teamMember;
        Project project = projects.get(projectIndex);
        try {
            if (project.getTaskList().isEmpty()) {
                throw new DukeExceptions("emptyTaskList");
            }
            selectedTask = project.getTask(taskIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }

        try {
            if (project.getTeamMembers().isEmpty()) {
                throw new DukeExceptions("emptyTeamMembersList");
            }
            teamMember = project.getTeamMembers().get(memberIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTeamMemberID");
        }
        selectedTask.setMember(teamMember);
        return Ui.printMemberAssignedToTaskMessage(teamMember.getName(), selectedTask.getTaskDescription());
    }

    public Boolean isExit() {
        return false;
    }
}
