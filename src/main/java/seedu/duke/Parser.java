package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.PrintHomeViewCommand;
import seedu.duke.commands.HomeCommand;
import seedu.duke.commands.member.AssignMemberToProjectCommand;
import seedu.duke.commands.member.TeamMemberAddCommand;
import seedu.duke.commands.member.TeamMemberAssignToTaskCommand;
import seedu.duke.commands.member.TeamMemberDeleteCommand;
import seedu.duke.commands.member.TeamMemberHoursCommand;
import seedu.duke.commands.project.ProjectDeadlineCommand;
import seedu.duke.commands.project.ProjectDescriptionCommand;
import seedu.duke.commands.project.ProjectDeleteCommand;
import seedu.duke.commands.project.ProjectCommand;
import seedu.duke.commands.project.ProjectSelectCommand;
import seedu.duke.commands.project.ProjectDoneCommand;
import seedu.duke.commands.task.TaskAssignPriorityCommand;
import seedu.duke.commands.task.TaskDeleteCommand;
import seedu.duke.commands.task.TaskListCommand;
import seedu.duke.commands.task.TaskSelectCommand;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskDoneCommand;
import seedu.duke.commands.task.TaskAssignDeadlineCommand;
import seedu.duke.commands.task.TaskDeleteCommand;
import seedu.duke.commands.task.TaskAssignPriorityCommand;
import seedu.duke.commands.task.TaskEditCommand;
import seedu.duke.commands.task.ActualTimeCommand;
import seedu.duke.commands.task.EstimatedTimeCommand;
import seedu.duke.ui.Ui;
import seedu.duke.commands.task.TaskCommand;
import seedu.duke.commands.task.TaskSortCommand;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static int projectIndex = -1;


    public static void setProjectIndex(int newIndex) {
        projectIndex = newIndex;
    }

    public static int getProjectIndex() {
        return projectIndex;
    }

    public static HashMap<String, String> getParams(String paramsString) {
        HashMap<String, String> inputParams = new HashMap<>();
        Pattern p = Pattern.compile(".\\/.+?(?=\\s.\\/.+)|.\\/.+"); //Regex to extract parameter terms
        Matcher m = p.matcher(paramsString);
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


    /**
     * Parses user input into project command for execution.
     *
     * @param inputCommand Full user input command string
     * @return Command object corresponding to the input command of the user
     */
    public static Command parse(String inputCommand) throws DukeExceptions {
        String[] inputWords = inputCommand.split("\\s+", 2); //Splits command into type and parameters
        String commandType = inputWords[0];

        HashMap<String, String> params = new HashMap<>();
        if (inputWords.length == 2) {
            params = getParams(inputWords[1]);
        }

        boolean isHomeView = (projectIndex == -1); //In main project list view

        Command command = getCommand(isHomeView, commandType, params, projectIndex);
        return command;
    }

    public static Command getCommand(boolean isHomeView, String commandType, HashMap<String, String> params,
                                     int projectIndex) throws DukeExceptions {
        Command command;

        switch (commandType) {
        case "list":
            command = (isHomeView)
                    ? new PrintHomeViewCommand() : new TaskListCommand(projectIndex);
            break;
        case "select":
            if (!isHomeView) {
                throw new DukeExceptions("mustBeInHomeView");
            }
            command = new ProjectSelectCommand(params);
            break;
        case "description":
            if (!isHomeView) {
                throw new DukeExceptions("mustBeInHomeView");
            }
            command = new ProjectDescriptionCommand(params);
            break;
        case "project":
            if (!isHomeView) {
                throw new DukeExceptions("mustBeInHomeView");
            }
            command = new ProjectCommand(params);
            break;
        case "task":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            command = new TaskCommand(params, projectIndex);
            break;
        case "edit":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            command = new TaskEditCommand(params, projectIndex);
            break;
        case "done":
            command = (isHomeView)
                    ? new ProjectDoneCommand(params, projectIndex) : new TaskDoneCommand(params, projectIndex);
            break;
        case "deadline":
            command = (isHomeView)
                    ? new ProjectDeadlineCommand(params) : new TaskAssignDeadlineCommand(params, projectIndex);
            break;
        case "delete":
            command = (isHomeView)
                    ? new ProjectDeleteCommand(params) : new TaskDeleteCommand(params, projectIndex);
            break;
        case "actual":
            command = new ActualTimeCommand(params, projectIndex);
            break;
        case "estimate":
            command = new EstimatedTimeCommand(params, projectIndex);
            break;
        case "home":
            command = new HomeCommand(projectIndex);
            break;
        case "member":
            command = new TeamMemberAddCommand(params);
            break;
        case "remove":
            command = new TeamMemberDeleteCommand(params);
            break;
        case "assign":
            command = (isHomeView)
                    ? new AssignMemberToProjectCommand(params, isHomeView)
                    : new TeamMemberAssignToTaskCommand(params, projectIndex);
            break;
        case "priority":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            command = new TaskAssignPriorityCommand(params, projectIndex);
            break;
        case "bye":
            command = new ExitCommand();
            break;
        case "sort":
            if (isHomeView) {
                throw new DukeExceptions("mustBeInProjectView");
            }
            command = new TaskSortCommand(params, projectIndex);
            break;
        case "hours":
            command = new TeamMemberHoursCommand(params, projectIndex);
            break;
        default:
            throw new DukeExceptions("default");
        }

        return command;
    }



}


