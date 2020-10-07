package seedu.duke;

public class ProjectSelectCommand extends Command {

    private int itemIndex;

    public ProjectSelectCommand(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public void executeCommand(ProjectList projects) {
        try {
            projects.selectProject(itemIndex);
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
