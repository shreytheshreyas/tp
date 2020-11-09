package seedu.ezmanager;

import seedu.ezmanager.commands.Command;
import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class EzManager {

    /**
     * Main entry-point for the java.duke.EZManager application.
     */
    private static ArrayList<TeamMember> teamMembers = new ArrayList<>();
    private static ArrayList<Project> projects =  new ArrayList<>();

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printWelcome();

        EzLogger.setup();

        Scanner in = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            try {
                Command commandInput = Parser.parse(in.nextLine());
                ui.printLine();
                String output = commandInput.executeCommand(projects, teamMembers);
                ui.printOutput(output);
                isExit = commandInput.isExit();
            } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | EzExceptions e) {
                System.out.println(e);
            }
            ui.printLine();
        }

    }

}
