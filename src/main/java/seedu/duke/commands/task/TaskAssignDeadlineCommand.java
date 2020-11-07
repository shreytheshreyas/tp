//@@author thatseant

package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;
import static seedu.duke.Util.DATE_KEY;
import static seedu.duke.Util.EMPTY_PROJECT_LIST;
import static seedu.duke.Util.INVALID_TASK_ID;
import static seedu.duke.Util.TASK_INDEX_KEY;
import static seedu.duke.Util.USER_JAVA_INDEX_DIFF;
import static seedu.duke.Util.WRONG_DATE_FORMAT;

public class TaskAssignDeadlineCommand extends Command {
    private int projectIndex;
    private int taskIndex;
    private LocalDate date;
    HashMap<String, String> params;

    public TaskAssignDeadlineCommand(HashMap<String, String> params, int projectIndex) throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, TASK_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
            date = LocalDate.parse(getHashValue(params, DATE_KEY));
        } catch (NumberFormatException e) {
            throw new DukeExceptions(INVALID_TASK_ID);
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            throw new DukeExceptions(WRONG_DATE_FORMAT);
        }
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions(EMPTY_PROJECT_LIST);
        }
        try {
            Project project = projects.get(projectIndex);
            Task task = project.getTaskList().get(taskIndex);
            task.addDeadline(date);
            return Ui.printTaskDeadlineMessage(date, task.getDescription());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions(INVALID_TASK_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }
}
