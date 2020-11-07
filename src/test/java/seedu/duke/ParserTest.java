package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.HomeCommand;
import seedu.duke.commands.PrintHomeViewCommand;
import seedu.duke.commands.member.AssignMemberToProjectCommand;
import seedu.duke.commands.member.TeamMemberAddCommand;
import seedu.duke.commands.member.TeamMemberAssignToTaskCommand;
import seedu.duke.commands.member.TeamMemberDeleteCommand;
import seedu.duke.commands.member.TeamMemberHoursCommand;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectDeadlineCommand;
import seedu.duke.commands.project.ProjectDeleteCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.project.ProjectDoneCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.commands.task.ActualTimeCommand;
import seedu.duke.commands.task.EstimatedTimeCommand;
import seedu.duke.commands.task.TaskAssignDeadlineCommand;
import seedu.duke.commands.task.TaskAssignPriorityCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskDeleteCommand;
import seedu.duke.commands.task.TaskDoneCommand;
import seedu.duke.commands.task.TaskEditCommand;
import seedu.duke.commands.task.TaskListCommand;
import seedu.duke.commands.task.TaskSortCommand;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
    @Test
    void getParams_correctTaskParams_correctHashmap() throws DukeExceptions {
        String paramString = "n/new Named Task d/2020-08-04 t/109 p/121 h/12 m/56";
        HashMap<String, String> expectedHashmap = new HashMap<>();
        expectedHashmap.put("n", "new Named Task");
        expectedHashmap.put("p", "121");
        expectedHashmap.put("d", "2020-08-04");
        expectedHashmap.put("t", "109");
        expectedHashmap.put("h", "12");
        expectedHashmap.put("m", "56");
        HashMap<String, String> actualHashmap = Parser.getParams(paramString);
        assertEquals(expectedHashmap, actualHashmap);
    }

    @Test
    void getParams_slashInParameters_slashException() {
        String paramString = "n//// d//";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.getParams(paramString));
        String expectedOutput = "Parameters should not contain slashes!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void getParams_excessSlashInParameters_slashException() {
        String paramString = "t/1/2";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.getParams(paramString));
        String expectedOutput = "Parameters should not contain slashes!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void getParams_duplicateParams_duplicateParamsException() {
        String paramString = "n/3 n/5";
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.getParams(paramString));
        String expectedOutput = "Duplicate Parameters detected!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void getHashValue_missingParam_missingParamsException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("t", "3");
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.getHashValue(params, "d")); //Missing description
        String expectedOutput = "Certain Parameters are missing!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_listCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "list";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof PrintHomeViewCommand);
    }

    @Test
    void parse_listCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "list";
        Parser.setProjectIndex(1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskListCommand);
    }

    @Test
    void parse_selectCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "select p/1";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectSelectCommand);
    }

    @Test
    void parse_selectCommandProjectView_HomeViewException() {
        String inputCommand = "select p/1";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Home View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_descriptionCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "description p/1 d/This is a test.";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectDescriptionCommand);
    }

    @Test
    void parse_descriptionCommandProjectView_HomeViewException() {
        String inputCommand = "description p/1 d/Test";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Home View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_projectCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "project n/New Project";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectCommand);
    }

    @Test
    void parse_projectCommandProjectView_HomeViewException() {
        String inputCommand = "project n/New Project";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Home View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_taskCommandHomeView_ProjectViewException() {
        String inputCommand = "task n/New Task";
        Parser.setProjectIndex(-1);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Project View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_TaskCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "task n/New Task";
        Parser.setProjectIndex(2);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskCommand);
    }

    @Test
    void parse_EditCommandHomeView_ProjectViewException() {
        String inputCommand = "edit t/3 n/New Project";
        Parser.setProjectIndex(-1);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Project View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_EditCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "edit t/3 n/New Project";
        Parser.setProjectIndex(2);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskEditCommand);
    }

    @Test
    void parse_DoneCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "done p/3";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectDoneCommand);
    }

    @Test
    void parse_DoneCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "done t/3";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskDoneCommand);
    }

    @Test
    void parse_DeadlineCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "deadline p/2 d/2020-08-04";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectDeadlineCommand);
    }

    @Test
    void parse_DeadlineCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "deadline t/3 d/2020-08-04";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskAssignDeadlineCommand);
    }

    @Test
    void parse_DeleteCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "delete p/3";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ProjectDeleteCommand);
    }

    @Test
    void parse_DeleteCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "delete t/3";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskDeleteCommand);
    }

    @Test
    void parse_ActualCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "actual t/3 h/7 m/32";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ActualTimeCommand);
    }

    @Test
    void parse_EstimateCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "estimate t/3 h/5 m/32";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof EstimatedTimeCommand);
    }

    @Test
    void parse_HomeCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "home";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof HomeCommand);
    }


    @Test
    void parse_MemberCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "member n/New Member";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TeamMemberAddCommand);
    }

    @Test
    void parse_memberCommandProjectView_HomeViewException() {
        String inputCommand = "member n/New Member";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Home View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_removeCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "remove m/3";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TeamMemberDeleteCommand);
    }

    @Test
    void parse_removeCommandProjectView_HomeViewException() throws DukeExceptions {
        String inputCommand = "remove m/3";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Home View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_assignCommandHomeView_correctCommand() throws DukeExceptions {
        String inputCommand = "assign p/1 m/3";
        Parser.setProjectIndex(-1);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof AssignMemberToProjectCommand);
    }

    @Test
    void parse_assignCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "assign t/3 m/3";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TeamMemberAssignToTaskCommand);
    }


    @Test
    void parse_priorityCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "priority t/3 p/2";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskAssignPriorityCommand);
    }

    @Test
    void parse_priorityCommandHomeView_ProjectViewException() {
        String inputCommand = "priority t/3 p/2";
        Parser.setProjectIndex(-1);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Project View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_byeCommand_correctCommand() throws DukeExceptions {
        String inputCommand = "bye";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof ExitCommand);
    }

    @Test
    void parse_sortCommandHomeView_ProjectViewException() {
        String inputCommand = "sort s/p";
        Parser.setProjectIndex(-1);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "You must be in Project View to do that!";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_sortCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "sort s/p";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TaskSortCommand);
    }

    @Test
    void parse_hoursCommandProjectView_correctCommand() throws DukeExceptions {
        String inputCommand = "hours m/2";
        Parser.setProjectIndex(3);
        Command actualCommand = Parser.parse(inputCommand);
        assertTrue(actualCommand instanceof TeamMemberHoursCommand);
    }

    @Test
    void parse_unrecognisedCommand_unrecognisedException() {
        String inputCommand = "blah p/3";
        Parser.setProjectIndex(-1);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "OOPS!!! I'm sorry, but I don't know what that command means :-(";
        assertEquals(expectedOutput, exception.toString());
    }

    @Test
    void parse_missingParametersPriority_missingParamsException() {
        String inputCommand = "priority t/1";
        Parser.setProjectIndex(3);
        DukeExceptions exception = assertThrows(DukeExceptions.class, () ->
                Parser.parse(inputCommand));
        String expectedOutput = "Certain Parameters are missing!";
        assertEquals(expectedOutput, exception.toString());
    }
}