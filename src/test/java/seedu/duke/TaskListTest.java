package seedu.duke;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void createTasks_emptyAndExistingList_updatedList() {
        TaskList taskList = new TaskList();
        taskList.createTask("task1","today");
        taskList.createTask("task2","tomorrow");

        ArrayList<Task> tasks = new ArrayList<>();
        Task task1 = new Task("task1", "today");
        Task task2 = new Task("task2", "tomorrow");
        tasks.add(task1);
        tasks.add(task2);
        assertEquals(tasks, taskList.getTaskList());
    }
}