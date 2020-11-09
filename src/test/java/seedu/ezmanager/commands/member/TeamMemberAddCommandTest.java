package seedu.duke.commands.member;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.Parser;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamMemberAddCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();
    static HashMap<String, String> params;

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        teamMembers = new ArrayList<>();
        params = new HashMap<>();
    }

    @Test
    public void executeCommand_validMemberName_memberAddedMessage() throws DukeExceptions {
        params.put("n", "John Doe");
        TeamMemberAddCommand command = new TeamMemberAddCommand(params);
        String expectedOutput = Ui.printMemberAddedMessage("John Doe");
        String actualOuput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOuput);
    }

}