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
        1. [List: Viewing the updated Home View](#viewing-the-updated-home-view-list)
        2. [Project: Adding a project](#adding-a-project-project)
        3. [Select: Selecting a project](#selecting-a-project-select)
        4. [Done: Marking a project as done](#marking-a-project-as-done-done)
        5. [Deadline: Adding a deadline to a project](#adding-a-deadline-to-a-project-deadline)
        6. [Description: Adding a description to a project](#adding-a-description-to-a-project-description)
        7. [Delete: Deleting a project](#deleting-a-project-delete)
        8. [Member: Adding a member](#adding-a-member-member)
        9. [Assign: Assigning a member to a project](#assigning-a-member-to-a-project-assign)
        10. [Remove: Removing a member](#removing-a-member-remove)
        11. [Hours: Hours worked by member](#view-hours-worked-by-member-hours)
        12. [Bye: Exit Program](#exiting-ez-Manager-bye)
4. [Project View](#project-view)
    1. [Accessing Project View](#accessing-project-view)
    2. [Commands](#project-view-commands)
        1. [List: Viewing the updated Project View](#viewing-the-updated-project-view-list)
        2. [Task: Adding a task](#adding-a-task-task)
        3. [Edit: Editing a task name](#editing-a-task-name-edit)
        4. [Done: Marking a task as done](#marking-a-task-as-done-done)
        5. [Deadline: Adding a deadline to a task](#adding-a-deadline-to-a-task-deadline)
        6. [Priority: Adding a priority to a task](#adding-a-priority-to-a-task-deadline)
        7. [Delete: Deleting a task](#deleting-a-task-delete)
        8. [Assign: Assigning a member to a task](#assigning-a-member-to-a-task-assign)
        9. [Estimate: Adding estimated time to a task](#add-estimated-time-estimate)
        10. [Actual: Adding actual time to a task](#add-actual-time-taken-actual)
        11. [Sort: Sort tasks](#sort-tasks-sort)
        11. [Bye: Exit Program](#exiting-ez-manager-bye)
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
- **Home View**: Refers to the state of the program in Home View.
In this view, you can execute project and member commands but
you cannot execute task commands.
- **Project View**: Refers to the state of the program in Project View.
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
all tasks by using the `list` command in Project View
- **MEMBER_INDEX**: Every existing member would be assigned
a positive integer. Hence, the MEMBER_INDEX refers to this
positive integer. You can retrieve the MEMBER_INDEXes of 
Members by using the `list` command in Home View or in Project View  
- **warning**: This refers to any formatting issues to look out for
when keying in the commands
- **exclamation**: This refers to any other constraints to look out for
besides formatting issues

>  :warning: Project Index, Task Index and Member Index must be positive integers.



## Home View
The Home View displays the full list of projects and members that are under a manager's purview. 
The manager can add and edit projects and members from this view.



> ### :bulb: Accessing Home View
>
> Format: `home`
>
> Displays the Home View. If the user is in Project View, this command changes the view to Home View and 
> enables the Home View commands in this section.



```
Hello! Welcome to EZ Manager!

 ---------------------- 
| PROJECT LIST         |
 ---------------------- 

Index      Project Name                       Deadline      Tasks Completed
---------------------------------------------------------------------------
1.         CS2113T                            04/11/2020    2/3            
2.         Home Improvement                   04/09/2021    3/4            
3.         Launch Rocket                      04/03/2022    0/1            

 ---------------------- 
| MEMBERS LIST         |
 ---------------------- 

Index      Member Name                        Projects Involved              
---------------------------------------------------------------------------
1.         Sean                               1. CS2113T                     

2.         Tom                                1. Home Improvement            

3.         Mike                               1. Launch Rocket               

____________________________________________________________
```



## Home View Commands

> ### Command Format
>
> Commands are specified in the following format:
>
> **:bulb: Parameters can be specified in any order!**
>
> `COMMAND_TYPE`  `PARAMETER1` `PARAMETER2` ...
>
> PARAMETERS are specified in the following format:
>
> `PARAMETER_TYPE/PARAMETER_VALUE`

### Viewing the updated Home View: `list`

Displays the updated Home View to user.

Format: `list`

### Adding a project: `project`
Adds a new project to the project list.

Format: `project n/PROJECT_NAME`

>  :warning: Project names should not include slashes as it will be disregarded.

Example usage and output: 

>  Adds the project 'Web Development' to the project list.

```
project n/new project
____________________________________________________________
Project "new project" created!
```

### Selecting a project: `select`

Select a new project from the project list and brings user to Project View of specified project.

> :exclamation: The project must exist before it can be selected.

Format: `select p/PROJECT_INDEX`

Example of usage: 

> Selects the first project in the project list and displays Project View of first project.

```
select p/1
```

### Marking a project as done: `done`
Marks an existing project as done.

> :exclamation: The project must exist before it can be marked as done.

Format: `done p/PROJECT_INDEX`

Example of usage: 

> Marks the first project in the project list as done.

```
done t/1
____________________________________________________________
Task "New Task" is done!
____________________________________________________________
```



### Adding a deadline to a project: `deadline`
Adds a deadline to an existing project.

> :exclamation: The project must exist before a deadline can be added.

Format: `deadline p/PROJECT_INDEX d/DATE`

> :warning: The `DATE` must be of the form `YYYY-MM-DD`

Example of usage: 

>  Adds the deadline 25/10/2020 to the third project.

```
deadline p/3 d/2022-03-04
____________________________________________________________
Deadline 04/03/2022 added to Project Launch Rocket
```



### Adding a description to a project: `description`
Adds a description to an existing project.

>:exclamation: The project must exist before a description can be added.

Format: `description p/PROJECT_INDEX d/DESCRIPTION`

> :warning: Project descriptions should not include slashes or an error will be shown.

Example of usage: 

>  Adds the description `Project for Company X` to the first project.

```
description p/1 d/This is my Software Engineering Module.
____________________________________________________________
Project description added "This is my Software Engineering Module.".
```



### Deleting a project: `delete`

Delete a project from the project list.

Format: `delete p/PROJECT_INDEX`

> :exclamation:  The project must exist in the project list before it can be deleted.

Example of usage: 

* Deletes the first project in the project list.

```
delete p/2
____________________________________________________________
Project "Home Improvement" deleted
____________________________________________________________
```

### Adding a member: `member`
Adds a new member to the member list.

Format: `member n/MEMBER_NAME`

Example of usage: 

> Adds the member 'John Doe' to the member list.

```
member n/John Doe
____________________________________________________________
Team member "John Doe" has been added
```



### Assigning a member to a project: `assign`
Assigns an existing member to an existing project.

> :exclamation: The project must exist before it can be assigned a member.
>
> :exclamation: The member must exist before they can be assigned a project.

Format: `assign p/PROJECT_INDEX m/MEMBER_INDEX`

Example of usage: 

> Assigns the first member in the member list to the first project in the project list

```
assign p/1 m/1
____________________________________________________________
Tom assigned to Project "CS2113T"
```



### Removing a member: `remove`
Removes an existing member from the member list.

> :exclamation: The member must exist before they can be removed.

Format: `remove m/MEMBER_INDEX`

Example of usage: 

>  Removes the first member from the member list.

```
remove m/1
___________________________________________________________
Team member "Mike" has been removed
```



### View hours worked by member: `hours`
View the total hours worked by a worker across all tasks assigned in all projects.

> :exclamation: ​The member must exist before hours worked can be viewed.

Format: `hours m/MEMBER_INDEX`

Example usage and output:

```
hours m/1
-------------------------------
John worked for 2.5 hours.
```

### Exiting EZ Manager: `bye`
You can exit the program with the `bye` command.

Format: `bye`



## Project View

The Project View displays the full list of tasks and members in a particular project.
The manager can add and edit tasks and assign members to tasks.



> ### :bulb: Accessing Project View
>
> This view is accessed by [selecting a project](#selecting-a-project-select) from the Home View.



```
Project "CS2113T"

Description:
This is my Software Engineering Module.

 ---------------------
| TASK LIST           |
 ---------------------
Index  Status   Description        Deadline        Priority      Expected Hrs     Actual Hrs   | Members Involved
-----------------------------------------------------------------------------------------------|----------------
1      (Y)      Coding             04/11/2020      -             -                 -           |Sean|Tom|
2      (Y)      Testing            12/11/2021      -             -                 -             
3      (N)      Code Review        -               -             -                 -           |Mike|

 

 ---------------------
| MEMBERS LIST        |
 ---------------------
1. Sean
2. Tom
3. Mike

____________________________________________________________
```



## Project View Commands

### Viewing the updated Project View: `list`
Displays the updated Project View to user.

Format: `list`

### Adding a task: `task`
Adds a new task to the task list.

Format: `task n/TASK_NAME`

> :warning: Task names should not include slashes or it will be disregarded.

Example of usage: 

>  Adds the task 'Deploy Version 2.0' to the task list.

```
task n/Deploy Version 2.0
____________________________________________________________
Task "Deploy Version 2.0" created!
```

### Editing a task name: `edit`
Updates an existing task name with the new name

Format: `edit t/TASK_INDEX n/NEW_TASK_NAME`

> :warning: Task names should not include slashes or it will be disregarded.  
> :warning: The `TASK_INDEX` must be a positive integer.

Example of usage: 

>  Edits the existing task, `Read documentation` to `Update documentation`.

```
task n/Read documentation
____________________________________________________________
Task "Read documentation" created!
____________________________________________________________
edit t/1 n/Update documentation
____________________________________________________________
Task "Read documentation" has been updated to "Update documentation"
```


### Marking a task as done: `done`
Marks an existing task as done.

> :exclamation: The task must exist before it can be selected.

Format: `done t/TASK_INDEX`

Example of usage: 

> Marks the first task in the task list as done.

```
done t/1 
____________________________________________________________
Task "Coding" is done!
```

### Adding a deadline to a task: `deadline`
Adds a deadline to an existing task.

Format: `deadline t/TASK_INDEX d/DATE`

> :warning: The `DATE` must be of the form `YYYY-MM-DD`


* The task must exist before a deadline can be added.

Example of usage: 

>  Adds the deadline 25/10/2020 to the first task in the task list.

```
deadline t/1 d/2020-10-25
____________________________________________________________
Deadline 25/10/2020 added to Task Coding
```



### Adding a priority to a task: `priority`
Adds a priority to an existing task.

> :bulb: 1 denotes the highest priority.
>
> :exclamation: The task must exist before a deadline can be added.

Format: `priority t/TASK_INDEX p/PRIORITY`

:warning: The `PRIORITY` must be a positive integer.

Example of usage: 

> Adds the highest priority, 1, to the first task in the task list.

```
priority t/1 p/1
____________________________________________________________
Priority "1" has been assigned to "Coding"
```



### Deleting a task: `delete`
Deletes a task from the task list.

> :exclamation: The task must exist in the task list before it can be deleted.

Format: `delete t/TASK_INDEX`

Example of usage: 

> Deletes the first task in the task list.

```
delete t/1
____________________________________________________________
Task "Coding" removed!
```

### Assigning a member to a task: `assign`
Assigns an existing member to an existing task.

> :exclamation: Members must belong to a project before they can be assigned tasks.

Format: `assign t/TASK_INDEX m/MEMBER_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The `MEMBER_INDEX` must be a positive integer.
* The task must exist before it can be assigned a member.

Example of usage: 

> Assigns the first member in the member list to the first task in the task list

```
assign m/1 t/1
____________________________________________________________
Member "Tom" has been assigned to "Code Review"
```

### Add estimated time: `estimate`
Add estimated time taken for task to complete.

Format: `estimate t/TASK_INDEX h/HOURS m/MINUTES`

> :warning:  `HOURS` and `MINUTES ` must both be positive numbers.
>


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

> :warning:  `HOURS` and `MINUTES   `  must both be positive numbers.


Example usage and output:

```
done t/1
actual t/1 h/12 m/30
____________________________________________________________
Task "New Task" took 12 hours and 30 minutes to be completed.

```

### Sort tasks: `sort`

Sort tasks by priority, deadline or actual time taken.

:bulb: Highest priority of 1 will be displayed at top.

:bulb: Earliest deadline will be displayed at top.

:bulb: Shortest actual time will be displayed at top.

Format: `sort s/SORTING_TYPE`

* Sorting type `t` refers to actual time, `p` refers to priority and `d` refers to deadline.

Example usage and output:

```
sort s/d
____________________________________________________________
Tasklist sorted based on deadline
```

### Exiting EZ Manager: `bye`

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
| edit    | Edits an existing task name in the task list in Project View| `edit t/1 n/Update documentation` |
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
