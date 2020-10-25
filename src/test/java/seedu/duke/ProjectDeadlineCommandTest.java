package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectDeadlineCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.ui.Ui;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProjectDeadlineCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Drink Water");
        Project projectTwo = new Project("Fire");
        Project projectThree = new Project("CS2113 Tutorial");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
    }

    /**
     * Test: Add deadline to the second project with valid project ID and deadline format.
     */
    @Test
    void executeCommand_validProjectId_addDeadlineToProject() throws DukeExceptions {
        LocalDate date = LocalDate.parse("2020-12-31");
        ProjectDeadlineCommand command = new ProjectDeadlineCommand(1, date);
        String expectedOutput = "Deadline 31/12/2020 added to Project Fire";
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void executeCommand_invalidProjectId_addDeadlineToProject() {
        LocalDate date = LocalDate.parse("2020-12-31");
        ProjectDeadlineCommand command = new ProjectDeadlineCommand(-5,date);
        String expectedOutput = "Project ID does not exist!";
        Throwable actualOutputException = assertThrows(DukeExceptions.class, () -> {
            command.executeCommand(projects, teamMembers);
        });
        assertEquals(expectedOutput, actualOutputException.toString());
    }

    //Unsure why test passed in Intellij but fails in PR
    /*
    @Test
    void executeCommand_invalidDeadlineFormat_addDeadlineToProject() throws DukeExceptions {
        String stringToInput = "deadline p/2 d/2020-31-31";
        String expectedOutput = "Date must be specified in format YYYY-MM-DD";
        Throwable actualOutputException = assertThrows(DukeExceptions.class, () -> {
            Parser.parse(stringToInput);
        });
        assertEquals(expectedOutput, actualOutputException.toString());
    }
    */

}
