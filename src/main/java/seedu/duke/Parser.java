package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.HomeCommand;
import seedu.duke.commands.member.TeamMemberAddCommand;
import seedu.duke.commands.member.TeamMemberAssignToTaskCommand;
import seedu.duke.commands.member.TeamMemberDeleteCommand;
import seedu.duke.commands.member.TeamMembersListCommand;
import seedu.duke.commands.project.ProjectDeleteCommand;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.project.ProjectListCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.commands.task.DeadlineCommand;
import seedu.duke.commands.task.TaskListCommand;
import seedu.duke.commands.task.TaskSelectCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskDeleteCommand;
import seedu.duke.commands.task.TaskAssignPriorityCommand;

import seedu.duke.ui.Ui;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String INPUT_COMMAND_BYE = "bye";
    private static int projectIndex = -1;
    private static int taskIndex = -1;

    /**
     * Parses user input into project command for execution.
     *
     * @param inputCommand Full user input command string
     * @return Command object corresponding to the input command of the user
     */
    public static Command parse(String inputCommand) throws DukeExceptions {
        Command commandType;
        if (inputCommand.equals(INPUT_COMMAND_BYE)) {
            commandType = new ExitCommand();
        } else {
            commandType = checkAction(inputCommand); //----------ADD TRY CATCH (EXCEPTION)
        }
        return commandType;
    }

    public static void setProjectIndex(int newIndex) {
        projectIndex = newIndex;
    }

    public static int extractIndex(String index)  {
        return Integer.parseInt(index) - 1;
    }

    public static HashMap<String, String> getParams(String paramsString) {
        HashMap<String, String> inputParams = new HashMap<>();
        Pattern p = Pattern.compile(".\\/.+?(?=\\s.\\/.+)|.\\/.+");
        String test = paramsString;
        Matcher m = p.matcher(test);
        while (m.find()) {
            String[] keyAndValue = m.group().split("/");
            String paramType = keyAndValue[0];
            String paramValue = keyAndValue[1];
            inputParams.put(paramType, paramValue);
        }
        return inputParams;
    }

    public static String getHashValue(HashMap<String, String> hashmap, String key) throws DukeExceptions {
        if (!hashmap.containsKey(key)) {
            throw new DukeExceptions("default");
        } else {
            return hashmap.get(key);
        }
    }

    public static Command getRemoveTeamMemberCommand(HashMap<String, String> params) throws DukeExceptions {
        Command commandType;
        try {
            int memberIndex = extractIndex(getHashValue(params, "m"));
            commandType = new TeamMemberDeleteCommand(memberIndex);
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }
        return commandType;
    }

    public static Command getAddMemberCommand(HashMap<String, String> params) throws DukeExceptions {
        Command commandType;
        String memberName = getHashValue(params, "m");
        commandType = new TeamMemberAddCommand(memberName);
        return commandType;
    }

    public static Command getDeadlineCommand(HashMap<String, String> params, boolean isProjectView)
            throws DukeExceptions {
        Command commandType = null;

        try {
            if (!isProjectView) {
                int taskIndex = extractIndex(getHashValue(params, "t"));
                LocalDate date = LocalDate.parse(getHashValue(params, "d"));
                commandType = new DeadlineCommand(projectIndex, taskIndex, date);
            } else {
                throw new DukeExceptions("default");
            }
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            Ui.printOutput("Date must be specified in format YYYY-MM-DD");
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }

        return commandType;
    }

    public static Command getDescriptionCommand(HashMap<String, String> params, boolean isProjectListView)
            throws DukeExceptions {
        Command commandType;
        String description;
        if (isProjectListView) {
            throw new DukeExceptions("default"); // replace with exception
        } else {
            description = params.get("d");
            commandType = new ProjectDescriptionCommand(description, projectIndex);
        }
        return commandType;
    }

    public static Command getListCommandType(boolean isProjectListView) {
        return isProjectListView ? new ProjectListCommand() : new TaskListCommand(projectIndex);
    }

    /**
     * Parses user input related to tasks into command for execution.
     *
     * @param inputCommand Full user input command string
     * @return Command object corresponding to the input command of the user
     */
    public static Command checkAction(String inputCommand) throws DukeExceptions {
        Command commandType = null;
        String[] inputs = inputCommand.split("\\s+", 2);
        String taskType = inputs[0];

        HashMap<String, String> params = new HashMap<>();
        if (inputs.length == 2) {
            String paramsString = inputs[1];
            params = getParams(paramsString);
        }

        boolean isHomeView = (projectIndex == -1); //In main project list view

        switch (taskType) {
        case "list":
            commandType = getListCommandType(isHomeView);
            break;
        case "select":
            commandType = (isHomeView)
                    ? new ProjectSelectCommand(params) : new TaskSelectCommand(params, projectIndex);
            break;
        case "description":
            commandType = getDescriptionCommand(params, isHomeView);
            break;
        case "project":
            if (!isHomeView) {
                throw new DukeExceptions("mustBeInHomeView");
            }
            commandType = new ProjectCommand(params);
            break;
        case "task":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            commandType = new TaskCommand(params, projectIndex);
            break;
        case "deadline":
            commandType = getDeadlineCommand(params, isHomeView);
            break;
        case "delete":
            commandType = (isHomeView)
                    ? new ProjectDeleteCommand(params) : new TaskDeleteCommand(params, projectIndex);
            break;
        case "home":
            commandType = new HomeCommand(projectIndex);
            break;
        case "member":
            commandType = getAddMemberCommand(params);
            break;
        case "members":
            commandType = new TeamMembersListCommand();
            break;
        case "remove":
            commandType = getRemoveTeamMemberCommand(params);
            break;
        case "assign":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            commandType = new TeamMemberAssignToTaskCommand(params, projectIndex);
            break;
        case "priority":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            commandType = new TaskAssignPriorityCommand(params, projectIndex);
            break;
        default:
            break;
        }
        return commandType;
    }

}


