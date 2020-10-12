package seedu.duke.commands;

import seedu.duke.projectStuff.ProjectList;

/**
 * Represents an executable command.
 */
public abstract class Command {

    public abstract void executeCommand(ProjectList projects);

    /**
     * Returns an exit flag that is determined by user's command.
     * @return Terminate the program if user's command equals 'bye'
     */
    public abstract Boolean isExit();
}
