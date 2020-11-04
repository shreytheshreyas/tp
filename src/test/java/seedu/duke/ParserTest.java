package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskDoneCommand;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    void getParams_correctTaskParams_correctHashmap() {
        String paramString = "n/new Named Task d/2020-08-04 t/109 p/121 h/12 m/56 p/7";
        HashMap<String, String> expectedHashmap = new HashMap<>();
        expectedHashmap.put("n", "new Named Task");
        expectedHashmap.put("p", "7");
        expectedHashmap.put("d", "2020-08-04");
        expectedHashmap.put("t", "109");
        expectedHashmap.put("h", "12");
        expectedHashmap.put("m", "56");
        HashMap<String, String> actualHashmap = Parser.getParams(paramString);
        assertEquals(expectedHashmap, actualHashmap);
    }
}