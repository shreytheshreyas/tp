package seedu.duke.commands.member;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TeamMemberAssignToTaskCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static HashMap<String, String> params;
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
        TeamMember memberOne = new TeamMember("Arnold");
        TeamMember memberTwo = new TeamMember("Julian");
        TeamMember memberThree = new TeamMember("Victor");
        teamMembers.add(memberOne);
        teamMembers.add(memberTwo);
        teamMembers.add(memberThree);
        projectOne.addTeamMemberToProject(memberOne);
        projectOne.addTeamMemberToProject(memberTwo);
        projectOne.addTeamMemberToProject(memberThree);
    }

    /**
     * Assign member 1 (Arnold) to task 1 (Task One).
     * @throws DukeExceptions exception message
     */
    @Test
    void executeCommand_validTaskIdMemberId_memberAssignedMessage() throws DukeExceptions {
        params.put("t", "1");
        params.put("m", "1");
        TeamMemberAssignToTaskCommand command = new TeamMemberAssignToTaskCommand(params,0);
        String expectedOutput = Ui.printMemberAssignedToTaskMessage("Arnold", "Task One");
        String actualOutput = command.executeCommand(projects, teamMembers);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void executeCommand_nonExistentMemberId_memberAssignedMessage() throws DukeExceptions {
        params.put("t", "1");
        params.put("m", "50");
        TeamMemberAssignToTaskCommand command = new TeamMemberAssignToTaskCommand(params,0);
        String expectedOutput = "Team Member ID does not exist!";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                command.executeCommand(projects, teamMembers));
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void executeCommand_nonExistentTaskId_memberAssignedMessage() throws DukeExceptions {
        params.put("t", "5");
        params.put("m", "1");
        TeamMemberAssignToTaskCommand command = new TeamMemberAssignToTaskCommand(params,0);
        String expectedOutput = "Task ID does not exist!";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                command.executeCommand(projects, teamMembers));
        assertEquals(expectedOutput, exception.toString());
    }

}