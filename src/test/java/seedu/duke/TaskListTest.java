package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {

    /**
    @Test
    void createTasks_emptyAndExistingList_updatedList() {
        TaskList taskList = new TaskList();
        taskList.createTask("task1", LocalDate.parse("2020-08-24"));
        taskList.createTask("task2", LocalDate.parse("2020-10-24"));

        ArrayList<Task> tasks = new ArrayList<>();
        Task task1 = new Task("task1", LocalDate.parse("2020-08-24"));
        Task task2 = new Task("task2", LocalDate.parse("2020-10-24"));
        tasks.add(task1);
        tasks.add(task2);
        assertEquals(tasks, taskList.getTaskList());
    }

    @Test
    void createTasks_existingList_correctOutput() {
        TaskList taskList = new TaskList();
        taskList.createTask("task1", LocalDate.parse("2020-08-24"));
        String output = taskList.createTask("task2", LocalDate.parse("2020-10-24"));
        assertEquals("Created: task2 | 24/10/2020", output);
    }
    **/
}