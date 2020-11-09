package seedu.duke.ui;

import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.time.Period;

public class Ui {

    private static final String MESSAGE_SINGLE_LINE = "_________________________________________"
            + "____________________________________________";
    private static final String MESSAGE_WELCOME = "Hello from EzManager!\n"
            + "What can I do for you?";
    private static final String MESSAGE_GOODBYE = "See you again!";
    private static final String MESSAGE_LOGO = " _____         ___     ___\n"
            + "|  ___|       |   \\  /   |\n"
            + "| |___  _____ |    \\/    | ______    ______  ______    ______  ______   _____  _____\n"
            + "|  ___||___ / |  |\\  /|  ||  __  |  |  __  ||  __  |  |  __  ||  __  | / ___ \\|  ___|\n"
            + "| |___   / /_ |  | \\/ |  || |__| |_ | |  | || |__| |_ | |  | || |__| ||   ___/|  |\n"
            + "|_____| /____||__|    |__||________||_|  |_||________||_|  |_||____  ||______||__|\n"
            + "                                                                   | |\n"
            + "                                                               ____| |\n"
            + "                                                              |______|\n";

    public void printWelcome() {
        System.out.println(MESSAGE_SINGLE_LINE);
        System.out.println(MESSAGE_LOGO);
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

    public static String printMemberRemovedInHomeViewMessage(String name) {
        return "Team member \"" + name + "\" has been removed from program entirely";
    }

    public static String printMemberRemovedInProjectViewMessage(String name, String projectName) {
        return "Team member \"" + name + "\" has been removed from Project \"" + projectName + "\"";
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

        project.sortTasksList();
        int numberOfTasks = project.getTaskList().size();

        String output = "List of Tasks:";

        for (int i = 0; i < numberOfTasks; i++) {

            output += "\n     " + (i + 1) + "." + project.getTask(i)
                    + ((project.getTask(i).getPriority() != 0) ? "|"
                    + "priority: " + project.getTask(i).getPriority() : "");
        }

        return output;
    }

    public static String printProjectCreatedMessage(String projectName) {
        return "Project \"" + projectName + "\" created!";
    }

    public static String printProjectDescriptionAddedMessage(Project project) {
        return "Project description added \"" + project.getDescription() + "\".";
    }

    public static String printProjectDoneMessage(String projectName) {
        return "Project \"" + projectName + "\" is done!";
    }

    public static String printProjectDeadlineAddedMessage(ArrayList<Project> projects, Project project,
                                                          LocalDate date, ArrayList<TeamMember> members) {
        String output =  "Deadline " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " added to Project " + project.getProjectName() + "\n\n";
        output += printHomeView(projects, members);
        return output;
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

    public static String printHomeView(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        String output = "EZ Manager Home View\n";
        output += "\n ----------------------";
        output += "\n| PROJECT LIST         |";
        output += "\n ----------------------\n";
        output += "\nIndex   Status   Project Name             Project Description                "
                + "Deadline     Tasks Completed     Remarks";
        output += "\n---------------------------------------------------------------------------"
                + "---------------------------------------------------------------------------";
        int projectIndex = 1;
        String paddedProjectIndex;
        String paddedProjectStatus;
        String paddedProjectName;
        String paddedProjectDescription;
        String paddedProjectDeadline;
        String paddedTaskCompleted;
        for (Project project : projects) {
            paddedProjectIndex = String.format("%-8s", projectIndex + ".");
            String projectStatus;
            if (project.isProjectDone()) {
                projectStatus = "Y";
            } else {
                projectStatus = "N";
            }
            paddedProjectStatus = String.format("%-9s", projectStatus);
            String projectName = project.getProjectName();
            if (projectName.length() >= 25) {
                projectName = projectName.substring(0, 21) + "...";
            }
            paddedProjectName = String.format("%-25s", projectName);
            if (!project.getDescription().equals("<project description empty>")) {
                String projectDescription = project.getDescription();
                if (projectDescription.length() >= 35) {
                    projectDescription = projectDescription.substring(0, 31) + "...";
                }
                paddedProjectDescription = String.format("%-35s", projectDescription);
            } else {
                paddedProjectDescription = String.format("%-35s", "-");
            }
            if (project.getProjectDeadline() != null) {
                String projectDeadline = project.getProjectDeadline().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                paddedProjectDeadline = String.format("%-13s", projectDeadline);
            } else {
                paddedProjectDeadline = String.format("%-13s", "-");
            }
            String taskCompleted = project.getNumberOfFinishedTask() + "/"
                    + project.getNumberOfTask();
            paddedTaskCompleted = String.format("%-20s", taskCompleted);
            String remarks = "-";
            LocalDate dateOfTaskWithNearestDeadline = null;
            Task taskWithNearestDeadline = null;
            if (!project.getTaskList().isEmpty()) {
                ArrayList<Task> tasks = project.getTaskList();
                for (Task task : tasks) {
                    LocalDate deadlineOfTask = task.getDeadline();
                    if (deadlineOfTask == null) {
                        continue;
                    } else if (dateOfTaskWithNearestDeadline == null) {
                        dateOfTaskWithNearestDeadline = deadlineOfTask;
                        taskWithNearestDeadline = task;
                    } else if (deadlineOfTask.compareTo(dateOfTaskWithNearestDeadline) < 0) {
                        dateOfTaskWithNearestDeadline = deadlineOfTask;
                        taskWithNearestDeadline = task;
                    }
                }
                LocalDate currentDate = LocalDate.now();
                if (dateOfTaskWithNearestDeadline != null && !taskWithNearestDeadline.getStatus()) {
                    //find the difference in the number of days from current days to deadline
                    Period period = Period.between(currentDate, dateOfTaskWithNearestDeadline);
                    if (period.getDays() <= 5 && period.getMonths() == 0 && period.getYears() == 0) {
                        remarks = "!!!WARNING!!! Task \"" + taskWithNearestDeadline.getDescription()
                                + "\" has " + period.getDays() + " day(s) before deadline and still not done!!";
                    } else {
                        remarks = "Task \"" + taskWithNearestDeadline.getDescription()
                                + "\" has an upcoming deadline at " + taskWithNearestDeadline.getDateString()
                                + " and still not done!!";
                    }
                }
            }
            output += "\n" + paddedProjectIndex + paddedProjectStatus + paddedProjectName + paddedProjectDescription
                    + paddedProjectDeadline + paddedTaskCompleted + remarks;
            projectIndex++;
        }
        output += "\n\n ----------------------";
        output += "\n| MEMBERS LIST         |";
        output += "\n ----------------------\n";
        output += "\nIndex   Member Name                   Projects Involved";
        output += "\n-----------------------------------------------------------------------------";
        int memberIndex = 1;
        for (TeamMember member : teamMembers) {
            String paddedMemberIndex = String.format("%-8s", memberIndex + ".");
            String memberName = member.getName();
            if (member.getName().length() >= 30) {
                memberName = member.getName().substring(0, 26) + "...";
            }
            String paddedMemberName = String.format("%-30s", memberName);
            output += "\n" + paddedMemberIndex + paddedMemberName;
            if (!member.getAssignedProjects().isEmpty()) {
                for (int i = 0; i < member.getAssignedProjects().size(); i++) {
                    String assignedProjectName = member.getAssignedProjects().get(i).getProjectName();
                    if (i == 0) {
                        output += "1. " + assignedProjectName;
                    } else {
                        output += "\n                                      "
                                + (i + 1) + ". " + assignedProjectName;
                    }
                }
            } else {
                output += "-";
            }
            output += System.lineSeparator();
            memberIndex++;
        }
        return output;
    }

    public static String printTaskSelectedMessage(String taskName) {
        return "Selected Task: " + taskName;
    }

    public static String printTaskDeadlineMessage(LocalDate date, String taskName) {
        return "Deadline " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " added to Task " + taskName;
    }

    public static String printTaskNameUpdatedMessage(String oldTaskName, String newTaskName) {
        return "Task " + "\"" + oldTaskName + "\" has been updated to \"" + newTaskName + "\"";
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
            String projectDescription = "\n" + "Description:" + "\n" + project.getDescription();
            String taskListTitle = "\n ---------------------\n| TASK LIST           |\n ---------------------";
            String membersListTitle = "\n ---------------------\n| MEMBERS LIST        |\n ---------------------";
            String indexSpaces = "      "; // 6
            String statusSpaces = "      "; // 6
            String descriptionSpaces = "                   "; // 19
            String deadlineSpaces = "                "; // 16
            String prioritySpaces = "              "; // 14
            String estimatedSpaces = "                  "; // 18
            String actualSpaces = "             "; // 13
            String membersSpaces = "                "; // 16
            String tableLabel = "Index  Status   Description        "
                                + "Deadline        Priority      Estimated Hrs     Actual Hrs   | Members Involved\n"
                                + "------------------------------------------------"
                                + "------------------------------------------------|------------------";
            Integer extra = 0;
            Integer i = 0;
            int index;
            String currentTaskLine = "";
            String taskLines = "\n";
            if (project.getTaskList().size() > 0) {
                for (; i < project.getTaskList().size(); i++) {
                    index = i + 1;
                    Task currentTask = project.getTaskList().get(i);
                    String status = currentTask.isDone() ? "(Y)" : "(N)";
                    String description = currentTask.getTaskDescription();
                    String deadline = currentTask.getDateString();

                    currentTaskLine = index + indexSpaces + status + statusSpaces + description
                            + (descriptionSpaces.substring(0, descriptionSpaces.length() - description.length()));
                    if (deadline.length() > 0) {
                        currentTaskLine += (deadline);
                    } else {
                        deadline = "-";
                        currentTaskLine += "-";
                    }

                    currentTaskLine += (deadlineSpaces.substring(0, deadlineSpaces.length() - deadline.length()));

                    String priority = String.valueOf(currentTask.getPriority());
                    if (!priority.equals("0")) {
                        currentTaskLine += (priority);
                    } else {
                        priority = "-";
                        currentTaskLine += "-";
                    }
                    currentTaskLine += (prioritySpaces.substring(0, prioritySpaces.length() - priority.length()));

                    Integer estimate = currentTask.getEstimate();
                    String estimateString = "";
                    if (estimate > 1) {
                        int hours = (estimate / 60);
                        int minutes = estimate - hours * 60;
                        double ratio = minutes / 60.0;
                        estimateString = String.format("%.1f", hours + ratio);
                        currentTaskLine += estimateString;
                    } else {
                        estimateString = "-";
                        currentTaskLine += estimateString ;
                    }
                    currentTaskLine += (estimatedSpaces.substring(0, estimatedSpaces.length()
                            - estimateString.length()));

                    Integer actual = currentTask.getActual();
                    String actualString = "";
                    if (actual > 1) {
                        int hours = (actual / 60);
                        int minutes = actual - hours * 60;
                        double ratio = minutes / 60.0;
                        actualString = String.format("%.1f", hours + ratio);
                        currentTaskLine += actualString;
                    } else {
                        actualString = "-";
                        currentTaskLine += actualString;
                    }

                    currentTaskLine += (actualSpaces.substring(0, actualSpaces.length()
                            - actualString.length()));

                    String memberName = null;
                    ArrayList<TeamMember> members = currentTask.getMembers();
                    currentTaskLine += "|";
                    memberName = "|";
                    for (TeamMember member : members) {
                        currentTaskLine += member.getName() + "|";
                        memberName = member.getName();
                    }
                    //currentTaskLine += (membersSpaces.substring(0, membersSpaces.length() - memberName.length()));
                    taskLines += (currentTaskLine + "\n");
                }
            } else {
                taskLines += "No tasks have been added to this project.";
            }

            ArrayList<TeamMember> members = project.getTeamMembers();
            String membersListLines = "";
            if (members.size() > 0) {
                for (int j = 0; j < members.size(); j++) {
                    membersListLines += (j + 1) + ". " + members.get(j).getName() + "\n";
                }
            } else {
                membersListLines += "No team members have been assigned to this project.";
            }

            return projectTitle + "\n" + projectDescription + "\n" + taskListTitle + "\n"
                    + (project.getTaskList().size() > 0 ? tableLabel : "") + taskLines
                    + "\n \n" + membersListTitle + "\n" + membersListLines;
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        return "hi";
    }

    public static String printMemberAssignedToTaskMessage(String memberName, String taskName) {
        return "Member \"" + memberName + "\" has been assigned to \"" + taskName + "\"";
    }

    public static String printMemberAssignedToProjectMessage(String memberName, String projectName) {
        return memberName + " assigned to Project \"" + projectName + "\"";
    }

    public static String printPriorityAssignedToTaskMessage(int priority, String taskName) {
        return "Priority \"" + priority + "\" has been assigned to \"" + taskName + "\"";
    }

    public static String printHoursWorkedMessage(String memberName, double hoursWorked) {
        return memberName + " worked for " + String.format("%.1f", hoursWorked) + " hours.";
    }

}
