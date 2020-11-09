package seedu.duke.commands.member;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssignMemberToProjectCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        teamMembers = new ArrayList<>();
        Project project1 = new Project("Project 1");
        Project project2 = new Project("Project 2");
        Project project3 = new Project("Project 3");
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
    }

    @BeforeAll
    static void createMemberList() {
        teamMembers = new ArrayList<>();
        TeamMember member1 = new TeamMember("Member 1");
        TeamMember member2 = new TeamMember("Member 2");
        TeamMember member3 = new TeamMember("Member 3");
        teamMembers.add(member1);
        teamMembers.add(member2);
        teamMembers.add(member3);
    }

    @Test
    public void executeCommand_validMemberId_validProjectId_assignMemberToProject() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("m","2");
        params.put("p","1");

        AssignMemberToProjectCommand assignProject = new AssignMemberToProjectCommand(params,-1);
        String expectedOutput = "Member 2 assigned to Project \"Project 1\"";
        String actualOutput = assignProject.executeCommand(projects,teamMembers);
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void executeCommand_invalidMemberId_assignMemberToProject() throws DukeExceptions {
        HashMap<String,String> params = new HashMap<>();
        params.put("m","7");
        params.put("p","2");

        AssignMemberToProjectCommand command = new AssignMemberToProjectCommand(params,-1);
        String expectedOutput = "Team Member ID does not exist!";
        DukeExceptions actualOutputException = assertThrows(DukeExceptions.class, () ->
            command.executeCommand(projects, teamMembers));
        assertEquals(expectedOutput, actualOutputException.toString());
    }

    @Test
    public void executeCommand_invalidProjectId_assignMemberToProject() throws DukeExceptions {
        HashMap<String,String> params = new HashMap<>();
        params.put("m","1");
        params.put("p","5");

        AssignMemberToProjectCommand assignProject = new AssignMemberToProjectCommand(params,-1);
        String expectedOutput = "Project ID does not exist!";
        Throwable actualOutputException = assertThrows(DukeExceptions.class, () -> {
            assignProject.executeCommand(projects,teamMembers);
        });
        assertEquals(expectedOutput,actualOutputException.toString());
    }
}