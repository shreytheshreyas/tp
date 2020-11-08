package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static ArrayList<TeamMember> teamMembers = new ArrayList<>();
    private static ArrayList<Project> projects =  new ArrayList<>();
    private Storage storage;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            ArrayList<TeamMember> loadedMembers = storage.loadTeamMembers();
            for (TeamMember member : loadedMembers) {
                teamMembers.add(member);
            }

            ArrayList<Project> loadedProjects = storage.loadProjects(teamMembers);
            for (Project project : loadedProjects) {
                projects.add(project);
            }

        } catch (DukeExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public static void run() {
        Ui ui = new Ui();

        // ui.printWelcome();
        Scanner in = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            try {
                Command commandInput = Parser.parse(in.nextLine());
                ui.printLine();
                String output = commandInput.executeCommand(projects, teamMembers);
                ui.printOutput(output);
                Storage.save(projects, teamMembers);
                isExit = commandInput.isExit();
            } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException
                    | DukeExceptions | IOException e) {
                System.out.println(e);
            }
            ui.printLine();
        }

        try {
            Storage.save(projects, teamMembers);
        } catch (IOException e) {
            System.err.println("Couldn't save before terminating.");
        }

    }

    public static void main(String[] args) throws DukeExceptions {
        new Duke("ezmanager.txt").run();
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Storage.save(projects, teamMembers);
            } catch (IOException e) {
                System.err.println("Couldn't save before terminating.");
            }
        }));

    }

}
