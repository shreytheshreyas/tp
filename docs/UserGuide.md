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

### Project Commands
### Adding a project: `project`
Adds a new project to the project list.

Format: `project n/PROJECT_NAME`

Example of usage: 

* `project n/Web Development`. Adds the project 'Web Development'
to the project list.

### Selecting a project: `select`
Select a new project to the project list.

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
* The project must exist before it can be selected.
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
Select a new project to the project list.

Format: `delete p/PROJECT_INDEX`

* The `PROJECT_INDEX` must be a positive integer.
* The user must be in Home View before deleting a project.  

Example of usage: 

* `delete p/1`. Deletes the first project in the project list.

### Task Commands
### Adding a task: `task`
Adds a new task to task list.

Format: `task n/TASK_NAME`

Example of usage: 

* `task n/Deploy Version 2.0`. Adds the task 'Deploy Version 2.0'
to the task list.

### Selecting a task: `select`
Select a task from the project list.

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

Format: `done t/PROJECT_INDEX`

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
* The user must be in Project View before deleting a task.  

Example of usage: 

* `delete t/1`. Deletes the first task in the task list.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
