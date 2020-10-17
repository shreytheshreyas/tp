package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectSelectCommandTest {
    static ArrayList<Project> projects;
    static Ui ui = new Ui();

    @BeforeAll
    static void testSetup() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        Project projectTwo = new Project("Project Two");
        Project projectThree = new Project("Project Three");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
        projectTwo.addDescription("Do CS2113 Tutorial by today");
    }

    // add deadline to test after it has been implemented
    @Test
    void executeCommand_validProjectIDWithDescription_additionalInformation() {
        ProjectSelectCommand selectProject = new ProjectSelectCommand(1);
        String expectedOutput =  "Do CS2113 Tutorial by today | <project deadline empty>";
        String actualOutput = selectProject.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_invalidProjectIDWithDescription_additionalInformation() {
        ProjectSelectCommand selectProject = new ProjectSelectCommand(-5);
        String expectedOutput =  "Project ID does not exist!";
        String actualOutput = selectProject.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }
}
