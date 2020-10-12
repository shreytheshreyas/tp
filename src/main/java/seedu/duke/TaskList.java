package seedu.duke;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Creates an empty tasks list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Gets the arraylist that contains existing tasks.
     *
     * @return Arraylist that contains existing tasks.
     */
    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public void createTask(String description) {
        try {
            Task newTask = new Task(description);
            tasks.add(newTask);
            System.out.println("Task \"" + description + "\" created!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an ERROR in TASKLIST!!");
        }
    }

    public void selectTask(int taskIndex) {
        System.out.println(this.getTaskList().get(taskIndex));
    }
}