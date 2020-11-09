package seedu.ezmanager.commands.task;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;

import java.util.ArrayList;
import java.util.HashMap;

import seedu.ezmanager.ui.Ui;

import static seedu.ezmanager.Parser.getHashValue;


public class TaskDeleteCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    HashMap<String, String> params;

    public TaskDeleteCommand(HashMap<String, String> params, int projectIndex)
            throws EZExceptions {
        assert projectIndex >= 0 : "projectIndex must be positive integer!";
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
    }

    @Override
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws EZExceptions {
        if (projects.size() == 0) {
            throw new EZExceptions("emptyProjectList");
        }
        try {
            Project selectedProject = projects.get(projectIndex);
            //Get task before deletion
            String taskToBeDeleted = selectedProject.getTask(taskIndex).getTaskDescription();
            selectedProject.deleteTask(taskIndex);
            return Ui.printTaskDeletedMessage(taskToBeDeleted);
        } catch (IndexOutOfBoundsException e) {
            throw new EZExceptions("invalidTaskID");
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
