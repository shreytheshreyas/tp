package seedu.duke.storage;

import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static File f;
    private static ArrayList<Project> temp = new ArrayList<>();

    public Storage(String filePath) {
        f = new File(filePath);
    }

    /*
        protected String projectName;
        protected boolean isDone;
        private ArrayList<Task> tasks;
        private String projectDescription;
        private LocalDate projectDeadline;
        private static ArrayList<TeamMember> members;
     */
    public static ArrayList<Project> loadProjects(ArrayList<TeamMember> members) throws DukeExceptions {
        try {
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            ArrayList<Project> projects = new ArrayList<>();
            while (s.hasNext()) {
                String currentLine = s.nextLine();
                if (currentLine.contains("Project")) {
                    String projectName = currentLine.replaceFirst("Project", "").trim();
                    boolean status = Boolean.parseBoolean(s.nextLine().split(" ")[1]);
                    String projectDescription = s.nextLine().replaceFirst("projectDescription", "");
                    String deadline = s.nextLine().replaceFirst("projectDeadline", "").trim();
                    LocalDate deadlineDate = LocalDate.parse(deadline);
                    Project newProject = new Project(projectName);
                    // TODO: set the projects stuff
                    newProject.addProjectDeadline(deadlineDate);


                    // begin adding tasks to project
                    currentLine = s.nextLine().trim();
                    while (!currentLine.equals("endTasks")) {
                        if (currentLine.equals("startTasks")) {
                            currentLine = s.nextLine();
                            continue;
                        }

                        int taskDescriptionEndIndex = currentLine.indexOf("|");

                        Task newTask = new Task(currentLine.substring(0, taskDescriptionEndIndex - 1).trim());
                        String taskString = currentLine.substring(taskDescriptionEndIndex + 2);
                        if (currentLine.length() > 9) {
                            newTask.addDeadline(LocalDate.parse(taskString.substring(0, 10)));
                        }

                        taskString = taskString.substring(taskString.indexOf("|") + 1);
                        if (currentLine.length() > 1) {
                            for (TeamMember member : members) {
                                if (member.getName().equals(taskString.trim())) {
                                    newTask.setMember(member);
                                }
                            }
                        }

                        taskString = taskString.replace("estimateInMinutesStart", "");
                        int estimateInMinutesEndIndex = taskString.indexOf("estimateInMinutesEnd");
                        if (estimateInMinutesEndIndex != -1) {
                            String estimate = taskString.substring(0, estimateInMinutesEndIndex);
                            if (estimate.length() > 1) {
                                newTask.addEstimate(Integer.parseInt(estimate.trim()));
                            }
                        }

                        taskString = taskString.substring(estimateInMinutesEndIndex + 20);
                        taskString = taskString.replace("| actualInMinutesStart", "");
                        if (taskString.indexOf("actualInMinutesEnd") != -1) {
                            String estimate = taskString.substring(0, taskString.indexOf("actualInMinutesEnd"));
                            if (estimate.length() > 1) {
                                newTask.addActual(Integer.parseInt(estimate.trim()));
                            }
                        }


                        newProject.addTask(newTask);
                        currentLine = s.nextLine();
                    }
                    // end adding tasks to project

                    projects.add(newProject);
                    s.nextLine();
                }
            }
            return projects;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return temp;
    }

    public ArrayList<TeamMember> loadTeamMembers() {
        try {
            Scanner s = new Scanner(f);
            String currentLine = s.nextLine();
            ArrayList<TeamMember> members = new ArrayList<>();

            while (!currentLine.equals("Project") && currentLine.length() > 1) {
                if (currentLine.trim().equals("Members")) {
                    currentLine = s.nextLine();
                    continue;
                }
                TeamMember newMember = new TeamMember(currentLine.trim());
                members.add(newMember);
                currentLine = s.nextLine();
            }

            return members;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void save(ArrayList<Project> projects, ArrayList<TeamMember> members) {
        try {
            // empty current saved items;
            FileWriter clear = new FileWriter(f);
            clear.write("");
            clear.close();
            int i;
            FileWriter fw = new FileWriter(f, true);
            fw.write("Members \n");
            for (TeamMember member : members) {
                fw.write(member.saveFormat() + "\n");
            }

            fw.write("\n");

            for (i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                fw.write(project.saveFormat() + "\n");
                fw.close();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
