//@@author thatseant

package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;
import static seedu.duke.Util.HOUR_INDEX_KEY;
import static seedu.duke.Util.INVALID_TASK_ID;
import static seedu.duke.Util.MINUTES_IN_HOUR_INT;
import static seedu.duke.Util.MINUTE_INDEX_KEY;
import static seedu.duke.Util.TASK_INDEX_KEY;
import static seedu.duke.Util.USER_JAVA_INDEX_DIFF;

public class EstimatedTimeCommand extends Command {

    private int taskIndex;
    private int durationInMinutes;
    private int projectIndex;
    HashMap<String, String> params;

    public EstimatedTimeCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        assert projectIndex >= 0 : projectIndex;
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, TASK_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
            int hours = Integer.parseInt(getHashValue(params, HOUR_INDEX_KEY));
            int minutes = Integer.parseInt(getHashValue(params, MINUTE_INDEX_KEY));
            durationInMinutes = hours * MINUTES_IN_HOUR_INT + minutes;
        } catch (NumberFormatException e) {
            throw new DukeExceptions(INVALID_TASK_ID);
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> members) throws DukeExceptions {
        try {
            Project project = projects.get(projectIndex);
            Task task = project.getTask(taskIndex);
            task.addEstimate(durationInMinutes);
            int hours = task.getEstimate() / MINUTES_IN_HOUR_INT;
            int minutes = task.getEstimate() % MINUTES_IN_HOUR_INT;
            return Ui.printEstimateAddedMessage(task.getDescription(), hours, minutes);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions(INVALID_TASK_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }

}