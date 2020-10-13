package seedu.duke.commands.task;

import org.junit.jupiter.api.Test;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListCommandTest {

    @Test
    void executeCommand() {
        //Setup test project with existing tasks
        ProjectList projects = new ProjectList();
        projects.createProject("iPhone App");
        projects.createProject("Android App");
        int testIndex = 1;
        Project iPhone = projects.getProjectList().get(testIndex);
        iPhone.createTask("network features");
        iPhone.createTask("keyboard features");

        //Expected Output
        String expectedOutput = "";
        expectedOutput += "List of Tasks:";
        expectedOutput += "\n     " + "1" + "." + "network features";
        expectedOutput += "\n     " + "2" + "." + "keyboard features";




        TaskListCommand taskListCommand = new TaskListCommand(1);
        String actualOutput = taskListCommand.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }
}