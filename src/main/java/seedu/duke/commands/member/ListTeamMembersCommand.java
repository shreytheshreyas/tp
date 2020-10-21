package seedu.duke.commands.member;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.member.TeamMemberList;

import java.util.ArrayList;

public class ListTeamMembersCommand extends Command {

    private String name;

    public ListTeamMembersCommand() {
    }

    public String executeCommand(ArrayList<Project> projects) {
        if (Project.getMembers().size() == 0) {
            return "No team members have been added.";
        }

        String listOfMembers = "";
        int i = 0;
        for (TeamMember member : Project.getMembers()) {
            String assignmentStatus = (member.getAssignedProjectId() == 0) ? "Not assigned to a project "
                                    : "assigned to project " + member.getAssignedProjectId();
            String memberLine = (i + 1) + ". " + member.getName() + ": \t" + assignmentStatus + "\n";
            listOfMembers += memberLine;
            i++;
        }

        return listOfMembers;
    }

    public Boolean isExit() {
        return false;
    }
}
