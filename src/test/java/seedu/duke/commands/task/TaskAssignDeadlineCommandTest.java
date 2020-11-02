package seedu.duke.commands.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TaskAssignDeadlineCommandTest {
    static ArrayList<Project> projects;

    @BeforeAll
    static void createProjectsTasks() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Drink Water");
        projects.add(projectOne);

        Project projectTwo = new Project("Fire");
        Task taskOne = new Task("test1");
        Task taskTwo = new Task("test2");
        projectTwo.addTask(taskOne);
        projectTwo.addTask(taskTwo);
        projects.add(projectTwo);

        Project projectThree = new Project("CS2113 Tutorial");
        projects.add(projectThree);
    }

    @Test
    void executeCommand_correctDateFormat_addDeadline() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("d", "2020-09-12");
        params.put("t", "2");
        TaskAssignDeadlineCommand newCommand = new TaskAssignDeadlineCommand(params, 1);
        String actualOutput = newCommand.executeCommand(projects, new ArrayList<>());
        String expectedOutput = "Deadline 12/09/2020 added to Task test2";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_wrongDateFormat_DateTimeException() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("d", "2020-09-1");
        params.put("t", "2");
        Throwable actualOutputException = assertThrows(DukeExceptions.class,
                () -> new TaskAssignDeadlineCommand(params, 1));
        String expectedOutput = "Date must be specified in format YYYY-MM-DD";
        assertEquals(expectedOutput, actualOutputException.toString());
    }
}