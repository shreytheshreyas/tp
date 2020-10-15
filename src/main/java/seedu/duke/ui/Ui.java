package seedu.duke.ui;

import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

public class Ui {

    private static final String MESSAGE_SINGLE_LINE = "____________________________________________________________";
    private static final String MESSAGE_WELCOME = "Hello from Duke!\n" +
            "What can I do for you?";
    private static final String MESSAGE_GOODBYE = "See you again!";
    private static final String MESSAGE_LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";


    public void printWelcome() {
        System.out.println(MESSAGE_WELCOME);
        System.out.println(MESSAGE_SINGLE_LINE);
    }

    public static String printGoodbyeMessage() {
        return MESSAGE_GOODBYE;
    }

    public void printLine() {
        System.out.println(MESSAGE_SINGLE_LINE);
    }

    public void printOutput(String output) {
        System.out.println(output);
    }

    public static String printMemberAddedMessage(String name) {
        return "Team member \"" + name + "\" has been added";
    }

    public static String printProjectDeletedMessage(Project projectName) {
        return "Project \"" + projectName + "\" deleted";
    }

    public static String printEmptyProjectListMessage() {
        return "Project list is empty!!";
    }

    public static String printProjectListMessage(ProjectList projects) {
        String output = "";
        output += "List of Projects:";
        for (int i = 0; i < projects.getProjectList().size(); i++) {
            output += "\n     " + (i + 1) + "." + projects.getProjectList().get(i);
        }
        return output;
    }

    public static String printTaskListMessage(Project project) {
        String output = "";
        output += "List of Tasks:";
        for (int i = 0; i < project.getTasks().size(); i++) {
            output += "\n     " + (i + 1) + "." + project.getTasks().get(i);
        }
        return output;
    }

    public static String printProjectCreatedMessage(String projectName) {
        return "Project \"" + projectName + "\" created!!";
    }

    public static String printEmptyAdditionalProjectInformationMessage() {
        return "<project description empty> | <project deadline empty> | "
                + "<team members involved empty>";
    }

    public static String printTaskCreatedMessage(Task newTask) {
        return "Created: " + newTask.toString();
    }

    public static String printTaskDeletedMessage(String taskDescription) {
        return "Task \"" + taskDescription + "\" removed!!";
    }


}
