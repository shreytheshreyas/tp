package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.HomeCommand;
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

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    public static int extractIndex(String index) {
        return Integer.parseInt(index) - 1;
    }

    public static String inputTextField(String[] inputs) {
        String description = "";

        for (int i = 1; i < inputs.length; i++) {
            if (i == inputs.length - 1) {
                description += inputs[i];
            } else {
                description += inputs[i] + " ";
            }
        }
        return description;
    }

    public static Command getRemoveTeamMemberCommand(String[] inputs) {
        Command commandType = null;
        try {
            int memberIndex = extractIndex(inputs[1]);
            commandType = new DeleteTeamMemberCommand(memberIndex);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

        return commandType;
    }

    public static Command getAddMemberCommand(String[] inputs) throws DukeExceptions {
        Command commandType;
        if (inputs[1].contains("m/")) {
            inputs[1] = inputs[1].replaceFirst("m/","");
            String memberName = inputTextField(inputs);
            commandType = new AddTeamMemberCommand(memberName);
        } else {
            throw new DukeExceptions("default");
        }
        return commandType;
    }

    public static Command getDeleteCommand(String[] inputs, boolean isProjectListView) throws DukeExceptions {
        Command commandType;
        if (isProjectListView && inputs[1].contains("p/")) {
            inputs[1] = inputs[1].replaceFirst("p/","");
            projectIndex = extractIndex(inputs[1]);
            commandType = new DeleteProjectCommand(projectIndex);
            projectIndex = -1;
        } else if (inputs[1].contains("t/")) {
            inputs[1] = inputs[1].replaceFirst("p/","");
            taskIndex = extractIndex(inputs[1]);
            commandType = new TaskDeleteCommand(taskIndex, projectIndex);
        } else {
            throw new DukeExceptions("default");
        }
        return commandType;
    }

    public static Command getDeadlineCommand(Ui ui, boolean isProjectView, String[] inputs) throws DukeExceptions {
        Command commandType = null;

        try {
            if (!isProjectView && inputs[1].contains("t/") && inputs[2].contains("d/")) {
                inputs[1] = inputs[1].replaceFirst("t/", "");
                inputs[2] = inputs[2].replaceFirst("d/", "");
                int taskIndex = extractIndex(inputs[1]);
                String dateString = inputs[2];
                LocalDate date = LocalDate.parse(dateString);
                commandType = new DeadlineCommand(projectIndex, taskIndex, date);
            } else {
                throw new DukeExceptions("default");
            }
        } catch (StringIndexOutOfBoundsException | DateTimeParseException e) {
            ui.printOutput("Date must be specified in format YYYY-MM-DD");
        } catch (NumberFormatException e) {
            System.out.println("Task Index not specified");
        }

        return commandType;
    }

    public static Command getTaskCommand(String[] inputs, boolean isProjectListView) throws DukeExceptions {
        Command commandType;
        String taskDescription;

        if (!isProjectListView && inputs[1].contains("n/")) {
            inputs[1] = inputs[1].replaceFirst("n/","");
            taskDescription = inputTextField(inputs);
            commandType = new TaskCommand(taskDescription,projectIndex);
        } else {
            throw new DukeExceptions("default");
        }
        return commandType;
    }

    public static Command getProjectCommand(String[] inputs, boolean isProjectListView) throws DukeExceptions {
        Command commandType;
        String description;
        if (isProjectListView && inputs[1].contains("n/")) {
            inputs[1] = inputs[1].replaceFirst("n/","");
            description = inputTextField(inputs);
            commandType = new ProjectCommand(description);
        } else {
            throw new DukeExceptions("Add Task"); // REPLACED WITH EXCEPTION // change key descriptions
        }
        return commandType;
    }

    public static Command getDescriptionCommand(String[] inputs, boolean isProjectListView) throws DukeExceptions {
        Command commandType;
        String description;
        if (isProjectListView) {
            throw new DukeExceptions("default"); // replace with exception
        } else {
            description = inputTextField(inputs);
            commandType = new ProjectDescriptionCommand(description, projectIndex);
        }
        return commandType;
    }

    public static Command getSelectCommand(String[] inputs, boolean isProjectListView) throws DukeExceptions {
        Command commandType;
        if (isProjectListView && inputs[1].contains("p/")) {
            inputs[1] = inputs[1].replaceFirst("p/","");
            projectIndex = extractIndex(inputs[1]);
            commandType = new ProjectSelectCommand(projectIndex);
        } else if (inputs[1].contains("t/")) {
            inputs[1] = inputs[1].replaceFirst("t/","");
            taskIndex = extractIndex(inputs[1]);
            commandType = new TaskSelectCommand(taskIndex, projectIndex);
        } else {
            throw new DukeExceptions("default");
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
        String[] inputs = inputCommand.split("\\s+");
        String taskType = inputs[0];
        boolean isProjectListView = (projectIndex == -1); //In main project list view
        Ui ui = new Ui();

        switch (taskType) {
        case "list":
            commandType = getListCommandType(isProjectListView);
            break;
        case "select":
            commandType = getSelectCommand(inputs, isProjectListView);
            break;
        case "description":
            commandType = getDescriptionCommand(inputs, isProjectListView);
            break;
        case "project":
            commandType = getProjectCommand(inputs, isProjectListView);
            break;
        case "task":
            commandType = getTaskCommand(inputs, isProjectListView);
            break;
        case "deadline":
            commandType = getDeadlineCommand(ui,isProjectListView,inputs);
            break;
        case "delete":
            commandType = getDeleteCommand(inputs, isProjectListView);
            break;
        case "home":
            commandType = new HomeCommand(projectIndex);
            break;
        case "member":
            commandType = getAddMemberCommand(inputs);
            break;
        case "members":
            commandType = new ListTeamMembersCommand();
            break;
        case "remove":
            commandType = getRemoveTeamMemberCommand(inputs);
            break;
        default:
            break;
        }
        return commandType;
    }

}


