package seedu.duke.commands.task;

import org.junit.jupiter.api.Test;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListCommandTest {

    /**
    @Test
    void executeCommand() {
        //Setup test project with existing tasks
        ProjectList projects = new ProjectList();
        projects.createProject("iPhone App");
        projects.createProject("Android App");
        int secondProjectIndex = 1;
        Project android = projects.getProjectList().get(secondProjectIndex);
        android.createTask("network features", LocalDate.parse("2020-08-24"));
        android.createTask("keyboard features", LocalDate.parse("2020-10-24"));

        //Expected Output
        String expectedOutput = "List of Tasks:"
                + "\n     " + "1" + "." + "network features | 24/08/2020"
                + "\n     " + "2" + "." + "keyboard features | 24/10/2020";
        TaskListCommand taskListCommand = new TaskListCommand(1);
        String actualOutput = taskListCommand.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }
    **/
}