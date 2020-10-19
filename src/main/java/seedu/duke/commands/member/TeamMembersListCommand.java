package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;

import java.util.ArrayList;

public class TeamMembersListCommand extends Command {

    private String name;

    public TeamMembersListCommand() {
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        if (teamMembers.size() == 0) {
            return "No team members have been added.";
        }

        String listOfMembers = "";
        int i = 0;
        for (TeamMember member : teamMembers) {
            String memberLine = (i + 1) + ". " + member.getName() + "\n";
            listOfMembers += memberLine;
            i++;
        }

        return listOfMembers;
    }

    public Boolean isExit() {
        return false;
    }
}
