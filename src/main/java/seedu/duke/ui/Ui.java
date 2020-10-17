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
        return "Project \"" + projectName + "\" created!!";
    }

    public static String printProjectDescriptionAddedMessage(Project project) {
        return "Project description added \"" + project.getDescription() + "\".";
    }

    public static String printEmptyAdditionalProjectInformationMessage() {
        return "<project description empty> | <project deadline empty> | "
                + "<team members involved empty>";
    }

    public static String printTaskCreatedMessage(Task newTask) {
        return "Created: " + newTask.toString();
    }

    public static String printTaskDeletedMessage(String taskName) {
        return "Task \"" + taskName + "\" removed!!";
    }

    public static String printHomeView(ProjectList projects) {
        int numberOfProjects = projects.getNumberOfProjects();
        String[][] data = new String[100][];
        for (int i = 0; i < numberOfProjects; i++) {
            data[i][0] = projects.getProject(i).getProjectName();
        }
        for (int j = 0; j < numberOfProjects; j++) {
            data[j][1] = projects.getProject(j).getDescription();
        }
        String output = MESSAGE_SINGLE_LINE;
        output += "\n|     Project Name     |     Description     |";
        output += "\n============================================================";
        for (int k = 0; k < numberOfProjects; k++) {
            output += "\n|     " + data[k][0] + "     |     " + data[k][1] + "     |";
        }
        output += "\n" + MESSAGE_SINGLE_LINE;
        return output;
    }

}
