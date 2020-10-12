package seedu.duke;

public class TaskSelectCommand extends Command {

    private int itemIndex;
    private int projectIndex;

    public TaskSelectCommand(int itemIndex, int projectIndex) {
        this.itemIndex = itemIndex;
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        try {
            projects.getProject(projectIndex).getTaskList().selectTask(itemIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
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
