package seedu.duke.ui;

import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.util.ArrayList;

public class Ui {

    private static final String MESSAGE_SINGLE_LINE = "____________________________________________________________";
    private static final String MESSAGE_WELCOME = "Hello from Duke!\n"
            + "What can I do for you?";
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

    public static void printOutput(String output) {
        System.out.println(output);
    }

    public static String printMemberAddedMessage(String name) {
        return "Team member \"" + name + "\" has been added";
    }

    public static String printProjectDeletedMessage(Project project) {
        return "Project \"" + project.getProjectName() + "\" deleted";
    }

    public static String printEmptyProjectListMessage() {
        return "Project list is empty!!";
    }

    public static String printProjectListMessage(ArrayList<Project> projects) {
        String output = "";
        output += "List of Projects:";
        for (int i = 0; i < projects.size(); i++) {
            output += "\n     " + (i + 1) + "." + projects.get(i).getProjectName();
        }
        return output;
    }

    public static String printTaskListMessage(Project project) {
        int numberOfTasks = project.getTaskList().size();
        String output = "List of Tasks:";
        for (int i = 0; i < numberOfTasks; i++) {
            output += "\n     " + (i + 1) + "." + project.getTask(i);
        }
        return output;
    }

    public static String printProjectCreatedMessage(String projectName) {
        return "Project \"" + projectName + "\" created!";
    }

    public static String printProjectDescriptionAddedMessage(Project project) {
        return "Project description added \"" + project.getDescription() + "\".";
    }

    public static String printProjectSelectedMessage(ArrayList<Project> projects, int projectIndex) {
        return "Switched to Project \"" + projects.get(projectIndex).getProjectName() + "\"";
    }

    public static String printEmptyAdditionalProjectInformationMessage() {
        return "<project description empty> | <project deadline empty> | "
                + "<team members involved empty>";
    }

    public static String printTaskCreatedMessage(String taskName) {
        return "Task \"" + taskName + "\" created!";
    }

    public static String printTaskDeletedMessage(String taskName) {
        return "Task \"" + taskName + "\" removed!";
    }

    public static String printTaskSelectedMessage(String taskName) {
        return "Selected Task: " + taskName;
    }

    public static String printInHomeViewMessage() {
        return "Already in Home View!";
    }

    public static String printSwitchedToHomeViewMessage() {
        return "Switched to Home View";
    }

    public static String printMemberRemovedMessage(String memberName) {
        return "\"" + memberName + "\" has been removed";
    }

    public static String printMemberAssignedToTaskMessage(String memberName, String taskName) {
        return "Member \"" + memberName + "\" has been assigned to \"" + taskName + "\"";
    }

    public static String printPriorityAssignedToTaskMessage(String priority, String taskName) {
        return "Priority \"" + priority + "\" has been assigned to \"" + taskName + "\"";
    }

}
