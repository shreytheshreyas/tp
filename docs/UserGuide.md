# User Guide

## Introduction
EZ Manager is a CLI (Command Line Interface) software tool 
for Software Engineering Project Managers to manage their 
projects, tasks and team members all in one app.

## Quick Start
1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `EZ Manager` from [here](http://link.to/duke).
1. Copy the JAR  file into an empty new folder. Take note of the file path
1. Open Command Prompt (on Windows) or Terminal (n Mac) and type
java -jar {file path}/ezManager.jar

## Features 

### **Project Commands**
### Adding a project: `project`
Adds a new project to the project list.

Format: `project n/PROJECT_NAME`

* The user must be in Home View before adding a new project.  

Example of usage: 

* `project n/Web Development`. Adds the project 'Web Development'
to the project list.

### Selecting a project: `select`
Select a new project from the project list.

Format: `select p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before it can be selected.
* The user must be in Home View before selecting a project.  

Example of usage: 

* `select p/1`. Selects the first project in the project list.

### Viewing the project list: `list`
Displays all the projects in the project list.

Format: `list`

* The user must be in Home View before listing all projects.  

Example of usage: 

* `list`. Shows all the projects in the project list.

### Marking projects as done: `done`
Marks an existing project as done.

Format: `done p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before it can be marked as done.
* The user must be in Home View before marking a project
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
* The user must be in Home View before adding a deadline
to a project.  

Example of usage: 

* `deadline p/1 d/2020-10-25`. Adds the deadline 25/10/2020
to the first project.

### Adding a description to a project: `description`
***=============> NOT IMPLEMENTED AS INTENDED <=============*** .  
Adds a description to an existing project.

Format: `description p/PROJECT_INDEX d/DESCRIPTION`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist before a description can be added.
* The user must be in Home View before adding a description
to a project.  

Example of usage: 

* `description p/1 d/Project for Comapany X`. Adds the description 
`Project for Company X` to the first project.

### Deleting a project: `delete`
Delete a project from the project list.

Format: `delete p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The project must exist in the project list before it can be deleted.
* The user must be in Home View before deleting a project.  

Example of usage: 

* `delete p/1`. Deletes the first project in the project list.

### **Task Commands**
### Adding a task: `task`
Adds a new task to the task list.

Format: `task n/TASK_NAME`

* The user must be in Project View before adding a new task.  

Example of usage: 

* `task n/Deploy Version 2.0`. Adds the task 'Deploy Version 2.0'
to the task list.

### Selecting a task: `select`
Selects a task from the project list.

Format: `task p/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before it can be selected.
* The user must be in Project View before selecting a task.  

Example of usage: 

* `select t/1`. Selects the first task from the task list.

### Viewing the task list: `list`
Displays all the tasks in the task list.

Format: `list`

* The user must be Project View before listing all tasks.  

Example of usage: 

* `list`. Shows all the tasks in the task list.

### Marking a task as done: `done`
Marks an existing task as done.

Format: `done t/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before it can be selected.
* The user must be in Project View before marking a task
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
* The user must be in Project View before adding a deadline
to a task.  

Example of usage: 

* `deadline t/1 d/2020-10-25`. Adds the deadline 25/10/2020
to the first task in the task list.

### Adding a description to a task: `description`
Adds a description to an existing task.

Format: `description t/TASK_INDEX d/DESCRIPTION`

* The `TASK_INDEX` must be a positive integer.
* The task must exist before a description can be added.
* The user must be in Project View before adding a description
to a task.  

Example of usage: 

* `description p/1 d/Project for Comapany X`. Adds the description 
`Project for Company X` to the first task in the task list.

### Deleting a task: `delete`
Deletes a task from the task list.

Format: `delete t/TASK_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The task must exist in the task list before it can be deleted.
* The user must be in Project View before deleting a task.  

Example of usage: 

* `delete t/1`. Deletes the first task in the task list.

### **Member Commands**
### Adding a member: `member`
Adds a new member to the member list.

Format: `member n/MEMBER_NAME`

Example of usage: 

* `member n/John Doe`. Adds the member 'John Doe'
to the member list.

* `select t/1`. Selects the first task from the task list.

### Viewing the member list: `members`
Displays all the members in the task list.

Format: `members`

Example of usage: 

* `members`. Shows all the members in the member list.

### Assigning a member to a project: `assign`
Assigns an existing member to an existing project.

Format: `assign p/PROJECT_INDEX m/MEMBER_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The `MEMBER_INDEX` must be a positive integer.
* The project must exist before it can be assined to.
* The member must exist before they can be assined.
* The user must be in Home View before assigning
a member to a project.

Example of usage: 

* `assing p/1 m/1`. Assigns the first member in the member list
to the first project in the project list

### Assigning a member to a task: `assign`
Assigns an existing member to an existing task.

Format: `assign t/TASK_INDEX m/MEMBER_INDEX`

* The `TASK_INDEX` must be a positive integer.
* The `MEMBER_INDEX` must be a positive integer.
* The task must exist before it can be assined to.
* The member must exist before they can be assined.
* The user must be in Project View before assigning
a member to a task.

Example of usage: 

* `assing t/1 m/1`. Assigns the first member in the member list
to the first task in the task list

### Removing a member: `remove`
Removes an existing member from the member list.

Format: `remove m/MEMBER_INDEX`

* The `MEMBER_INDEX` must be a positive integer.
* The member must exist before they can be removed.

Example of usage: 

* `remove m/1`. Removes the first member from the member list.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
