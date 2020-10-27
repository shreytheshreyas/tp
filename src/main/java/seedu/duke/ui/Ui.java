package seedu.duke.ui;

import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static String printMemberRemovedMessage(String name) {
        return "Team member \"" + name + "\" has been removed";
    }

    public static String printProjectDeletedMessage(Project project) {
        return "Project \"" + project.getProjectName() + "\" deleted";
    }

    public static String printProjectListMessage(ArrayList<Project> projects) {
        String output = "";
        output += "List of Projects:";
        for (int i = 0; i < projects.size(); i++) {
            output += "\n     " + (i + 1) + "." + projects.get(i).getProjectName();
            if (projects.get(i).getProjectDeadline() != null) {
                output += " (" + projects.get(i).getProjectDeadline() + ") ";
            }
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

    public static String printProjectDeadlineAddedMessage(Project project, LocalDate date) {
        return "Deadline " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " added to Project " + project.getProjectName();
    }

    public static String printEmptyAdditionalProjectInformationMessage() {
        return "<project description empty> | <project deadline empty> | "
                + "<team members involved empty>";
    }

    public static String printTaskCreatedMessage(String taskName) {
        return "Task \"" + taskName + "\" created!";
    }

    public static String printEstimateAddedMessage(String taskName, int hours, int minutes) {
        return "Task \"" + taskName + "\" has estimated time of " + hours + " hours and " + minutes + " minutes";
    }

    public static String printActualDurationAddedMessage(String taskName, int hours, int minutes) {
        return "Task \"" + taskName + "\" took " + hours + " hours and " + minutes + " minutes to be completed.";
    }

    public static String printTaskDoneMessage(String taskName) {
        return "Task \"" + taskName + "\" is done!";
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
            String projectTitle = "Project \"" + project.getProjectName() + "\"";
            String taskListTitle = "\n ---------------------\n| TASK LIST           |\n ---------------------";
            String membersListTitle = "\n ---------------------\n| MEMBERS LIST        |\n ---------------------";
            String STATUS_SPACES = "      "; // 6
            String DESCRIPTION_SPACES = "                   "; // 19
            String DEADLINE_SPACES = "                "; // 16
            String PRIORITY_SPACES = "              "; // 14
            String EXPECTED_SPACES = "                 "; // 17
            String ACTUAL_SPACES = "             "; // 13
            String MEMBERS_SPACES = "                "; // 16
            String tableLabel = "Status   Description        Deadline        Priority      Expected Hrs     Actual Hrs   | Members Involved\n" +
                    "----------------------------------------------------------------------------------------|------------------";
            Integer extra = 0;
            Integer i = 0;
            String currentTaskLine = "";
            String taskLines = "\n";
            if (project.getTaskList().size() > 0) {
                for(; i < project.getTaskList().size(); i++) {
                    Task currentTask = project.getTaskList().get(i);
                    String status = currentTask.isDone() ? "(Y)" : "(N)";
                    String description = currentTask.getTaskDescription();
                    String deadline = currentTask.getDateString();
                    String priority = currentTask.getPriority();
                    Integer estimate = currentTask.getEstimate();
                    Integer actual = currentTask.getActual();
                    TeamMember member = currentTask.getMember();
                    String memberName;

                    currentTaskLine = status + STATUS_SPACES + description
                            + (DESCRIPTION_SPACES.substring(0, DESCRIPTION_SPACES.length() - description.length()));
                    if (deadline.length() > 0) {
                        currentTaskLine += (deadline);
                    } else {
                        currentTaskLine += "—";
                    }

                    currentTaskLine += (DEADLINE_SPACES.substring(0, DEADLINE_SPACES.length() - deadline.length()));

                    if (priority.length() > 0) {
                        currentTaskLine += (priority);
                    } else {
                        currentTaskLine += "—";
                    }
                    currentTaskLine += (PRIORITY_SPACES.substring(0, PRIORITY_SPACES.length() - priority.length()));

                    if (estimate > 1) {
                        currentTaskLine += (estimate / 60);
                        extra = estimate.toString().length() - 1;
                    } else {
                        currentTaskLine += "—";
                        extra = 0;
                    }
                    currentTaskLine += (EXPECTED_SPACES.substring(0, EXPECTED_SPACES.length() - estimate.toString().length() + extra));

                    if (actual > 1) {
                        currentTaskLine += (actual / 60);
                        extra = actual.toString().length() - 1;
                    } else {
                        currentTaskLine += "—";
                    }
                    currentTaskLine += (ACTUAL_SPACES.substring(0, ACTUAL_SPACES.length() - actual.toString().length() + extra));

                    if (member != null) {
                        currentTaskLine += "| " + member.getName();
                        memberName = member.getName();
                    } else {
                        currentTaskLine += "| —";
                        memberName = "| —";
                    }
                    currentTaskLine += (MEMBERS_SPACES.substring(0, MEMBERS_SPACES.length() - memberName.length()));

                    taskLines += (currentTaskLine + "\n");
                }
            } else {
                taskLines += "No tasks have been added to this project.";
            }


            ArrayList<TeamMember> members = project.getTeamMembers();
            String membersListLines = "";
            if (members.size() > 0 ) {
                for (int j = 0; j < members.size(); j++) {
                    membersListLines += (j+1) + ". " + members.get(j).getName() + "\n";
                }
            } else {
                membersListLines += "No team members have been assigned to this project.";
            }

            return projectTitle + "\n" + taskListTitle + "\n" + (project.getTaskList().size() > 0 ? tableLabel : "") + taskLines + "\n \n" + membersListTitle + "\n" + membersListLines;
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return "hi";
    }

    public static String printMemberAssignedToTaskMessage(String memberName, String taskName) {
        return "Member \"" + memberName + "\" has been assigned to \"" + taskName + "\"";
    }

    public static String printPriorityAssignedToTaskMessage(String priority, String taskName) {
        return "Priority \"" + priority + "\" has been assigned to \"" + taskName + "\"";
    }

}
