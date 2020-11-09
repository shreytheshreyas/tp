//@@author thatseant

package seedu.ezmanager.commands.task;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.EZLogger;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import static seedu.ezmanager.Util.TASK_NAME_KEY;
import static seedu.ezmanager.Parser.getHashValue;

public class TaskCommand extends Command {

    private int projectIndex;
    private String description;
    HashMap<String, String> params;

    public TaskCommand(HashMap<String, String> params, int projectIndex) throws EZExceptions {
        assert projectIndex >= 0 : "projectIndex must be positive integer!";
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws EZExceptions {
        this.description = getHashValue(params, TASK_NAME_KEY);
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        EZLogger.log(Level.INFO, "Executing Command");
        Project project = projects.get(projectIndex);
        EZLogger.log(Level.INFO, "Project Retrieved");
        Task newTask = new Task(description);
        EZLogger.log(Level.INFO, "Task Created");
        project.addTask(newTask);
        EZLogger.log(Level.INFO, "Task Added");
        return Ui.printTaskCreatedMessage(newTask.toString());
    }

    public Boolean isExit() {
        return false;
    }
}
