package seedu.duke;

public class SelectCommand extends Command {

    private String currentInput;

    public SelectCommand(String currentInput) {
        this.currentInput = currentInput;
    }

    public void executeCommand(ProjectList projects) {
        try {
            selectProject(currentInput, projects);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            if (projects.getProjectList().size() == 0) {
                System.out.println("I am empty!!!");
            } else {
                System.out.println("Invalid project ID");
            }
        }
    }

    private void selectProject(String currentInput, ProjectList projects) {
        int itemIndex = Integer.parseInt(currentInput.split(" ")[1]) - 1;
        System.out.println(projects.getProjectList().get(itemIndex));
    }

    public Boolean isExit() {
        return false;
    }

}
