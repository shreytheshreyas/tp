package seedu.duke.task;

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

    public String createTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        return "Task \"" + description + "\" created!!";
    }

    public String selectTask(int taskIndex) {
        try {
            return "Selected Task: " + getTaskDescription(taskIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "There is an ERROR in TASKLIST!!";
        }
    }

    public Task getTask(int taskIndex) {
        return this.getTaskList().get(taskIndex);
    }

    public String getTaskDescription(int taskIndex) {
        return getTask(taskIndex).getDescription();
    }

    public String deleteTask(int taskIndex) {
        try {
            String taskDescription = getTaskDescription(taskIndex);
            this.getTaskList().remove(taskIndex);
            return "Task \"" + taskDescription + "\" removed!!";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "There is an ERROR in TASKLIST!!";
        }
    }

}