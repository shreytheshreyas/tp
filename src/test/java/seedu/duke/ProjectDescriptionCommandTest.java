package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectDescriptionCommandTest {
    static ProjectList projects;

    @BeforeAll
    static void createProjectList() {
        projects = new ProjectList();
        projects.createProject("project1");
        projects.createProject("project2");
        projects.createProject("project3");
        projects.selectProject(1);
    }

    @Test
    void executeCommand_projectList_descriptionAdded() {
        ProjectDescriptionCommand addDescription = new ProjectDescriptionCommand("project 2 description added", 1);
        addDescription.executeCommand(projects);
        Project actualProject = projects.getProjectList().get(1);
        final String expectedMessage = "project 2 description added";
        assertEquals(expectedMessage, actualProject.getDescription());
    }


}
