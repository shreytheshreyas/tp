package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

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
        TaskCommand createTask = new TaskCommand("task1", 2);
        createTask.executeCommand(projects);
        Project correctProject = projects.getProjectList().get(2);
        Task newTask = new Task("task1");
        assertEquals(newTask, correctProject.getTasks().get(0));
    }
}