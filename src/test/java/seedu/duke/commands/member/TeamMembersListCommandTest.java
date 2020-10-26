package seedu.duke.commands.member;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.project.ProjectListCommand;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamMembersListCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;

    @BeforeAll
    static void createTeamMembersList() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        projects.add(projectOne);
        teamMembers = new ArrayList<>();
        TeamMember member1 = new TeamMember("John Doe");
        TeamMember member2 = new TeamMember("Sarah Hopkins");
        TeamMember member3 = new TeamMember("Brandon Ginger");
        TeamMember member4 = new TeamMember("Jonathan Joseph");
        teamMembers.add(member1);
        teamMembers.add(member2);
        teamMembers.add(member3);
        teamMembers.add(member4);
    }

    @Test
    void executeCommand_listWithoutAssignedProject_listMessage() throws DukeExceptions {
        TeamMembersListCommand command = new TeamMembersListCommand();
        String expectedOutput = "1. John Doe: \tNot assigned to a project\n"
                + "2. Sarah Hopkins: \tNot assigned to a project\n"
                + "3. Brandon Ginger: \tNot assigned to a project\n"
                + "4. Jonathan Joseph: \tNot assigned to a project\n";
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_listWithAssignedProject_listMessage() throws DukeExceptions {
        teamMembers.get(0).setAssignedProjectId(1);
        teamMembers.get(2).setAssignedProjectId(1);
        TeamMembersListCommand command = new TeamMembersListCommand();
        String expectedOutput = "1. John Doe: \tAssigned to project 1\n"
                + "2. Sarah Hopkins: \tNot assigned to a project\n"
                + "3. Brandon Ginger: \tAssigned to project 1\n"
                + "4. Jonathan Joseph: \tNot assigned to a project\n";
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }
}