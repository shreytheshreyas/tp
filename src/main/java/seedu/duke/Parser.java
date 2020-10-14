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
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        String description = "";
        boolean isProjectListView = (projectIndex == -1); //In main project list view
        Ui ui = new Ui();

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
        case "description":
            if (isProjectListView) {
                System.out.println("Not in Task View!");
            } else {
                for (int i = 1; i < inputs.length; i++) {
                    if (i == inputs.length - 1) {
                        description += inputs[i];
                    } else {
                        description += inputs[i] + " ";
                    }
                }
                commandType = new ProjectDescriptionCommand(description, projectIndex);
            }
            break;
        case "project":
            if (isProjectListView) {
                for (int i = 1; i < inputs.length; i++) {
                    if (i == inputs.length - 1) {
                        description += inputs[i];
                    } else {
                        description += inputs[i] + " ";
                    }
                }
                commandType = new ProjectCommand(description);
                break;
            } else {
                System.out.println("Not in Project View!"); //----------REPLACE WITH EXCEPTION
            }
            break;
        case "task":
            if (isProjectListView) {
                System.out.println("Not in Task View!"); //----------REPLACE WITH EXCEPTION
            } else {
                for (int i = 1; i < inputs.length - 1; i++) { //Task name after task keyword and before date
                    description += inputs[i];
                }
                try {
                    String dateString = inputs[inputs.length - 1].substring(2);
                    /**
                    if (dateString.substring(0,2) != "/t") {
                        throw new DukeExceptions();
                    }
                     **/
                    LocalDate date = LocalDate.parse(dateString);
                    commandType = new TaskCommand(description, projectIndex, date);
                } catch (NullPointerException e) {
                    ui.printOutput("Date must be specified in format YYYY-MM-DD");
                } catch (StringIndexOutOfBoundsException e) {
                    ui.printOutput("Date must be specified in format YYYY-MM-DD");
                }  catch (DateTimeParseException e) {
                    ui.printOutput("Date must be specified in format YYYY-MM-DD");
                }
            }
            break;
        case "delete":
            if (isProjectListView) {
                commandType = new DeleteProjectCommand(Integer.parseInt(inputs[1]) - 1);
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
                System.out.println("Already in Project View!"); //----------REPLACE WITH EXCEPTION
            }
            break;
        case "member":
            String memberName = "";
            for (int i = 1; i < inputs.length; i++) {
                if (i == inputs.length - 1) {
                    memberName += inputs[i];
                } else {
                    memberName += inputs[i] + " ";
                }
            }
            commandType = new AddTeamMemberCommand(memberName);
            break;
        case "members":
            commandType = new ListTeamMembersCommand();
            break;
        case "remove":      
            commandType = new DeleteTeamMemberCommand(inputCommand.split(" ")[1]);
            break;
        default:
            break;
        }
        return commandType;
    }

}


