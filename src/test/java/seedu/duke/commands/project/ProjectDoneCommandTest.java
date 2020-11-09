package seedu.duke.commands.project;

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

public class ProjectDoneCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();
    static HashMap<String, String> params;

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project A");
        Project projectTwo = new Project("Project B");
        Project projectThree = new Project("Project C");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
        teamMembers = new ArrayList<>();
        params = new HashMap<>();
    }

    /**
     * Test: Add deadline to the second project with valid project ID and deadline format.
     */
    @Test
    void executeCommand_doneProject() throws DukeExceptions {
        params.put("p", "1");
        ProjectDoneCommand command = new ProjectDoneCommand(params, 0);
        String expectedOutput = "Project \"Project A\" is done!";
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

}
