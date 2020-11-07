package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static seedu.duke.Parser.getHashValue;

public class TeamMemberDeleteCommand extends Command {
    private int memberIndex;
    HashMap<String, String> params;
    private int projectIndex;

    public TeamMemberDeleteCommand(HashMap<String, String> params, int projectIndex) throws DukeExceptions {
        this.params = params;
        this.parse();
        this.projectIndex = projectIndex;
    }

    public void parse() throws DukeExceptions {
        try {
            memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
        } catch (NumberFormatException e) {
            throw new DukeExceptions("invalidTeamMemberID");
        }
    }

    @Override
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (teamMembers.size() == 0) {
            throw new DukeExceptions("emptyTeamMembersList");
        }
        try {
            // Removing of Members in HomeView
            if (projectIndex == -1) {
                TeamMember memberToBeRemoved = teamMembers.get(memberIndex);
                teamMembers.remove(memberIndex);
                for (Project project : projects) {
                    Iterator<TeamMember> teamMemberIterator = project.getTeamMembers().iterator();
                    while (teamMemberIterator.hasNext()) {
                        TeamMember member = teamMemberIterator.next();
                        if (member == memberToBeRemoved) {
                            teamMemberIterator.remove();
                        }
                    }

                    for (Task task : project.getTaskList()) {
                        Iterator<TeamMember> teamMemberInTaskIterator = task.getMembers().iterator();
                        while (teamMemberInTaskIterator.hasNext()) {
                            TeamMember member = teamMemberInTaskIterator.next();
                            if (member == memberToBeRemoved) {
                                teamMemberInTaskIterator.remove();
                            }
                        }
                    }
                }
                return Ui.printMemberRemovedInHomeViewMessage(memberToBeRemoved.getName());
            // Removing of members in ProjectView
            } else {
                Project project = projects.get(projectIndex);
                TeamMember memberToBeRemoved = project.getTeamMembers().get(memberIndex);
                project.getTeamMembers().remove(memberIndex);
                for (Task task : project.getTaskList()) {
                    Iterator<TeamMember> teamMemberInTaskIterator = task.getMembers().iterator();
                    while (teamMemberInTaskIterator.hasNext()) {
                        TeamMember member = teamMemberInTaskIterator.next();
                        if (member == memberToBeRemoved) {
                            teamMemberInTaskIterator.remove();
                        }
                    }
                }
                memberToBeRemoved.getAssignedProjects().remove(project);
                return Ui.printMemberRemovedInProjectViewMessage(memberToBeRemoved.getName(), project.getProjectName());
            }



        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTeamMemberID");
        }
    }

    @Override
    public Boolean isExit() {
        return false;
    }
}
