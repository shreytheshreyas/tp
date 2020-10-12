package seedu.duke;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    static Task task;
    @BeforeAll
    static void createTask() {
        task = new Task("task1", "today");
    }

    @Test
    void testToString() {
        assertEquals("task1 | today", task.toString());
    }

    @Test
    void equals_sameTask_true() {
        Task sameTask = new Task("task1", "today");
        assertTrue(sameTask.equals(task));
    }

    @Test
    void equals_diffDeadline_false() {
        Task diffTask = new Task("task1", "tomorrow");
        assertFalse(diffTask.equals(task));
    }

    @Test
    void equals_diffDescription_false() {
        Task diffTask = new Task("task2", "today");
        assertFalse(diffTask.equals(task));
    }
}