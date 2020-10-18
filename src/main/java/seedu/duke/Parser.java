package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.member.AddTeamMemberCommand;
import seedu.duke.commands.member.DeleteTeamMemberCommand;
import seedu.duke.commands.member.ListTeamMembersCommand;
import seedu.duke.commands.project.DeleteProjectCommand;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.project.ProjectListCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskDeleteCommand;
import seedu.duke.commands.task.TaskListCommand;
import seedu.duke.commands.task.TaskSelectCommand;
import seedu.duke.commands.task.DeadlineCommand;    
import seedu.duke.ui.Ui;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String INPUT_COMMAND_BYE = "bye";
    private static final String INPUT_COMMAND_LIST = "list";
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

    static void setProjectIndex(int newIndex) {
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
            commandType = new DeleteTeamMemberCommand(memberIndex);
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }
        return commandType;
    }

    public static Command getAddMemberCommand(HashMap<String, String> params) throws DukeExceptions {
        Command commandType;
        String memberName = getHashValue(params, "m");
        commandType = new AddTeamMemberCommand(memberName);
        return commandType;
    }

    public static void switchViewModes(boolean isProjectListView) throws DukeExceptions {
        if (!isProjectListView) {
            System.out.println("Switched to Project View!");
            projectIndex = -1;
        } else {
            throw new DukeExceptions("Switch"); // REPLACED WITH EXCEPTION
        }

    }

    public static Command getDeleteCommand(HashMap<String, String> params, boolean isProjectListView)
            throws DukeExceptions {
        Command commandType;
        try {
            if (isProjectListView) {
                projectIndex = extractIndex(getHashValue(params, "p"));
                commandType = new DeleteProjectCommand(projectIndex);
                projectIndex = -1;
            } else {
                taskIndex = extractIndex(getHashValue(params, "t"));
                commandType = new TaskDeleteCommand(taskIndex, projectIndex);
            }
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }
        return commandType;
    }

    public static Command getDeadlineCommand(HashMap<String, String> params, boolean isProjectView)
            throws DukeExceptions {
        Command commandType;

        try {
            if (!isProjectView) {
                int taskIndex = extractIndex(getHashValue(params, "t"));
                LocalDate date = LocalDate.parse(getHashValue(params, "d"));
                commandType = new DeadlineCommand(projectIndex, taskIndex, date);
            } else {
                throw new DukeExceptions("default");
            }

        } catch (NullPointerException e) {
            throw new DukeExceptions("WrongDateFormat");
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeExceptions("WrongDateFormat");
        } catch (DateTimeParseException e) {
            throw new DukeExceptions("WrongDateFormat");
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }

        return commandType;
    }

    public static Command getTaskCommand(HashMap<String, String> params, boolean isProjectListView)
            throws DukeExceptions {
        Command commandType;
        String taskDescription;
        if (!isProjectListView) {
            taskDescription = getHashValue(params, "n");
            commandType = new TaskCommand(taskDescription, projectIndex);
        } else {
            throw new DukeExceptions("default");
        }
        return commandType;
    }

    public static Command getProjectCommand(HashMap<String, String> params, boolean isProjectListView)
            throws DukeExceptions {
        Command commandType;
        String description;
        if (isProjectListView) {
            description = getHashValue(params, "n");
            commandType = new ProjectCommand(description);
        } else {
            throw new DukeExceptions("Add Task"); // REPLACED WITH EXCEPTION // change key descriptions
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

    public static Command getSelectCommand(HashMap<String, String> params, boolean isProjectListView)
            throws DukeExceptions {
        Command commandType;
        try {
            if (isProjectListView) {
                projectIndex = extractIndex(getHashValue(params, "p"));
                commandType = new ProjectSelectCommand(projectIndex);
            } else {
                taskIndex = extractIndex(getHashValue(params, "t"));
                commandType = new TaskSelectCommand(taskIndex, projectIndex);
            }
            return commandType;
        } catch (NumberFormatException e) {
            throw new DukeExceptions("IndexNotFound");
        }
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
        boolean isProjectListView = (projectIndex == -1); //In main project list view

        switch (taskType) {
        case "list":
            commandType = getListCommandType(isProjectListView);
            break;
        case "select":
            commandType = getSelectCommand(params, isProjectListView);
            break;
        case "description":
            commandType = getDescriptionCommand(params, isProjectListView);
            break;
        case "project":
            commandType = getProjectCommand(params, isProjectListView);
            break;
        case "task":
            commandType = getTaskCommand(params, isProjectListView);
            break;
        case "deadline":
            commandType = getDeadlineCommand(params, isProjectListView);
            break;
        case "delete":
            commandType = getDeleteCommand(params, isProjectListView);
            break;
        case "switch":
            switchViewModes(isProjectListView);
            break;
        case "member":
            commandType = getAddMemberCommand(params);
            break;
        case "members":
            commandType = new ListTeamMembersCommand();
            break;
        case "remove":
            commandType = getRemoveTeamMemberCommand(params);
            break;
        default:
            break;
        }
        return commandType;
    }




}


