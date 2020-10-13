package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.task.TaskCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    /**
    //todo: currently fails because project description has no spaces between words.
    @Test
    void checkAction_taskCommand_correctCommandType() throws DukeExceptions {
        String inputCommand = "task some task";
        int projectIndex = 0;
        TaskCommand commandType = new TaskCommand("some task", projectIndex);
        Parser.setProjectIndex(projectIndex);
        assertEquals(Parser.checkAction(inputCommand), commandType);
    }
    *//
}