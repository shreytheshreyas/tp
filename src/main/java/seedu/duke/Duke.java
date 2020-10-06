package seedu.duke;

import java.util.Scanner;

public class Duke {

    private static ProjectList projects;


    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {

        projects = new ProjectList();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
//        System.out.println("What is your name?");
//
        Scanner in = new Scanner(System.in);
//        System.out.println("Hello " + in.nextLine());

        boolean isExit = false;
        while (!isExit) {
            try {
                Command commandInput = Parser.parse(in.nextLine());
                commandInput.executeCommand(projects);
                isExit = commandInput.isExit();
            } catch (NullPointerException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                printInvalidTaskInputErrorMessage();
            }
        }

    }

    private static void printInvalidTaskInputErrorMessage() {
        System.out.println("There is an ERROR!!!");
    }


}
