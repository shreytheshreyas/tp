package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectDeadlineCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.task.TaskCommand;
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

public class ProjectDeadlineCommandTest {
    static ArrayList<Project> projects;
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
    void executeCommand_validProjectId_addDeadlineToProject() {
        ProjectDeadlineCommand command = new ProjectDeadlineCommand("2", "2020-12-31");
        String expectedOutput = "Deadline 31/12/2020 added to Project Fire";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Add deadline with invalid project ID and deadline format.
     */
    @Test
    void executeCommand_invalidProjectId_addDeadlineToProject() {
        ProjectDeadlineCommand command = new ProjectDeadlineCommand("-5","2020-12-31");
        String expectedOutput = "Project ID not specified";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Add deadline to the second project with valid project ID but invalid deadline format.
     */
    @Test
    void executeCommand_invalidDeadlineFormat_addDeadlineToProject() {
        ProjectDeadlineCommand command = new ProjectDeadlineCommand("2","2020-31-31");
        String expectedOutput = "Date must be specified in format YYYY-MM-DD";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }


}
