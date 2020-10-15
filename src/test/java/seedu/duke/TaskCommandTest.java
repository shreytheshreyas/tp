package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCommandTest {
    static ProjectList projects;

    @BeforeAll
    static void createProjectList() {
        projects = new ProjectList();
        projects.createProject("project1");
        projects.createProject("project2");
        projects.createProject("project3");
    }

    @Test
    void executeCommand_projectList_taskCreated() {
        TaskCommand createTask = new TaskCommand("task1", 2, LocalDate.parse("2020-08-24"));
        createTask.executeCommand(projects);
        Project correctProject = projects.getProjectList().get(2);
        Task newTask = new Task("task1", LocalDate.parse("2020-08-24"));
        assertEquals(newTask, correctProject.getTasks().get(0));
    }

    @Test
    void executeCommand_projectList_correctOutput() {
        TaskCommand createTask = new TaskCommand("task1", 2, LocalDate.parse("2020-08-24"));
        String output = createTask.executeCommand(projects);
        assertEquals("Created: task1 | 24/08/2020", output);
    }
}