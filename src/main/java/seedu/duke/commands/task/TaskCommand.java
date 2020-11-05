package seedu.duke.commands.task;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TaskCommand extends Command {

    private int projectIndex;
    private String description;
    HashMap<String, String> params;

    public TaskCommand(HashMap<String, String> params, int projectIndex) throws DukeExceptions {
        assert projectIndex >= 0 : projectIndex;
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        this.description = getHashValue(params, "n");
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) {
        Project project = projects.get(projectIndex);
        Task newTask = new Task(description);
        project.addTask(newTask);
        return Ui.printTaskCreatedMessage(newTask.toString());
    }

    public Boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskCommand) {
            TaskCommand taskCommand = (TaskCommand) obj;
            return (this.description.equals(taskCommand.description)
                    && (this.projectIndex == taskCommand.projectIndex));
        } else {
            return false;
        }
    }
}
