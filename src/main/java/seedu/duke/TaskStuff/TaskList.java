package seedu.duke.TaskStuff;

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
        try {
            System.out.println("Selected Task: " + getTaskDescription(taskIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an ERROR in TASKLIST!!");
        }
    }

    public Task getTask(int taskIndex) {
        return this.getTaskList().get(taskIndex);
    }

    public String getTaskDescription(int taskIndex) {
        return getTask(taskIndex).getDescription();
    }

    public void deleteTask(int taskIndex) {
        try {
            String taskDescription = getTaskDescription(taskIndex);
            this.getTaskList().remove(taskIndex);
            System.out.println("Task \"" + taskDescription + "\" removed!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an ERROR in TASKLIST!!");
        }
    }

}