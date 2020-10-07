package seedu.duke;

public class Parser {

    private static final String INPUT_COMMAND_BYE = "bye";
    private static final String INPUT_COMMAND_LIST = "list";
    private static int projectIndex = -1;

    /**
     * Parses user input into command for execution.
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
        String taskType = inputCommand.split(" ")[0];
        String projectDescription;
        boolean isProjectListView = (projectIndex == -1); //In main project list view

        switch (taskType) {
        case "list":
            if (isProjectListView) {
                commandType = new ListCommand();
            }
            else {
                commandType = new TaskListCommand(projectIndex);
            }
            break;
        case "select":
            if (isProjectListView) {
                projectIndex = Integer.parseInt(inputCommand.split(" ")[1]) - 1;
                commandType = new SelectCommand(inputCommand);
            } else {

            }
            break;
        case "project":
            String deadline = inputCommand.split(" /by ")[1];
            projectDescription = inputCommand.split(" /by ", 2)[0].split(" ", 2)[1];
            commandType = new ProjectCommand(projectDescription, deadline);
            break;
        case "task":
            deadline = inputCommand.split(" /by ")[1];
            projectDescription = inputCommand.split(" /by ", 2)[0].split(" ", 2)[1];
            commandType = new TaskCommand(projectDescription, deadline, projectIndex);
            break;
        default:
            break;
        }
        return commandType;
    }


}


