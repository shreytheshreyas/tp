package seedu.duke;

import seedu.duke.Commands.Command;
import seedu.duke.ProjectStuff.ProjectList;
import seedu.duke.TaskStuff.TaskList;

import java.util.Scanner;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {

        ProjectList projects = new ProjectList();
        TaskList tasks = new TaskList();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);
        System.out.println("Hello from Duke!");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");


        Scanner in = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            try {
                Command commandInput = Parser.parse(in.nextLine());
                System.out.println("____________________________________________________________");
                commandInput.executeCommand(projects);
                isExit = commandInput.isExit();
            } catch (NullPointerException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                printInvalidTaskInputErrorMessage();
            }
            System.out.println("____________________________________________________________");
        }

    }

    private static void printInvalidTaskInputErrorMessage() {
        System.out.println("There is an ERROR!!!");
    }


}
