//@@author thatseant

package seedu.ezmanager.commands.task;

import seedu.ezmanager.EZLogger;
import seedu.ezmanager.Util;
import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import static seedu.ezmanager.Util.HOUR_INDEX_KEY;
import static seedu.ezmanager.Util.MINUTES_IN_HOUR_INT;
import static seedu.ezmanager.Util.TASK_INDEX_KEY;
import static seedu.ezmanager.Util.USER_JAVA_INDEX_DIFF;
import static seedu.ezmanager.Parser.getHashValue;

public class ActualTimeCommand extends Command {

    private int taskIndex;
    private int durationInMinutes;
    private int projectIndex;
    HashMap<String, String> params;

    public ActualTimeCommand(HashMap<String, String> params, int projectIndex)
            throws EZExceptions {
        assert projectIndex >= 0 : "projectIndex must be positive integer!";
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, TASK_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
            int hours = Integer.parseInt(getHashValue(params, HOUR_INDEX_KEY));
            int minutes = Integer.parseInt(getHashValue(params, Util.MINUTE_INDEX_KEY));
            durationInMinutes = hours * MINUTES_IN_HOUR_INT + minutes;
        } catch (NumberFormatException e) {
            throw new EZExceptions(Util.INVALID_TASK_ID);
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> members) throws EZExceptions {
        try {
            EZLogger.log(Level.INFO, "Executing Command");
            Project project = projects.get(projectIndex);
            Task task = project.getTask(taskIndex);
            EZLogger.log(Level.INFO, "Task Retrieved");
            if (!task.isDone()) {
                EZLogger.log(Level.WARNING, "Task Not Done!");
                throw new EZExceptions(Util.TASK_NOT_DONE);
            }
            task.addActual(durationInMinutes);
            EZLogger.log(Level.INFO, "Actual Time Taken added to task.");
            int hours = task.getActual() / MINUTES_IN_HOUR_INT;
            int minutes = task.getActual() % MINUTES_IN_HOUR_INT;
            return Ui.printActualDurationAddedMessage(task.getDescription(), hours, minutes);
        } catch (IndexOutOfBoundsException e) {
            EZLogger.log(Level.WARNING, "Task Not Found.");
            throw new EZExceptions(Util.INVALID_TASK_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }

}