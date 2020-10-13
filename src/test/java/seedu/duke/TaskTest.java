package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.task.Task;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskTest {

    static Task task;

    @BeforeAll
    static void createTask() {
        task = new Task("task1");
    }

    @Test
    void testToString() {
        assertEquals("task1", task.toString());
    }

    @Test
    void equals_sameTask_true() {
        Task sameTask = new Task("task1");
        assertTrue(sameTask.equals(task));
    }

    @Test
    void equals_diffDescription_false() {
        Task diffTask = new Task("task2");
        assertFalse(diffTask.equals(task));
    }
}