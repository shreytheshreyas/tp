# User Guide
This user guide will explain how to use the software tool,
EZ Manager. You can navigate to the different sections of
this guide using the Table of Content. Each content is linked
to its respective sections. 

## Introduction
EZ Manager is a CLI (Command Line Interface) software tool 
for Software Engineering Project Managers to manage their 
projects, tasks and team members all in one app.

## Table of Contents
1. [Quick Start](#quick-start)
2. [Terminologies](#terminologies)
3. [Home View](#home-view)
    1. [Accessing Home View](#accessing-home-view)
    2. [Commands](#home-view-commands)
        1. [Viewing the updated Home View](#viewing-the-updated-home-view-list)
        2. [Adding a project](#adding-a-project-project)
        3. [Selecting a project](#selecting-a-project-select)
        4. [Marking a project as done](#marking-a-project-as-done-done)
        5. [Adding a deadline to a project](#adding-a-deadline-to-a-project-deadline)
        6. [Adding a description to a project](#adding-a-description-to-a-project-description)
        7. [Deleting a project](#deleting-a-project-delete)
        8. [Adding a member](#adding-a-member-member)
        9. [Assigning a member to a project](#assigning-a-member-to-a-project-assign)
        10. [Removing a member](#removing-a-member-remove)
        11. [Hours worked by member](#view-hours-worked-by-member-hours)
4. [Project View](#project-view)
    1. [Accessing Project View](#accessing-project-view)
    2. [Commands](#project-view-commands)
        1. [Viewing the updated Project View](#viewing-the-updated-project-view-list)
        2. [Adding a task](#adding-a-task-task)
        3. [Selecting a task](#selecting-a-task-select)
        4. [Marking a task as done](#marking-a-task-as-done-done)
        5. [Adding a deadline to a task](#adding-a-deadline-to-a-task-deadline)
        6. [Adding a priority to a task](#adding-a-priority-to-a-task-deadline)
        7. [Deleting a task](#deleting-a-task-delete)
        8. [Assigning a member to a task](#assigning-a-member-to-a-task-assign)
        9. [Adding estimated time to a task](#add-estimated-time-estimate)
        10. [Adding actual time to a task](#add-actual-time-taken-actual)
        11. [Sort tasks](#sort-tasks-sort)
5. [Exiting EZ Manager](#exiting-ez-manager)
6. [FAQ](#faq)
7. [Command Summary](#command-summary)

## Quick Start
1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `EZ Manager` from [here](https://github.com/AY2021S1-CS2113T-T09-1/tp/releases).
1. Copy the JAR  file into an empty new folder. Take note of the file path
1. Open Command Prompt (on Windows) or Terminal (on Mac) and type
java -jar {file path}/ezManager.jar

## Terminologies
- **HomeView**: Refers to the state of the program in HomeView.
In this view, you can execute project and member commands but
you cannot execute task commands.

- **ProjectView**: Refers to the state of the program in ProjectView.
In this view, you can execute task and member commands but
you cannot execute project commands.

- **Project list**: Refers to the list of projects currently
existing in the system

- **Task list**: Refers to the list of tasks currently
existing in the system

- **Member list**: Refers to the list of members currently
existing in the system

- **PROJECT_INDEX**: Every existing project would be assigned
a positive integer. Hence, the PROJECT_INDEX refers to this
positive integer. You can retrieve the PROJECT_INDEXes of 
all projects by using the `list` command in HomeView

- **TASK_INDEX**: Every existing task would be assigned
a positive integer. Hence, the TASK_INDEX refers to this
positive integer. You can retrieve the TASK_INDEXes of 
all tasks by using the `list` command in ProjectView

## Home View
The Home View displays the full list of projects and members that are under a manager's purview. 
The manager can add and edit projects and members from this view.

![](HomeViewScreenshot.png?raw=true)

### Accessing Home View
Displays the Home View. If the user is in Project View, this command changes the view to Home View and 
enables the Home View commands in this section.

Format: `home`

### Home View Commands
### Viewing the updated Home View: `list`
Displays the updated Home View to user.

Format: `list`

### Adding a project: `project`
Adds a new project to the project list.

Format: `project n/PROJECT_NAME`

* You must be in HomeView before adding a new project.  

Example of usage: 

* `project n/Web Development`. Adds the project 'Web Development'
to the project list.

> :warning: Project names should not include slashes or an error will be shown.

### Selecting a project: `select`
Select a new project from the project list.

Format: `select p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before it can be selected.
* You must be in HomeView before selecting a project.  

Example of usage: 

* `select p/1`. Selects the first project in the project list.

### Marking a project as done: `done`
Marks an existing project as done.

Format: `done p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before it can be marked as done.
* You must be in HomeView before marking a project
as done.  

Example of usage: 

* `done p/1`. Marks the first project in the project list 
as done.

### Adding a deadline to a project: `deadline`
Adds a deadline to an existing project.

Format: `deadline p/PROJECT_INDEX d/DATE`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before a deadline can be added.
* The `DATE` must be of the form `YYYY-MM-DD`
* You must be in HomeView before adding a deadline
to a project.  

Example of usage: 

* `deadline p/1 d/2020-10-25`. Adds the deadline 25/10/2020
to the first project.

### Adding a description to a project: `description`
Adds a description to an existing project.

Format: `description p/PROJECT_INDEX d/DESCRIPTION`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before a description can be added.
* You must be in HomeView before adding a description to a project.  

Example of usage: 

* `description p/1 d/Project for Company X`. Adds the description 
`Project for Company X` to the first project.

### Deleting a project: `delete`
Delete a project from the project list.

Format: `delete p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist in the project list before it can be deleted.
* You must be in HomeView before deleting a project.  

Example of usage: 

* `delete p/1`. Deletes the first project in the project list.

### Adding a member: `member`
Adds a new member to the member list.

Format: `member n/MEMBER_NAME`

Example of usage: 

* `member n/John Doe`. Adds the member 'John Doe'
to the member list.

* `select t/1`. Selects the first task from the task list.

### Assigning a member to a project: `assign`
Assigns an existing member to an existing project.

Format: `assign p/PROJECT_INDEX m/MEMBER_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The `MEMBER_INDEX` must be a positive integer.
* The project must exist before it can be assined to.
* The member must exist before they can be assined.
* You must be in HomeView before assigning
a member to a project.

Example of usage: 

* `assign p/1 m/1`. Assigns the first member in the member list
to the first project in the project list

### Removing a member: `remove`
Removes an existing member from the member list.

Format: `remove m/MEMBER_INDEX`

* The `MEMBER_INDEX` must be a positive integer.
* The member must exist before they can be removed.

Example of usage: 

* `remove m/1`. Removes the first member from the member list.

### View hours worked by member: `hours`
View the total hours worked by a worker across all tasks assigned in all projects.

Format: `hours m/MEMBER_INDEX`

* The `MEMBER_INDEX` must be a positive integer.
* The member must exist before hours worked can be viewed.

Example usage and output:

```
hours m/1
-------------------------------
John worked for 2.5 hours.
```

### Exiting Ez Manager: `bye`
You can exit the program with the `bye` command.

Format: `bye`

## Project View
The Project View displays the full list of tasks and members in a particular project.
The manager can add and edit tasks and assign members to tasks.

### Accessing Project View
This view is accessed by [selecting a project](#selecting-a-project-select) from the Home View.

### Project View Commands
### Viewing the updated Project View: `list`
Displays the updated project View to user.

Format: `list`

### Adding a task: `task`
Adds a new task to the task list.

Format: `task n/TASK_NAME`

* You must be in ProjectView before adding a new task.  

> :warning: Task names should not include slashes or an error will be shown.

Example of usage: 

* `task n/Deploy Version 2.0`. Adds the task 'Deploy Version 2.0'
to the task list.

### Selecting a task: `select`
Selects a task from the project list.

Format: `select t/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before it can be selected.
* You must be in ProjectView before selecting a task.  

Example of usage: 

* `select t/1`. Selects the first task from the task list.

### Viewing the task list: `list`
Displays all the tasks in the task list.

Format: `list`

* You must be Project View before listing all tasks.  

Example of usage: 

* `list`. Shows all the tasks in the task list.

### Marking a task as done: `done`
Marks an existing task as done.

Format: `done t/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before it can be selected.
* You must be in ProjectView before marking a task
as done.  

Example of usage: 

* `done t/1`. Marks the first task in the task list 
as done.

### Adding a deadline to a task: `deadline`
Adds a deadline to an existing task.

Format: `deadline t/TASK_INDEX d/DATE`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before a deadline can be added.
* The `DATE` must be of the form `YYYY-MM-DD`
* You must be in ProjectView before adding a deadline
to a task.  

Example of usage: 

* `deadline t/1 d/2020-10-25`. Adds the deadline 25/10/2020
to the first task in the task list.

### Adding a priority to a task: `priority`
Adds a priority to an existing task.
1 denotes the highest priority.

Format: `priority t/TASK_INDEX p/PRIORITY`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before a deadline can be added.
* The `PRIORITY` must be a positive interger.
* You must be in ProjectView before adding a deadline
to a task.  

Example of usage: 

* `priority t/1 p/1`. Adds the highest priority, 1,
to the first task in the task list.

### Deleting a task: `delete`
Deletes a task from the task list.

Format: `delete t/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist in the task list before it can be deleted.
* You must be in ProjectView before deleting a task.  

Example of usage: 

* `delete t/1`. Deletes the first task in the task list.

### Assigning a member to a task: `assign`
Assigns an existing member to an existing task.

Format: `assign t/TASK_INDEX m/MEMBER_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The `MEMBER_INDEX` must be a positive integer.
* The task must exist before it can be assigned a member.
* The member must exist before they can be assined.
* You must be in ProjectView before assigning
a member to a task.

Example of usage: 

* `assign t/1 m/1`. Assigns the first member in the member list
to the first task in the task list

### Sort tasks: `sort`
Sort tasks by priority, deadline or actual time taken.

Format: `sort s/SORTING_TYPE`

* Sorting type `t` refers to actual time, `p` refers to priority and `d` refers to deadline.
* Sorted list can be viewed with `list` command.
* Highest priority of 1 will be displayed at top.
* Earliest deadline will be displayed at top.

Example usage and output:

```
sort s/d
____________________________________________________________
Tasklist sorted based on deadline
```

### Add estimated time: `estimate`
Add estimated time taken for task to complete.

Format: `estimate t/TASK_INDEX h/HOURS m/MINUTES`

* `TASK_INDEX` must be a positive index.
* `HOURS` must be a positive index.
* `MINUTES` must be a positive index.


Example usage and output:

```
estimate t/1 h/12 m/30
____________________________________________________________
Task "New Task" has estimated time of 12 hours and 30 minutes

```

### Add actual time taken: `actual`
Add actual time taken for task to complete.

> :exclamation: Task must be marked as done before actual time taken can be added.

Format: `actual t/TASK_INDEX h/HOURS m/MINUTES`

* `TASK_INDEX` must be a positive index.
* `HOURS` must be a positive index.
* `MINUTES` must be a positive index.


Example usage and output:

```
done t/1
actual t/1 h/12 m/30
____________________________________________________________
Task "New Task" took 12 hours and 30 minutes to be completed.

```

### Exiting Ez Manager: `bye`
You can exit the program with the `bye` command.

Format: `bye`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

Home View Commands
| Commands | Action | Examples |
| -------- | ------ | -------- |
| project | Creates a new project in the project list in Home View | `project n/Web Development Project` |
| member  | Creates a new member in the member list | `member n/John Doe` |
| list    | Displays the updated Home View | `list` |  
| select  | Selects the specified project and program enters ProjectView | `select p/1` |  
| done    | Marks the specified project as done | `done p/1` |  
| delete  | Deletes the specified project | `delete p/1` |  
| description | Assigns a description to the specified project | `description p/1 d/Project for Company X` |  
| deadline | Assigns a deadline to the specified project | `deadline p/1 d/2020-10-25` |  
| assign  | Assigns member to specified project | `assign p/1 m/1` |  
| remove  | Removes specified member from the member list | `remove m/1` |
| hours  | View hours worked by a specific worker across all projects | `hours m/1` |
| bye  | Exit EZ Manager | `bye` |

Project View Commands
| Commands | Action | Examples |
| -------- | ------ | -------- |
| task    | Creates a new task in the task list in Project View| `task n/Deploy Version 2.0` |
| list    | Displays the updated Project View | `list` |
| select  | Selects the specified task | `select t/1` |
| done    | Marks the specified task as done | `done t/1` |
| delete  | Deletes the specified task | `delete t/1` |
| deadline | Assigns a deadline to the specified task | `deadline t/1 d/2020-10-25` |
| priority | Assigns a priority to the specified task | `priority t/1 p/1` |
| home    | Switches from ProjectView to HomeView | `home` |
| assign  | Assigns member to specified task | `assign t/1 m/1` |
| estimate  | Add estimated time taken for task to complete | `estimate t/1 h/3 m/20` |
| actual  | Add actual time taken for task to complete | `actual t/1 h/3 m/20` |
| sort  | Sort tasks based on sorting type | `sort s/p` |
| bye  | Exit EZ Manager | `bye` |
