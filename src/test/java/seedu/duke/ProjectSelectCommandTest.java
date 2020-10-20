package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void executeCommand_validProjectIdWithDescription_additionalInformation() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("p","2");
        ProjectSelectCommand selectProject = new ProjectSelectCommand(params);
        String expectedOutput =  "Do CS2113 Tutorial by today | <project deadline empty>";
        String actualOutput = selectProject.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_invalidProjectIdWithDescription_additionalInformation() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("p","-5");
        ProjectSelectCommand selectProject = new ProjectSelectCommand(params);
        String expectedOutput = "Project ID does not exist!";
        Throwable actualOutputException = assertThrows(DukeExceptions.class, () -> {
            selectProject.executeCommand(projects);
        });
        assertEquals(expectedOutput, actualOutputException.toString());
    }
}
