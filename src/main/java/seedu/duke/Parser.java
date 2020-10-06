package seedu.duke;

public class Parser {

    private static final String INPUT_COMMAND_BYE = "bye";
    private static final String INPUT_COMMAND_LIST = "list";

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
        } else if (inputCommand.equals(INPUT_COMMAND_LIST)) {
            commandType = new ListCommand();
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

        // Check validity of user's input on task description
        // If given correct command but invalid format, error messages can be printed
        if (inputCommand.split(" ").length > 1) {
            projectDescription = inputCommand.split(" /", 2)[0].split(" ", 2)[1];
        }
        else {
            projectDescription = inputCommand;
        }

        switch (taskType) {
        case "select":
            commandType = new SelectCommand(inputCommand);
            break;
        case "project":
            commandType = new ProjectCommand(inputCommand, projectDescription);
//        case INPUT_COMMAND_DEADLINE:
//        case INPUT_COMMAND_EVENT:
//        case INPUT_COMMAND_TODO:
//            commandType = new AddCommand(taskType, taskDescription, inputCommand);
//            break;
//        case INPUT_COMMAND_DONE:
//            commandType = new DoneCommand(inputCommand);
//            break;
//        case INPUT_COMMAND_DELETE:
//            commandType = new DeleteCommand(inputCommand);
//            break;
//        case INPUT_COMMAND_FIND:
//            commandType = new FindCommand(inputCommand);
//            break;
//        case INPUT_COMMAND_DATETIME:
//            commandType = new DateTimeCommand(inputCommand);
//            break;
        }
        return commandType;
    }


}


