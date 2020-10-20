package seedu.duke.commands.project;

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
        Project projectOne = new Project("Project One");
        Project projectTwo = new Project("Project Two");
        Project projectThree = new Project("Project Three");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
        projectTwo.addDescription("Do CS2113 Tutorial by today");
    }

    @Test
    void executeCommand_projectList_projectDescriptionAdded() {
        ProjectDescriptionCommand addDescription = new ProjectDescriptionCommand("Do CS2113 Tutorial by today", 1);
        String actualOutput = addDescription.executeCommand(projects);
        String expectedOutput = "Project description added \"Do CS2113 Tutorial by today\".";
        assertEquals(expectedOutput, actualOutput);
    }


}
