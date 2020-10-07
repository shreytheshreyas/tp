package seedu.duke;

public class SelectCommand extends Command {

    private String currentInput;

    public SelectCommand(String currentInput) {
        this.currentInput = currentInput;
    }

    public void executeCommand(ProjectList projects) {
        try {
            int itemIndex = Integer.parseInt(currentInput.split(" ")[1]) - 1;
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
