package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.project.ProjectList;
import seedu.duke.task.TaskList;

import java.util.Scanner;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws DukeExceptions {

        ProjectList projects = new ProjectList();

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
                String output = commandInput.executeCommand(projects);
                System.out.println(output);
                isExit = commandInput.isExit();
            } catch (NullPointerException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println("____________________________________________________________");
        }

    }

}
