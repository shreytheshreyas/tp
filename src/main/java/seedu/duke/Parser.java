package seedu.duke;

import seedu.duke.Commands.*;
import seedu.duke.Commands.MemberCommands.AddTeamMemberCommand;
import seedu.duke.Commands.MemberCommands.ListTeamMembersCommand;
import seedu.duke.Commands.ProjectCommands.ProjectCommand;
import seedu.duke.Commands.ProjectCommands.ProjectListCommand;
import seedu.duke.Commands.ProjectCommands.ProjectSelectCommand;
import seedu.duke.Commands.TaskCommands.TaskCommand;
import seedu.duke.Commands.TaskCommands.TaskDeleteCommand;
import seedu.duke.Commands.TaskCommands.TaskListCommand;
import seedu.duke.Commands.TaskCommands.TaskSelectCommand;

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
    public static Command parse(String inputCommand) {
        Command commandType;
        if (inputCommand.equals(INPUT_COMMAND_BYE)) {
            commandType = new ExitCommand();
        } else {
            commandType = checkAction(inputCommand);
        }
        return commandType;
    }

    /**
     * Parses user input related to tasks into command for execution.
     *
     * @param inputCommand Full user input command string
     * @return Command object corresponding to the input command of the user
     */
    public static Command checkAction(String inputCommand) {
        Command commandType = null;
        String[] inputs = inputCommand.split("\\s+");
        String taskType = inputs[0];
        String projectDescription = "";
        boolean isProjectListView = (projectIndex == -1); //In main project list view

        switch (taskType) {
        case "list":
            if (isProjectListView) {
                commandType = new ProjectListCommand();
            } else {
                commandType = new TaskListCommand(projectIndex);
            }
            break;
        case "select":
            if (isProjectListView) {
                projectIndex = Integer.parseInt(inputs[1]) - 1;
                commandType = new ProjectSelectCommand(projectIndex);
            } else {
                taskIndex = Integer.parseInt(inputs[1]) - 1;
                commandType = new TaskSelectCommand(taskIndex, projectIndex);
            }
            break;
        case "project":
            if (isProjectListView) {
                for (int i = 1; i < inputs.length; i++) {
                    projectDescription += inputs[i];
                }
                commandType = new ProjectCommand(projectDescription);
                break;
            } else {
                System.out.println("Not in Project View!");
            }
            break;
        case "task":
            if (isProjectListView) {
                System.out.println("Not in Task View!");
            } else {
                for (int i = 1; i < inputs.length; i++) {
                    projectDescription += inputs[i];
                }
                commandType = new TaskCommand(projectDescription, projectIndex);
            }
            break;
        case "delete":
            if (isProjectListView) {
                //Implement delete project here - Small Sam
            } else {
                taskIndex = Integer.parseInt(inputs[1]) - 1;
                commandType = new TaskDeleteCommand(taskIndex, projectIndex);
            }
            break;
        case "switch":
            if (!isProjectListView) {
                System.out.println("Switched to Project View!");
                projectIndex = -1;
            } else {
                System.out.println("Already in Project View!");
            }
            break;
        case "member":
            String memberName = inputCommand.split(" ")[1];
            commandType = new AddTeamMemberCommand(memberName);
            break;
        case "members":
            commandType = new ListTeamMembersCommand();
            break;
        default:
            break;
        }
        return commandType;
    }

}


