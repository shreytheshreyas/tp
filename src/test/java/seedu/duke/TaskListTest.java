package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {

    @Test
    void createTasks_emptyAndExistingList_updatedList() {
        TaskList taskList = new TaskList();
        taskList.createTask("task1");
        taskList.createTask("task2");

        ArrayList<Task> tasks = new ArrayList<>();
        Task task1 = new Task("task1");
        Task task2 = new Task("task2");
        tasks.add(task1);
        tasks.add(task2);
        assertEquals(tasks, taskList.getTaskList());
    }

    @Test
    void createTasks_existingList_correctOutput() {
        TaskList taskList = new TaskList();
        taskList.createTask("task1");
        String output = taskList.createTask("task2");
        assertEquals("Task \"" + "task2" + "\" created!!", output);
    }
}