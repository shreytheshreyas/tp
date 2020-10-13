package seedu.duke.ui;

public class Ui {

    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);
        System.out.println("Hello from Duke!");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void printOutput(String output) {
        System.out.println(output);
    }
}
