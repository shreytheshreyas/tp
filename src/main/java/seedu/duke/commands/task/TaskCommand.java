package seedu.duke.commands.task;

import seedu.duke.commands.Command;
import seedu.duke.project.Project;
import seedu.duke.project.ProjectList;
import seedu.duke.task.Task;

import java.time.LocalDate;

public class TaskCommand extends Command {

    private String description;
    private int projectIndex;

    public TaskCommand(String description, int projectIndex) {
        this.description = description;
        this.projectIndex = projectIndex;
    }

    public String executeCommand(ProjectList projects) {
        Project project = projects.getProject(projectIndex);
        Task newTask = new Task(description);
        project.createTask(newTask);
        return "Created: " + newTask.toString();
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
