package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static ArrayList<TeamMember> members = new ArrayList<>();
    private static ArrayList<Project> projects =  new ArrayList<>();
    private Storage storage;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            ArrayList<Project> loadedProjects = storage.load();
            for (Project project : loadedProjects) {
                projects.add(project);
            }
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public static void main(String[] args) throws DukeExceptions {
        Ui ui = new Ui();

        ui.printWelcome();
        Scanner in = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            try {
                Command commandInput = Parser.parse(in.nextLine());
                ui.printLine();
                String output = commandInput.executeCommand(projects);
                ui.printOutput(output);
                isExit = commandInput.isExit();
            } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | DukeExceptions e) {
                System.out.println(e);
            }
            ui.printLine();
        }

    }

}
