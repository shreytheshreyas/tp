package seedu.duke.commands.project;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ProjectDeadlineCommand extends Command {
    private String projectIdInput;
    private String dateString;

    public ProjectDeadlineCommand(String projectIdInput, String dateString) {
        this.projectIdInput = projectIdInput;
        this.dateString = dateString;
    }

    public String executeCommand(ArrayList<Project> projects) {
        try {
            int projectId = Integer.parseInt(projectIdInput) - 1;
            LocalDate date = LocalDate.parse(dateString);
            Project project = projects.get(projectId);
            project.addProjectDeadline(date);
            return "Deadline " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + " added to Project " + project.getProjectName();
        } catch (NullPointerException | StringIndexOutOfBoundsException | DateTimeParseException e) {
            return "Date must be specified in format YYYY-MM-DD";
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Project ID not specified";
        }
    }

    public Boolean isExit() {
        return false;
    }

}
