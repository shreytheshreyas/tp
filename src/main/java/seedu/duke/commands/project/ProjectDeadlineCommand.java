package seedu.duke.commands.project;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class ProjectDeadlineCommand extends Command {
    private int projectIndex;
    private LocalDate date;
    HashMap<String, String> params;

    public ProjectDeadlineCommand(HashMap<String, String> params) throws DukeExceptions {
        this.params = params;
        this.parse();
    }

    /**
     * Parse user parameter inputs for execution.
     *
     * @throws DukeExceptions Invalid index when parameter values entered is not an integer.
     * Invalid DateTime format when parameter values entered is not in YYYY-MM-DD format.
     */
    public void parse() throws DukeExceptions {
        try {
            projectIndex = Integer.parseInt(getHashValue(params, "p")) - 1;
            date = LocalDate.parse(getHashValue(params, "d"));
        } catch (NumberFormatException e) {
            throw new DukeExceptions("indexNonInteger");
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            throw new DukeExceptions("WrongDateFormat");
        }
    }

    /**
     * Add deadline to a specified project.
     * Sorts the ArrayList of Projects by deadline.
     * Projects without deadline will be shifted to the back of the list.
     * Prints project deadline added message as well as new home view display.
     *
     * @param projects ArrayList of Projects.
     * @param teamMembers ArrayList of TeamMembers in the program.
     * @return Prints project deadline added message together with new home view display.
     * @throws DukeExceptions Invalid Project ID when parameter values provided is outside
     * the range of the Project list.
     */
    public String executeCommand(ArrayList<Project> projects,
                                 ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        try {
            Project project = projects.get(projectIndex);
            project.addProjectDeadline(date);
            projects = shiftProjectWithNoDeadlineToBackOfList(projects);
            Collections.sort(projects);
            return Ui.printProjectDeadlineAddedMessage(projects, project, date, teamMembers);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidProjectID");
        }
    }

    private ArrayList<Project> shiftProjectWithNoDeadlineToBackOfList(ArrayList<Project> projects) {
        int projectCounter = 0;
        int i = 0;
        while (projectCounter < projects.size()) {
            if (projects.get(i).getProjectDeadline() == null) {
                Project projectWithNullDeadline = projects.get(i);
                projects.remove(i);
                projects.add(projectWithNullDeadline);
            } else {
                i++;
            }
            projectCounter++;
        }
        return projects;
    }

    public Boolean isExit() {
        return false;
    }

}
