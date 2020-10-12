package seedu.duke;

/**
 * Prints a list of existing tasks.
 */
public class ProjectListCommand extends Command {

    public void executeCommand(ProjectList projects) {
        if (projects.getProjectList().size() == 0) {
            System.out.println("Project list is empty!!");
        } else {
            System.out.println("List of Projects:");
            for (int i = 0; i < projects.getProjectList().size(); i++) {
                System.out.println("     " + (i + 1) + "." + projects.getProjectList().get(i));
            }
        }
    }

    public Boolean isExit() {
        return false;
    }
}

