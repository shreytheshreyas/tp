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

public class TeamMemberHoursCommand extends Command {

    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberHoursCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
        } catch (NumberFormatException e) {
            throw new DukeExceptions("invalidMemberID");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> members) throws DukeExceptions {
        try {
            double hoursWorked = 0;
            TeamMember member = members.get(memberIndex);
            for (int i = 0; i < member.getTasks().size(); i++) {
                Task task = member.getTasks().get(i);
                hoursWorked += task.getActual()/60.0;
            }
            return Ui.printHoursWorkedMessage(member.getName(), hoursWorked);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidMemberID");
        }
    }

    public Boolean isExit() {
        return false;
    }

}
