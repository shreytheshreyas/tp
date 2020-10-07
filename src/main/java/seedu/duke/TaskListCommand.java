package seedu.duke;

/**
 * Prints a list of existing tasks.
 */
public class TaskListCommand extends Command {
    private int projectIndex;

    public TaskListCommand(int projectIndex) {
        this.projectIndex = projectIndex;
    }

    public void executeCommand(ProjectList projects) {
        Project project = projects.getProjectList().get(projectIndex);

        if (project.getTasks().size() == 0) {
            System.out.println("I am empty!!");
        } else {
            System.out.println("List of Tasks:");
            for (int i = 0; i < project.getTasks().size(); i++) {
                System.out.println("     " + (i + 1) + "." + project.getTasks().get(i));
            }
        }
    }

    public Boolean isExit() {
        return false;
    }
}
