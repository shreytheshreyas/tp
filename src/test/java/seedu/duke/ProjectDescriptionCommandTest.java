package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.project.Project;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.ui.Ui;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectDescriptionCommandTest {
    static ArrayList<Project> projects;
    static Ui ui = new Ui();

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        ui.printOutput(new ProjectCommand("project1").executeCommand(projects));
        ui.printOutput(new ProjectCommand("project2").executeCommand(projects));
        ui.printOutput(new ProjectCommand("project3").executeCommand(projects));
        ui.printOutput(new ProjectSelectCommand(1).executeCommand(projects));
    }

    @Test
    void executeCommand_projectList_descriptionAdded() {
        ProjectDescriptionCommand addDescription = new ProjectDescriptionCommand("project 2 description added", 1);
        addDescription.executeCommand(projects);
        Project actualProject = projects.get(1);
        final String expectedMessage = "project 2 description added";
        assertEquals(expectedMessage, actualProject.getDescription());
    }


}
