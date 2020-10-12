package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void checkAction_taskCommand_correctCommandType() {
        String inputCommand = "task some task";
        int projectIndex = 0;
        TaskCommand commandType = new TaskCommand("some task", projectIndex);
        Parser.setProjectIndex(projectIndex);
        assertEquals(Parser.checkAction(inputCommand), commandType);
    }
}