package seedu.duke;

/**
 * Displays goodbye message when application is terminated by the user.
 */
public class ExitCommand extends Command {
    public void executeCommand(ProjectList projects) {
        printGoodbyeMessage();
    }

    public Boolean isExit() {
        return true;
    }

    private void printGoodbyeMessage() {
        System.out.println("See you again!");
    }
}
