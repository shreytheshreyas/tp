package seedu.duke.commands.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskDeleteCommandTest {
    static ArrayList<Project> projects;
    static Ui ui = new Ui();

    /**
     * Create 1 projects list
     * Create 1 project.
     * Create 3 tasks.
     * Add the 3 tasks to that project.
     * Add that project to projects list.
     */
    @BeforeAll
    static void testSetup() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        Task taskOne = new Task("Task One");
        Task taskTwo = new Task("Task Two");
        Task taskThree = new Task("Task Three");
        projectOne.createTask(taskOne);
        projectOne.createTask(taskTwo);
        projectOne.createTask(taskThree);
        projects.add(projectOne);
    }

    /**
     * Test: Delete the first task from the first project.
     * Check for message.
     * Check if task has been deleted from task list by checking task list length;
     */
    @Test
    void executeCommand_validTaskId_taskDescription() {
        TaskDeleteCommand command = new TaskDeleteCommand(0,0);
        String expectedOutput0 = "Task \"Task One\" removed!";
        String actualOutput0 = command.executeCommand(projects);
        assertEquals(expectedOutput0, actualOutput0);

        int expectedOutput1 = 2;
        int actualOutput1 = projects.get(0).getNumberTasks();
        assertEquals(expectedOutput1, actualOutput1);
    }

    /**
     * Test: Input a non-existent task ID to test exception error message.
     */
    @Test
    void executeCommand_nonExistentTaskId_taskDescription() {
        TaskDeleteCommand command = new TaskDeleteCommand(4,0);
        String expectedOutput = "Task ID does not exist!";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Pass a non existent projects list to test exception error message.
     */
    @Test
    void executeCommand_nonExistentProjectsList_taskDescription() {
        TaskDeleteCommand command = new TaskDeleteCommand(-2,0);
        String expectedOutput = "Project List is Empty!";
        String actualOutput = command.executeCommand(new ArrayList<Project>());
        assertEquals(expectedOutput, actualOutput);
    }

}