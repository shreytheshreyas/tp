package seedu.duke.commands.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskSelectCommandTest {
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
     * Test: Select the first task from the first project.
     */
    @Test
    void executeCommand_validTaskId_taskDescription() {
        TaskSelectCommand command = new TaskSelectCommand(0,0);
        String expectedOutput = "Selected Task: Task One";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Input a non-existent task ID to test exception error message.
     */
    @Test
    void executeCommand_nonExistentTaskId_taskDescription() {
        TaskSelectCommand command = new TaskSelectCommand(4,0);
        String expectedOutput = "Task ID does not exist!";
        String actualOutput = command.executeCommand(projects);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Test: Pass a non existent projects list to test exception error message.
     */
    @Test
    void executeCommand_nonExistentProjectsList_taskDescription() {
        TaskSelectCommand command = new TaskSelectCommand(-2,0);
        String expectedOutput = "Project List is Empty!";
        String actualOutput = command.executeCommand(new ArrayList<Project>());
        assertEquals(expectedOutput, actualOutput);
    }
}