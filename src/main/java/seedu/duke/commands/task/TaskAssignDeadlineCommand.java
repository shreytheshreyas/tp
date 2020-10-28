package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskAssignDeadlineCommand extends Command {
    private int projectIndex;
    private int taskIndex;
    private LocalDate date;
    HashMap<String, String> params;

    public TaskAssignDeadlineCommand(HashMap<String, String> params, int projectIndex) throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            date = LocalDate.parse(getHashValue(params, "d"));
        } catch (NumberFormatException e) {
            throw new DukeExceptions("invalidTaskID");
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            throw new DukeExceptions("WrongDateFormat");
        }
    }

    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        try {
            Project project = projects.get(projectIndex);
            Task task = project.getTaskList().get(taskIndex);
            task.addDeadline(date);
            return "Deadline " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + " added to Task " + task.getDescription();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public Boolean isExit() {
        return false;
    }
}
