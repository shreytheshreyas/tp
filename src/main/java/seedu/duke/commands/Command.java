package seedu.duke.commands;

import seedu.duke.DukeExceptions;
import seedu.duke.project.Project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents an executable command.
 */
public abstract class Command {

    public abstract String executeCommand(ArrayList<Project> projects) throws DukeExceptions;

    /**
     * Returns an exit flag that is determined by user's command.
     * @return Terminate the program if user's command equals 'bye'
     */

    public abstract Boolean isExit();
}
