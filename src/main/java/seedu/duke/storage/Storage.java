package seedu.duke.storage;

import seedu.duke.project.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static File f;
    private static ArrayList<Project> temp = new ArrayList<>();

    public Storage(String filePath) {
        f = new File("ezmanager.txt");
    }

    /*
        protected String projectName;
        protected boolean isDone;
        private ArrayList<Task> tasks;
        private String projectDescription;
        private LocalDate projectDeadline;
        private static ArrayList<TeamMember> members;
     */
    public static ArrayList<Project> loadProjects() {
        try {
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String currentLine = s.nextLine();
                String[] items = currentLine.split(" | ");
                String typeOfTask = items[0];
                boolean isCompleted = items[2].equals("1") ? true : false;
                Task newTask = null;
                // remove "T |"
                currentLine = currentLine.replace(typeOfTask + " | ", "");
                // remove completed status
                currentLine = currentLine.replace(items[2] + " | ", "");
                if (typeOfTask.trim().equalsIgnoreCase("T")) {
                    newTask = new Todo(currentLine);
                } else if (typeOfTask.trim().equalsIgnoreCase("E")) {
                    int atIndex = currentLine.indexOf("|");
                    String title = currentLine.substring(0, atIndex - 1).trim();
                    String at = currentLine.substring(atIndex + 1).trim();
                    newTask = new Event(title, at);
                } else if (typeOfTask.trim().equalsIgnoreCase("D")) {
                    int byIndex = currentLine.indexOf("|");
                    String title = currentLine.substring(0, byIndex - 1).trim();
                    String by = currentLine.substring(byIndex + 1).trim();
                    newTask = new Deadline(title, by);
                }

                temp.add(newTask);
                if (isCompleted) {
                    newTask.markAsCompleted();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return temp;
    }

}
