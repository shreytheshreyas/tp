package seedu.duke.commands.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProjectSelectCommandTest {
    static ArrayList<TeamMember> teamMembers;
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();

    @BeforeAll
    static void testSetup() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        Project projectTwo = new Project("Project Two");
        Project projectThree = new Project("Project Three");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
        projectTwo.addDescription("Do CS2113 Tutorial by today");
        projectTwo.addProjectDeadline(LocalDate.parse("2020-12-31"));
    }

    @Test
    void executeCommand_validProjectIdWithDescription_additionalInformation() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("p","2");
        ProjectSelectCommand selectProject = new ProjectSelectCommand(params);
<<<<<<< HEAD:src/test/java/seedu/duke/commands/project/ProjectSelectCommandTest.java
        String expectedOutput =  "Do CS2113 Tutorial by today "
                + "| <project deadline empty> "
                + "| <team members involved empty>";
=======
        String expectedOutput =  "Do CS2113 Tutorial by today | 2020-12-31 | team members involved empty";
>>>>>>> a662c703b102739430d8dca4a3521929d158f360:src/test/java/seedu/duke/ProjectSelectCommandTest.java
        String actualOutput = selectProject.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_invalidProjectIdWithDescription_additionalInformation() throws DukeExceptions {
        HashMap<String, String> params = new HashMap<>();
        params.put("p","-5");
        ProjectSelectCommand selectProject = new ProjectSelectCommand(params);
        String expectedOutput = "Project ID does not exist!";
        Throwable actualOutputException = assertThrows(DukeExceptions.class, () -> {
            selectProject.executeCommand(projects, teamMembers);
        });
        assertEquals(expectedOutput, actualOutputException.toString());
    }
}
