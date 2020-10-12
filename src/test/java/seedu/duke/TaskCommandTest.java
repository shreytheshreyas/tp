package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        Task newTask = new Task ("task1");
        assertEquals(correctProject.getTasks().get(0), newTask);
    }
}