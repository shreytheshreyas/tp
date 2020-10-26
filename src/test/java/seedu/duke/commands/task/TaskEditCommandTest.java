package seedu.duke.commands.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.duke.Parser.getHashValue;

class TaskEditCommandTest {

    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static HashMap<String, String> params;

    /**
     * Create 1 projects list
     * Create 1 project.
     * Create 3 tasks.
     * Add the 3 tasks to that project.
     * Add that project to projects list.
     */
    @BeforeAll
    static void testSetup() {
        params = new HashMap<>();
        teamMembers = new ArrayList<>();
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        Task taskOne = new Task("Task One");
        Task taskTwo = new Task("Task Two");
        Task taskThree = new Task("Task Three");
        projectOne.addTask(taskOne);
        projectOne.addTask(taskTwo);
        projectOne.addTask(taskThree);
        projects.add(projectOne);
    }

    /**
     * Test: Select the first task from the first project.
     */
    @Test
    void executeCommand_validTaskId_taskDescription() throws DukeExceptions {
        params.put("t", "1");
        params.put("n", "Task One Upgraded");
        TaskEditCommand command = new TaskEditCommand(params,0);
        String expectedOutput = Ui.printTaskNameUpdatedMessage("Task One", "Task One Upgraded");
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Input a non-existent task ID to test exception error message.
     */
    @Test
    void executeCommand_nonExistentTaskId_taskDescription() throws DukeExceptions {
        params.put("t", "4");
        params.put("n", "Should Not Print This");
        TaskEditCommand command = new TaskEditCommand(params,0);
        String expectedOutput = "Task ID does not exist!";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                command.executeCommand(projects, teamMembers));
        assertEquals(expectedOutput, exception.toString());
    }

    /**
     * Test: Pass a non existent projects list to test exception error message.
     */
    @Test
    void executeCommand_nonExistentProjectsList_taskDescription() throws DukeExceptions {
        params.put("t", "1");
        params.put("n", "Should Not Print This");
        TaskEditCommand command = new TaskEditCommand(params,0);
        String expectedOutput = "Project list is empty!";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                command.executeCommand(new ArrayList<Project>(), teamMembers));
        assertEquals(expectedOutput, exception.toString());
    }
}