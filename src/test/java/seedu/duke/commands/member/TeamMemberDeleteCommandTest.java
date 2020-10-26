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

class TeamMemberDeleteCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();
    static HashMap<String, String> params;

    @BeforeAll
    static void createTeamMembersList() {
        projects = new ArrayList<>();
        teamMembers = new ArrayList<>();
        TeamMember member1 = new TeamMember("John Doe");
        TeamMember member2 = new TeamMember("Sarah Hopkins");
        teamMembers.add(member1);
        teamMembers.add(member2);
        params = new HashMap<>();
    }

    @Test
    void executeCommand_valildMemberId_memberRemovedMessage() throws DukeExceptions {
        params.put("m", "1");
        TeamMemberDeleteCommand command = new TeamMemberDeleteCommand(params);
        String expectedOutput = "Team member \"John Doe\" has been removed";
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_nonExistentMemberId_invalidMemberIdException() throws DukeExceptions {
        params.put("m", "10");
        TeamMemberDeleteCommand command = new TeamMemberDeleteCommand(params);
        String expectedOutput = "Team Member ID does not exist!";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                command.executeCommand(projects, teamMembers));
        assertEquals(expectedOutput, exception.toString());
    }
}