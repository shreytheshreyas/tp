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
import static seedu.ezmanager.Util.INVALID_MEMBER_ID;
import static seedu.ezmanager.Util.MEMBER_INDEX_KEY;
import static seedu.ezmanager.Util.MINUTES_IN_HOUR_DOUBLE;
import static seedu.ezmanager.Util.USER_JAVA_INDEX_DIFF;

public class TeamMemberHoursCommand extends Command {

    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberHoursCommand(HashMap<String, String> params, int projectIndex)
            throws EZExceptions {
        assert projectIndex == -1 : "projectIndex must be -1";
        this.params = params;
        this.parse();
    }

    public void parse() throws EZExceptions {
        try {
            memberIndex = Integer.parseInt(getHashValue(params, MEMBER_INDEX_KEY)) - USER_JAVA_INDEX_DIFF;
        } catch (NumberFormatException e) {
            throw new EZExceptions(INVALID_MEMBER_ID);
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> members) throws EZExceptions {
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
            throw new EZExceptions(INVALID_MEMBER_ID);
        }
    }

    public Boolean isExit() {
        return false;
    }

}
