package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void checkAction_taskCommand_correctCommandType() {
        String inputCommand = "task some task /by some deadline";
        int projectIndex = -1;
        TaskCommand commandType = new TaskCommand("some task", "some deadline", projectIndex);
        assertEquals(Parser.checkAction(inputCommand), commandType);
    }
}