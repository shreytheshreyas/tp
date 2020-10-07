package seedu.duke;

public class TaskSelectCommandProject extends CommandTask {

    private int itemIndex;

    public TaskSelectCommandProject(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public void executeCommand(TaskList tasks) {
        try {
            tasks.selectTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (tasks.getTaskList().size() == 0) {
                System.out.println("I am empty!!!");
            } else {
                System.out.println("Invalid project ID");
            }
        }
    }

    public Boolean isExit() {
        return false;
    }


}
