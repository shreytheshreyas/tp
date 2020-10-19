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

    public static String printProjectDeletedMessage(Project projectName) {
        return "Project \"" + projectName + "\" deleted";
    }

    public static String printEmptyProjectListMessage() {
        return "Project list is empty!!";
    }

    public static String printProjectListMessage(ArrayList<Project> projects) {
        String output = "";
        output += "List of Projects:";
        for (int i = 0; i < projects.size(); i++) {
            output += "\n     " + (i + 1) + "." + projects.get(i);
        }
        return output;
    }

    public static String printTaskListMessage(Project project) {
        int numberOfTasks = project.getNumberTasks();
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

    public static String projectViewMessage(Project project) {
        try {
            String projectTitle = "Project \"" + project.toString() + "\"";
            String taskListTitle = "\n ---------------------\n| TASK LIST           |\n ---------------------";
            String STATUS_SPACES = "      "; // 6
            String DESCRIPTION_SPACES = "                   "; // 19
            String DEADLINE_SPACES = "                "; // 16
            Integer PRIORITY_SPACES = 6;
            String tableLabel = "Status   Description        Deadline        Priority      Expected Hrs     Actual Hrs   | Members Involved\n" +
                    "----------------------------------------------------------------------------------------|------------------";
            Integer i = 0;
            String currentTaskLine = "";
            String taskLines = "\n";
            for(; i < project.getNumberTasks(); i++) {
                Task currentTask = project.getTaskList().get(i);
                String status = currentTask.isDone() ? "(✔)" : "(✘)";
                String description = currentTask.getTaskDescription();
                String deadline = "20 Oct 2020"; // placeholder
//                String deadline = currentTask.getDateString();
                currentTaskLine = status + STATUS_SPACES + description
                        + (DESCRIPTION_SPACES.substring(0, DESCRIPTION_SPACES.length() - description.length()))
                        + deadline + (DEADLINE_SPACES.substring(0, DEADLINE_SPACES.length() - deadline.length()));
                taskLines += (currentTaskLine + "\n");
            }
            return projectTitle + "\n" + taskListTitle + "\n" + tableLabel + taskLines;
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return "hi";
//        return projectTitle + "\n" + taskListTitle + "\n";
    }


}
