package seedu.duke.commands.member;

import java.util.HashMap;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;

import static seedu.duke.Parser.getHashValue;
import java.util.ArrayList;

public class AssignMemberToProjectCommand extends Command {
    private int memberIndex;
    private int projectIndex;
    private boolean isProjectView;
    private HashMap<String, String> paramsList;

    public AssignMemberToProjectCommand (HashMap<String,String> paramsList, boolean isProjectView) throws DukeExceptions{
        this.paramsList = paramsList;
        this.isProjectView = isProjectView;
        parse();
    }

    public void parse() throws DukeExceptions {
        if(isProjectView) {
            try{
                projectIndex = Integer.parseInt(getHashValue(paramsList,"p"));
                memberIndex = Integer.parseInt(getHashValue(paramsList,"m")) - 1;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("There is no project with this respective Id");
            }
        } else {
            throw new DukeExceptions("default");
        }
    }

    @Override
    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        if (memberIndex > Project.getMembers().size()) {
            throw new DukeExceptions("default");
        }
        TeamMember requiredMember = Project.getMembers().get(memberIndex);
        requiredMember.setAssignedProjectId(projectIndex);
        return "Member assigned to project";
    }

    public Boolean isExit() {
        return false;
    }
}
