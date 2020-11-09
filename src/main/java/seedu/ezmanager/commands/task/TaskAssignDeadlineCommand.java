//@@author thatseant

package seedu.ezmanager.commands.task;

import seedu.ezmanager.EZExceptions;
import seedu.ezmanager.EZLogger;
import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import static seedu.ezmanager.Parser.getHashValue;
import static seedu.ezmanager.Util.DATE_KEY;
import static seedu.ezmanager.Util.EMPTY_PROJECT_LIST;
import static seedu.ezmanager.Util.INVALID_TASK_ID;
import static seedu.ezmanager.Util.TASK_INDEX_KEY;
import static seedu.ezmanager.Util.USER_JAVA_INDEX_DIFF;
import static seedu.ezmanager.Util.WRONG_DATE_FORMAT;

public class TaskAssignDeadlineCommand extends Command {
    private int projectIndex;
    private int taskIndex;
    private LocalDate date;
    HashMap<String, String> params;

    public TaskAssignDeadlineCommand(HashMap<String, String> params, int projectIndex) throws EZExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, TASK_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
            date = LocalDate.parse(getHashValue(params, DATE_KEY));
        } catch (NumberFormatException e) {
            throw new EZExceptions(INVALID_TASK_ID);
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            EZLogger.log(Level.WARNING, "Wrong Date Format: " + date);
            throw new EZExceptions(WRONG_DATE_FORMAT);
        }
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws EZExceptions {
        EZLogger.log(Level.INFO, "Executing Command");
        if (projects.size() == 0) {
            throw new EZExceptions(EMPTY_PROJECT_LIST);
        }
        try {
            Project project = projects.get(projectIndex);
            Task task = project.getTaskList().get(taskIndex);
            EZLogger.log(Level.INFO, "Task Retrieved");
            task.addDeadline(date);
            EZLogger.log(Level.INFO, "Deadline added to task.");
            return Ui.printTaskDeadlineMessage(date, task.getDescription());
        } catch (IndexOutOfBoundsException e) {
            EZLogger.log(Level.WARNING, "Task Not Found.");
            throw new EZExceptions(INVALID_TASK_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }
}
