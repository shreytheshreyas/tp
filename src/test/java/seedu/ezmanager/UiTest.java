package seedu.ezmanager;

import org.junit.jupiter.api.Test;

import seedu.ezmanager.member.TeamMember;
import seedu.ezmanager.project.Project;
import seedu.ezmanager.task.Task;
import seedu.ezmanager.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static HashMap<String, String> params;
    static Ui ui = new Ui();

    /**
     * Display friendly message when there are no members assigned
     * or no tasks in the project.
     */
    @Test
    void empty_project_view() throws EzExceptions {
        Project projectOne = new Project("Project One");
        String actualOutput = Ui.projectViewMessage(projectOne);
        String expectedOutput = "Project \"Project One\"\n"
                + "\n"
                + "Description:\n"
                + "<project description empty>\n"
                + "\n"
                + " ---------------------\n"
                + "| TASK LIST           |\n"
                + " ---------------------\n"
                + "\n"
                + "No tasks have been added to this project.\n"
                + " \n"
                + "\n"
                + " ---------------------\n"
                + "| MEMBERS LIST        |\n"
                + " ---------------------\n"
                + "No team members have been assigned to this project.";
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Check output when a new task has been added
     */
    @Test
    void new_task_added() throws EzExceptions {
        Project projectOne = new Project("Project One");
        Task newTask = new Task("First Task");
        projectOne.addTask(newTask);
        String actualOutput = Ui.projectViewMessage(projectOne);
        String expectedOutput = "Project \"Project One\"\n"
                + "\n"
                + "Description:\n"
                + "<project description empty>\n"
                + "\n"
                + " ---------------------\n"
                + "| TASK LIST           |\n"
                + " ---------------------\n"
                + "Index  Status   Description        Deadline        Priority      Estimated Hrs     Actual Hrs   | Members Involved\n"
                + "------------------------------------------------------------------------------------------------|------------------\n"
                + "1      (N)      First Task         -               -             -                 -            | -\n"
                + "\n"
                + " \n"
                + "\n"
                + " ---------------------\n"
                + "| MEMBERS LIST        |\n"
                + " ---------------------\n"
                + "No team members have been assigned to this project.";
        assertEquals(expectedOutput, actualOutput);
    }


}