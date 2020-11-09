package seedu.ezmanager.ui;

import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    private static String printProjectListHeadingInHomeView() {
        String output = "EZ Manager Home View\n";
        output += "\n ----------------------";
        output += "\n| PROJECT LIST         |";
        output += "\n ----------------------\n";
        output += "\nIndex   Status   Project Name             Project Description                "
                + "Deadline     Tasks Completed     Remarks";
        output += "\n---------------------------------------------------------------------------"
                + "---------------------------------------------------------------------------";
        return output;
    }

    private static String printProjectListInHomeView(ArrayList<Project> projects) {
        String output = "";
        int projectIndex = 1;
        String paddedProjectIndex;
        String paddedProjectStatus;
        String paddedProjectName;
        String paddedProjectDescription;
        String paddedProjectDeadline;
        String paddedTaskCompleted;
        String remarks;
        for (Project project : projects) {
            paddedProjectIndex = String.format("%-8s", projectIndex + ".");
            paddedProjectStatus = printProjectStatusInHomeView(project);
            paddedProjectName = printProjectNameInHomeView(project);
            paddedProjectDescription = printProjectDescriptionInHomeView(project);
            paddedProjectDeadline = printProjectDeadlineInHomeView(project);
            paddedTaskCompleted = printTaskCompletedInProjectInHomeView(project);
            remarks = printRemarksInHomeView(project);
            output += "\n" + paddedProjectIndex + paddedProjectStatus + paddedProjectName + paddedProjectDescription
                    + paddedProjectDeadline + paddedTaskCompleted + remarks;
            projectIndex++;
        }
        return output;
    }

    private static String printProjectStatusInHomeView(Project project) {
        String projectStatus;
        if (project.isProjectDone()) {
            projectStatus = "Y";
        } else {
            projectStatus = "N";
        }
        String paddedProjectStatus = String.format("%-9s", projectStatus);
        return paddedProjectStatus;
    }

    private static String printProjectNameInHomeView(Project project) {
        String projectName = project.getProjectName();
        if (projectName.length() >= 25) {
            projectName = projectName.substring(0, 21) + "...";
        }
        String paddedProjectName = String.format("%-25s", projectName);
        return paddedProjectName;
    }

    private static String printProjectDescriptionInHomeView(Project project) {
        String paddedProjectDescription;
        if (!project.getDescription().equals("<project description empty>")) {
            String projectDescription = project.getDescription();
            if (projectDescription.length() >= 35) {
                projectDescription = projectDescription.substring(0, 31) + "...";
            }
            paddedProjectDescription = String.format("%-35s", projectDescription);
        } else {
            paddedProjectDescription = String.format("%-35s", "-");
        }
        return paddedProjectDescription;
    }

    private static String printProjectDeadlineInHomeView(Project project) {
        String paddedProjectDeadline;
        if (project.getProjectDeadline() != null) {
            String projectDeadline = project.getProjectDeadline().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            paddedProjectDeadline = String.format("%-13s", projectDeadline);
        } else {
            paddedProjectDeadline = String.format("%-13s", "-");
        }
        return paddedProjectDeadline;
    }

    private static String printTaskCompletedInProjectInHomeView(Project project) {
        String taskCompleted = project.getNumberOfFinishedTask() + "/"
                + project.getNumberOfTask();
        String paddedTaskCompleted = String.format("%-20s", taskCompleted);
        return paddedTaskCompleted;
    }

    private static String printRemarksInHomeView(Project project) {
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
        return remarks;
    }

    private static String printMemberListHeadingInHomeView() {
        String output = "\n\n ----------------------";
        output += "\n| MEMBERS LIST         |";
        output += "\n ----------------------\n";
        output += "\nIndex   Member Name                   Projects Involved";
        output += "\n-----------------------------------------------------------------------------";
        return output;
    }

    private static String printMemberListInHomeView(ArrayList<TeamMember> teamMembers) {
        String output = "";
        int memberIndex = 1;
        for (TeamMember member : teamMembers) {
            String paddedMemberIndex = String.format("%-8s", memberIndex + ".");
            String paddedMemberName = printMemberNameInHomeView(member);
            output += "\n" + paddedMemberIndex + paddedMemberName
                    + printMemberAssignedProjectsInHomeView(member);
            output += System.lineSeparator();
            memberIndex++;
        }
        return output;
    }

    private static String printMemberNameInHomeView(TeamMember member) {
        String memberName = member.getName();
        if (member.getName().length() >= 30) {
            memberName = member.getName().substring(0, 26) + "...";
        }
        String paddedMemberName = String.format("%-30s", memberName);
        return paddedMemberName;
    }

    private static String printMemberAssignedProjectsInHomeView(TeamMember member) {
        String output = "";
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
        return output;
    }

    /**
     * Prints the home view display which consists of a project list and a member list.
     * Additional information such as project description, project deadline, remarks
     * and member's assigned project will also be displayed.
     *
     * @param projects ArrayList of Projects.
     * @param teamMembers ArrayList of TeamMembers in the program.
     * @return Home view display
     */
    public static String printHomeView(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        String output = printProjectListHeadingInHomeView();
        output += printProjectListInHomeView(projects);
        output += printMemberListHeadingInHomeView();
        output += printMemberListInHomeView(teamMembers);
        return output;
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
            String deadlineSpaces = "               "; // 16
            String prioritySpaces = "              "; // 11
            String expectedSpaces = "                 "; // 18
            String actualSpaces = "             "; // 13
            String membersSpaces = "                "; // 16
            String tableLabel = "Index  Status   Description        "
                                + "Deadline        Priority      Expected Hrs     Actual Hrs   | Members Involved\n"
                                + "------------------------------------------------"
                                + "-----------------------------------------------|------------------";
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
                        currentTaskLine += "-";
                    }

                    currentTaskLine += (deadlineSpaces.substring(0, deadlineSpaces.length() - deadline.length()));

                    int priority = currentTask.getPriority();
                    if (priority > 0) {
                        currentTaskLine += (priority);
                    } else {
                        currentTaskLine += "-";
                    }
                    currentTaskLine += (prioritySpaces.substring(0, prioritySpaces.length() - 1));

                    Integer estimate = currentTask.getEstimate();
                    if (estimate > 1) {
                        currentTaskLine += (estimate / 60);
                        extra = estimate.toString().length() - 1;
                    } else {
                        currentTaskLine += "-";
                        extra = 0;
                    }
                    currentTaskLine += (expectedSpaces.substring(0, expectedSpaces.length()
                            - estimate.toString().length() + extra));

                    Integer actual = currentTask.getActual();
                    if (actual > 1) {
                        currentTaskLine += (actual / 60);
                    } else {
                        currentTaskLine += "-";
                    }

                    extra = actual.toString().length() - 1;
                    currentTaskLine += (actualSpaces.substring(0, actualSpaces.length()
                            - actual.toString().length() + extra));

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
