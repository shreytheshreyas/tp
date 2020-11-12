# User Guide
## Introduction
Welcome to EZ Manager! 

EZ Manager is a CLI (Command Line Interface) software tool for Software Engineering Project Managers like yourself to manage your projects, tasks and team members in an all in one app.

With Ez Manager's command line interface, you can easily make changes and updates with a few simple keystrokes! Our app also conveniently presents the most important information at a glance with just two main views: Home View and Project View.

### How to use this guide
This guide provides a documentation of the commands in EZ Manager. 

These commands are categorised into the two main views they can be called from: Home View and Project View. 

Click on any of the links on the Table of Contents to go directly to the specific commands you want to call. 

At the end of the document, the command summary section provides a helpful summary of all of EZ Manager's commands.

:warning: : This refers to any formatting issues to look out for
when keying in the commands.

:exclamation: : This refers to any other constraints to look out for
besides formatting issues.

:bulb: : This refers to any helpful tips that might prove helpful to you.

### Structure
Under each command, a description of what the command does is provided. 

Then the format of the command is specified in a `code snippet`.

You can see an example usage of the command followed by the expected output. 

```
command PARAMETER_TYPE/VALUE
________________________________
example output
```
---
## Table of Contents
1. [Quick Start](#1-quick-start)
2. [Terminologies](#terminologies)
3. [Home View](#home-view)
    1. [Commands](#31-home-view-commands)
        1. [List: Viewing the updated Home View](#311-viewing-the-updated-home-view-list) Bg Sam
        2. [Project: Adding a project](#312-adding-a-project-project) Bg Sam
        3. [Select: Selecting a project](#313-selecting-a-project-select) Baby Sam
        4. [Done: Marking a project as done](#314-marking-a-project-as-done-done)B sam
        5. [Deadline: Adding a deadline to a project](#315-adding-a-deadline-to-a-project-deadline) bae Sam
        6. [Description: Adding a description to a project](#316-adding-a-description-to-a-project-description) Radical Riaz
        7. [Delete: Deleting a project](#317-deleting-a-project-delete) Righteous Riaz 
        8. [Member: Adding a member](#318-adding-a-member-member) Ready Riaz?
        9. [Assign: Assigning a member to a project](#319-assigning-a-member-to-a-project-assign) Ravenous Riaz
        10. [Remove: Removing a member](#3110-removing-a-member-remove) R Riaz
        11. [Hours: Hours worked by member](#3111-view-hours-worked-by-member-hours) Super Shreyas
        12. [Bye: Exit Program](#3112-exiting-ez-Manager-bye) S Shreyas
4. [Project View](#project-view)
    1. [Commands](#project-view-commands)
        1. [List: Viewing the updated Project View](#411-viewing-the-updated-project-view-list) Seductive Shreyas
        2. [Task: Adding a task](#412-adding-a-task-task) Serendepedous Shreyas
        3. [Edit: Editing a task name](#413-editing-a-task-name-edit) Shockingly Handsome Shreyas
        4. [Done: Marking a task as done](#414-marking-a-task-as-done-done) Shrelock Shreyas
        5. [Deadline: Adding a deadline to a task](#415-adding-a-deadline-to-a-task-deadline-sean) Samyang Sean
        6. [Priority: Adding a priority to a task](#416-adding-a-priority-to-a-task-priority-sean) Sexy Sean
        7. [Delete: Deleting a task](#417-deleting-a-task-delete-sean) Single Sean
        8. [Assign: Assigning a member to a task](#418-assigning-a-member-to-a-task-assign-sean) Spontaneous Sean
        9. [Remove: Removing a member from the project](#419-removing-a-member-remove-sean) Singer Sean
        10. [Estimate: Adding estimated time to a task](#4110-add-estimated-time-estimate) Sarenate Sam
        11. [Actual: Adding actual time to a task](#4111-add-actual-time-taken-actual) Sarangayou Sam
        12. [Sort: Sort tasks](#4112-sort-tasks-sort) Shag Sam
        13. [Bye: Exit Program](#4113-exiting-ez-manager-bye) Swagger McSam
5. [FAQ](#faq) Sammy the Man
6. [Command Summary](#command-summary)

## 1. Quick Start
1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `EZ Manager` from [here](https://github.com/AY2021S1-CS2113T-T09-1/tp/releases).
3. Copy the JAR  file into an empty new folder.
4. Open Command Prompt (on Windows) or Terminal (on Mac) and cd into the new folder.
5. Then type java -jar ezManager.jar to run EZ Manager.


## 2. Terminologies
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


>  :warning: Project Index, Task Index and Member Index must be positive integers.



## 3. Home View
As a project manager, you need to have a quick overview of all the projects that are under your charge.
Apart from just projects, you would want to be able to see who is working on what so that you can allocate 
work evenly across members.
The Home View does just that. You get a concise display of the full list of projects and members that are under your purview. 

At a glance, you see the most important details about your project including its status, deadline and number of tasks completed. 

The Home View also conveniently provides warnings for uncompleted tasks with imminent deadlines.


Remarks shown for each project depends on the deadline of its tasks.
1. Task not done and has an upcoming deadline due in 5 days or less - `!!!Warning!!!` and countdown to deadline shown.
2. Task not done and has deadline due in 6 days or more - Name of task and date of deadline shown. 


> ### :bulb: Accessing Home View
>
> Format: `home`
>
> Displays the Home View. If the user is in Project View, this command changes the view to Home View and 
> enables the Home View commands in this section.

Example of usage and output:

```
EZ Manager Home View

 ---------------------- 
| PROJECT LIST         |
 ---------------------- 

Index   Status   Project Name             Project Description                Deadline     Tasks Completed     Remarks
------------------------------------------------------------------------------------------------------------------------------------------------------
1.      Y        CS2113T                  EzManager App for Software Engi... 04/11/2020    3/3                -
2.      N        Home Improvement         -                                  04/09/2021    3/4                !!!WARNING!!! Task "AI Implementation" has 2 day(s) before deadline and still not done!!
3.      N        Launch Rocket            Tracking of rockets                04/03/2022    0/1                Task "Radar Sensor" has an upcoming deadline at 12/12/2020 and still not done!!


 ---------------------- 
| MEMBERS LIST         |
 ---------------------- 

Index      Member Name                        Projects Involved        Hours spent across tasks
-----------------------------------------------------------------------------------------------
1.         Sean                               1. CS2113T               5.0      

2.         Tom                                1. Home Improvement      2.5      

3.         Mike                               1. Launch Rocket         3.0      

____________________________________________________________
```



## 3.1. Home View Commands

> ### Command Format
>
> Commands are specified in the following format:
>
>> `COMMAND_TYPE`  `PARAMETER1` `PARAMETER2` ...
>
> **:bulb: Parameters can be specified in any order!**
>
> **:bulb: Commands and parameter types can be in either lowercase or uppercase** 
>
> Parameters are specified in the following format:
>
> `PARAMETER_TYPE/PARAMETER_VALUE`
>
> **:bulb: Parameter values will take in whatever that has been entered including unnecessary spacing** 



### 3.1.1. Viewing the updated Home View: `list`

After any changes, immediately see the updated view with the `list` command.

Format: `list`



### 3.1.2. Adding a project: `project`
Adds a new project to the project list.

Format: `project n/PROJECT_NAME`

>  :warning: Project names should not include slashes or an error will be shown.

Example usage and output: 

>  Adds the project 'Web Development' to the project list.

```
project n/Web Development
____________________________________________________________
Project "Web Development" created!
```
**Examples of Exception Handling for this command** (Shreyas)
> Adding a Project without providing the n/ parameter
```
project New Project
Certain Parameters are missing!
```

### 3.1.3. Selecting a project: `select`

Select a new project from the project list and brings user to Project View of specified project.

> :exclamation: The project must exist before it can be selected.

Format: `select p/PROJECT_INDEX`

Example of usage: 

> Selects the first project in the project list and displays Project View of first project.

```
select p/1
```
**Examples of Exception Handling for this command** (Shreyas)
> Adding a Project without providing the p/ parameter
```
select 1
Certain Parameters are missing!
```

> Providing Project name instead of Project index
```
select p/"Web Development"
Index must be an integer!
```

> Selecting a invalid Project-ID
```
_____________________________________________________________________________________
select p/8
_____________________________________________________________________________________
Project ID does not exist!
_____________________________________________________________________________________
```
### 3.1.4. Marking a project as done: `done`
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
**Examples of Exception Handling for this command** (Shreyas)
> Marking a project as done without the p/ parameter
```
done 1
Certain Parameters are missing!
```
> Providing Project name instead of Project index
```
done p/"p3"
Index must be an integer!
```
> Marking an invalid Project-ID as done
```
_____________________________________________________________________________________
done p/8
_____________________________________________________________________________________
Project ID does not exist!
_____________________________________________________________________________________
```
### 3.1.5. Adding a deadline to a project: `deadline`
Adds a deadline to an existing project then sorts the projects in the list according to deadline.

> :exclamation: The project must exist before a deadline can be added.

Format: `deadline p/PROJECT_INDEX d/DATE`

> :warning: The `DATE` must be of the form `YYYY-MM-DD`

Example of usage: 

>  Adds the deadline 04/03/2022 to the third project.

```
deadline p/3 d/2022-03-04
____________________________________________________________
Deadline 04/03/2022 added to Project Launch Rocket

EZ Manager Home View

 ---------------------- 
| PROJECT LIST         |
 ---------------------- 

Index   Status   Project Name             Project Description                Deadline     Tasks Completed     Remarks
------------------------------------------------------------------------------------------------------------------------------------------------------
1.      Y        CS2113T                  EzManager App for Software Engi... 04/11/2020    3/3                -
2.      N        Home Improvement         -                                  04/09/2021    3/4                !!!WARNING!!! Task "AI Implementation" has 2 day(s) before deadline and still not done!!
3.      N        Launch Rocket            Tracking of rockets                04/03/2022    0/1                Task "Radar Sensor" has an upcoming deadline at 12/12/2020 and still not done!!


 ---------------------- 
| MEMBERS LIST         |
 ---------------------- 

Index      Member Name                        Projects Involved        Hours spent across tasks
-----------------------------------------------------------------------------------------------
1.         Sean                               1. CS2113T               5.0      

2.         Tom                                1. Home Improvement      2.5      

3.         Mike                               1. Launch Rocket         3.0      

____________________________________________________________
```

> Adds an earlier deadline 12/12/2020 to the third project to show sorting of projects.

```
deadline p/3 d/2022-03-04
____________________________________________________________
Deadline 04/03/2022 added to Project Launch Rocket

EZ Manager Home View

 ---------------------- 
| PROJECT LIST         |
 ---------------------- 

Index   Status   Project Name             Project Description                Deadline     Tasks Completed     Remarks
------------------------------------------------------------------------------------------------------------------------------------------------------
1.      Y        CS2113T                  EzManager App for Software Engi... 04/11/2020    3/3                -
2.      N        Launch Rocket            Tracking of rockets                12/12/2020    0/1                Task "Radar Sensor" has an upcoming deadline at 12/12/2020 and still not done!!
3.      N        Home Improvement         -                                  04/09/2021    3/4                !!!WARNING!!! Task "AI Implementation" has 2 day(s) before deadline and still not done!!



 ---------------------- 
| MEMBERS LIST         |
 ---------------------- 

Index      Member Name                        Projects Involved        Hours spent across tasks
-----------------------------------------------------------------------------------------------
1.         Sean                               1. CS2113T               5.0      

2.         Tom                                1. Home Improvement      2.5      

3.         Mike                               1. Launch Rocket         3.0      

____________________________________________________________
```

**Examples of Exception Handling for this command** (Shreyas)
> Providing a deadline to a project in in the DD-MM-YYYY format
```
deadline p/1 d/22-11-2020
Date must be specified in format YYYY-MM-DD
```
> Providing a deadline to a project in in the MM-DD-YYYY format
```
deadline p/1 d/11-27-2020
Date must be specified in format YYYY-MM-DD
```

### 3.1.6. Adding a description to a project: `description`
Adds a description to an existing project.

>:exclamation: The project must exist before a description can be added.

Format: `description p/PROJECT_INDEX d/DESCRIPTION`

> :warning: Project descriptions should not include slashes or an error will be shown.

Example of usage: 

>  Adds the description `This is my Software Engineering Module` to the first project.

```
description p/1 d/This is my Software Engineering Module.
____________________________________________________________
Project description added "This is my Software Engineering Module.".
```

**Examples of Exception Handling for this command** (Shreyas)
>  Providing a description to the project without providing the d/ parameter
```
description p/1 this is a new project
Certain Parameters are missing!
```

### 3.1.7. Deleting a project: `delete`

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
**Examples of Exception Handling for this command** (Shreyas)
> Marking a project as done without the p/ parameter
```
delete 1
Certain Parameters are missing!
```
> Providing Project name instead of Project index
```
done p/"p3"
Index must be an integer!
```
> deleting an invalid project-ID as done
```
_____________________________________________________________________________________
deleting p/8
_____________________________________________________________________________________
Project ID does not exist!
_____________________________________________________________________________________
```

### 3.1.8. Adding a member: `member`
Adds a new member to the member list.

Format: `member n/MEMBER_NAME`

Example of usage: 

> Adds the member 'John Doe' to the member list.

```
member n/John Doe
____________________________________________________________
Team member "John Doe" has been added
```
**Examples of Exception Handling for this command** (Shreyas)
> Adding a member without the n/ parameter
```
member steve
Certain Parameters are missing!
```

### 3.1.9. Assigning a member to a project: `assign` (Shreyas)
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
**Examples of Exception Handling for this command** (Shreyas)
> Assigning a member to a project that does not exist
```
_____________________________________________________________________________________
assign m/1 p/9
_____________________________________________________________________________________
Project ID does not exist!
_____________________________________________________________________________________
```
> Assigning a member that does not exist to a project 
```
_____________________________________________________________________________________
assign m/4 p/1
_____________________________________________________________________________________
Team Member ID does not exist!
_____________________________________________________________________________________
```
    
### 3.1.10. Removing a member: `remove`
Removes an existing member from the member list as well as every project and task the member is assigned to.

> :exclamation: The member must exist before they can be removed.

Format: `remove m/MEMBER_INDEX`

Example of usage: 

>  Removes the first member from the member list.

```
remove m/1
___________________________________________________________
Team member "Mike" has been removed from program entirely
```

**Examples of Exception Handling for this command** (Shreyas)
> Removing a team member without the m/ parameter
```
remove 2
Certain Parameters are missing!
```
> Removing a team member that does not exist
```
_____________________________________________________________________________________
remove m/3
_____________________________________________________________________________________
Team Member ID does not exist!
_____________________________________________________________________________________
```
    

### 3.1.11. View hours worked by member: `hours`
View the total hours worked by a worker across all tasks assigned in all projects.

Now, you know which of your workers are overworked and be a better manager by shifting work to members who are more free!

> :exclamation: ​The member must exist before hours worked can be viewed.

Format: `hours m/MEMBER_INDEX`

Example usage and output:

```
hours m/1
-------------------------------
John worked for 2.5 hours.
```

**Examples of Exception Handling for this command** (Shreyas)
> Providing an Invalid member index 
```
_____________________________________________________________________________________
hours m/3
_____________________________________________________________________________________
The member ID entered does not exist
_____________________________________________________________________________________
```    


### 3.1.12. Exiting EZ Manager: `bye`
You can exit the program with the `bye` command.

Format: `bye`



## 4. Project View

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



## 4.1. Project View Commands

### 4.1.1. Viewing the updated Project View: `list`
Displays the updated Project View to user.

Format: `list`

### 4.1.2. Adding a task: `task`
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

**Examples of Exception Handling for this command** (Shreyas)
> Providing a task name without n/ parameter
```
task task4
Certain Parameters are missing!
```   


### 4.1.3. Editing a task name: `edit`
Updates an existing task name with the new name.

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
**Examples of Exception Handling for this command** (Shreyas)
>Editing the name of an invalid task 
```
_____________________________________________________________________________________
edit t/4 n/task4
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________

```   

### 4.1.4. Marking a task as done: `done`
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
**Examples of Exception Handling for this command** (Shreyas)
> Marking a task as done without the t/ parameter
```
done 1
Certain Parameters are missing!
```
> Providing task name instead of Project index
```
done t/"task1"
Index must be an integer!
```
> Marking an invalid task-ID as done
```
_____________________________________________________________________________________
done p/8
_____________________________________________________________________________________
Project ID does not exist!
_____________________________________________________________________________________
```
### 4.1.5. Adding a deadline to a task: `deadline` (Sean)
In a typical software engineering project, implementation of various tasks are dependent on the
completion of other tasks. Easily add deadlines to your tasks with the deadline command. Now your team
can finish tasks on time and start work on further tasks. 

Simply specify the task followed by the deadline according to the format below.

Format: `deadline t/TASK_INDEX d/DATE`

> :warning: The `DATE` must be of the form `YYYY-MM-DD`
>
> :bulb: EZManager allows you to easily sort and view tasks by deadline. (See: Deadline Command)


* The task must exist before a deadline can be added.

Example of usage: 

>  Adds the deadline 25/10/2020 to the first task in the task list.

```
deadline t/1 d/2020-10-25
____________________________________________________________
Deadline 25/10/2020 added to Task Coding
```

**Examples of Exception Handling for this command**
> Providing a deadline to a task in in the DD-MM-YYYY format
```
deadline t/1 d/22-11-2020
Date must be specified in format YYYY-MM-DD
```
> Providing a deadline to a project in in the MM-DD-YYYY format
```
deadline t/1 d/11-27-2020
Date must be specified in format YYYY-MM-DD
```

### 4.1.6. Adding a priority to a task: `priority` (Sean)
Over time, you discover new bugs add new features and your project starts to fill up with
tasks after tasks. Add priorities to tasks and ensure your team stays focused and work on the most important tasks first. 

All you have to do is specify the task index followed by the priority according to the format below.

> :bulb: 1 denotes the highest priority.
>
> :bulb: EZManager will allow you to easily sort and view these tasks by priority (See: Sort command).
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

**Examples of Exception Handling for this command** (Shreyas)
> Setting priority to an invalid task-ID
```
_____________________________________________________________________________________
priority t/4 p/1
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________
```

> Setting an invalid priority.
```
_____________________________________________________________________________________
priority t/4 p/-1
_____________________________________________________________________________________
Invalid priority! Please input a positive integer for priority.
_____________________________________________________________________________________
```

### 4.1.7. Deleting a task: `delete` (Sean)
As your project evolves, you might soon find certain tasks unnecessary or outdated. 

Easily delete a task from the task list with the delete command!

> :exclamation: The task must exist in the task list before it can be deleted.

Format: `delete t/TASK_INDEX`

Example of usage: 

> Deletes the first task in the task list.

```
delete t/1
____________________________________________________________
Task "Coding" removed!
```

**Examples of Exception Handling for this command** (Shreyas)
> Delete a task with an invalid task-ID
```
_____________________________________________________________________________________
delete t/4 
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________
```

### 4.1.8. Assigning a member to a task: `assign` (Sean)
Easily delegate work to your team members with the assign commmand! 

Now each member knows exactly what they have to do and not be overwhelmed with the full list of tasks in a project. 

Besides, EZManager allows you to assign multiple members to tasks so they can discuss and collaborate with team members 
that are assigned the same task as them! 


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

**Examples of Exception Handling for this command**
> Assigning a member to a task that does not exist
```
_____________________________________________________________________________________
assign m/1 t/11
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________
```
> Assigning a member to a task who is not assigned to the respective project 
```
_____________________________________________________________________________________
assign m/4 t/1
_____________________________________________________________________________________
Team Member ID does not exist!
_____________________________________________________________________________________
```

### 4.1.9. Removing a member: `remove` (Sean)
If you decide to remove a member from a project, it's incredibly simple! 

Easily remove a member from a project with the remove command. The member will continue to be part of your members list in
the Home View so you can assign him/her to another project instead.

> :exclamation: The member must exist before they can be removed.

Format: `remove m/MEMBER_INDEX`

Example of usage: 

>  Removes the first member from the member list.

```
remove m/1
___________________________________________________________
Team member "Mike" has been removed from Project "CS2113T"
```

**Examples of Exception Handling for this command**
> Removing a team member without the m/ parameter
```
remove 2
Certain Parameters are missing!
```
> Removing a team member that was not assigned to the respective project
```
_____________________________________________________________________________________
remove m/3
_____________________________________________________________________________________
Team Member ID does not exist!
_____________________________________________________________________________________
```



### 4.1.10. Add estimated time: `estimate`
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

**Examples of Exception Handling for this command** (Shreyas)
> Assigning a time period to a task that does not exist
```
_____________________________________________________________________________________
estimate t/11 h/6 m/30
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________
```


### 4.1.11. Add actual time taken: `actual`
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
**Examples of Exception Handling for this command** (Shreyas)
> Assigning a time period to a task that does not exist
```
_____________________________________________________________________________________
actual t/11 h/5 m/20    
_____________________________________________________________________________________
Task ID does not exist!
_____________________________________________________________________________________
```

### 4.1.12. Sort tasks: `sort` (Shreyas)

Sort tasks by priority, deadline or actual time taken.

:bulb: Highest priority of 1 will be displayed at top.

:bulb: Earliest deadline will be displayed at top.

:bulb: Shortest actual time will be displayed at top.

:bulb: Shortest estimated time will be displayed at top.

Format: `sort s/SORTING_TYPE`

* Sorting type `a` refers to actual time, `e` refers to estimated time,  `p` refers to priority and `d` refers to deadline.

Example usage and output:

```
sort s/d
____________________________________________________________
Task List sorted based on deadline
```
**Examples of Exception Handling for this command** (Shreyas)
> Using the sort functionality with the s/ parameter
```
_____________________________________________________________________________________
sort p
Certain Parameters are missing!
_____________________________________________________________________________________
```
### 4.1.13. Exiting EZ Manager: `bye`

You can exit the program with the `bye` command.

Format: `bye`

## 5. FAQ

**Q**: Does the program saves the data entered when I terminate the program abruptly? 

**A**: Yes, the program saves the data entered after every command which allows the data to be stored 
even if the program is terminated abruptly.

**Q**: How do I transfer my data to another computer? 

**A**: Simply transfer the ezmanager.txt file to another computer and run our program once to load the data.

**Q**: How long does it take to get up and running? 

**A**: Once you have the JAR file downloaded, you can run `java -jar ezmanager.jar` in the terminal 
at the specific folder the JAR file is stored and you have begun.

## 6. Command Summary

Home View Commands
![Command Summary One](https://i.ibb.co/GMgn96K/cs1.png)

Project View Commands
![Command Summary Two](https://i.ibb.co/P4z4vV4/cs2.png)
