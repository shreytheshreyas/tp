package seedu.duke;

import java.util.HashMap;
public class DukeExceptions extends Exception {

    private final static HashMap<String,String> exceptionMessages = new HashMap<>(); // Made use of HashMap collection

    DukeExceptions() {

        //UI Exceptions
        exceptionMessages.put("Project","Command incomplete!, You need to include a project description.");
        exceptionMessages.put("Delete Project","Command incomplete! You need to mention the project Id");
        exceptionMessages.put("Task Description","Command incomplete!, You need to include a task description.");
        exceptionMessages.put("Member","Command incomplete! You need to mention Member's name");
        exceptionMessages.put("Delete Task","Command incomplete! You need to mention the project Id");
        exceptionMessages.put("Switch","You are already in project view");
        exceptionMessages.put("Add Project","You cannot add tasks in project view");
        exceptionMessages.put("Add Task","You cannot add projects in task view");
        //file handler exceptions
        exceptionMessages.put("Create File","The file could not be created");
        exceptionMessages.put("Open File","The file could not be opened");
        exceptionMessages.put("default","☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void uiExceptionType(String type) throws Exception {
        throw new Exception(exceptionMessages.get(type));
    }

  /*  public void uiExceptionType(String type, boolean isProjectView) throws Exception{
        if(isProjectView) {
            throw new Exception(exceptionMessages.get("Add Project"));
        } else {
            throw new Exception(exceptionMessages.get("Add Task"));
        }
    }*/

    public void fileExceptionType(String type) {
        System.out.println(exceptionMessages.get(type));
    }
    public String toString() {
        return "ERROR";
    }
}
