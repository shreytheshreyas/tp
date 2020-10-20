package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ProjectDeadlineCommand extends Command {
    private int projectIndex;
    private LocalDate date;

    public ProjectDeadlineCommand(int projectIndex, LocalDate date) {
        this.projectIndex = projectIndex;
        this.date = date;
    }

    public String executeCommand(ArrayList<Project> projects) throws DukeExceptions {
        try {
            Project project = projects.get(projectIndex);
            project.addProjectDeadline(date);
            return Ui.printProjectDeadlineAddedMessage(project, date);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidProjectID");
        }
    }

    public Boolean isExit() {
        return false;
    }

}
