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
import static seedu.duke.Util.INVALID_MEMBER_ID;
import static seedu.duke.Util.MEMBER_INDEX_KEY;
import static seedu.duke.Util.MINUTES_IN_HOUR_DOUBLE;
import static seedu.duke.Util.USER_JAVA_INDEX_DIFF;

public class TeamMemberHoursCommand extends Command {

    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberHoursCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        assert projectIndex == -1 : projectIndex;
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            memberIndex = Integer.parseInt(getHashValue(params, MEMBER_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
        } catch (NumberFormatException e) {
            throw new DukeExceptions(INVALID_MEMBER_ID);
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> members) throws DukeExceptions {
        try {
            double hoursWorked = 0;
            assert memberIndex >= 0 : memberIndex;
            TeamMember member = members.get(memberIndex);
            for (int i = 0; i < member.getTasks().size(); i++) {
                Task task = member.getTasks().get(i);
                hoursWorked += task.getActual() / MINUTES_IN_HOUR_DOUBLE;
            }
            return Ui.printHoursWorkedMessage(member.getName(), hoursWorked);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions(INVALID_MEMBER_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }

}
