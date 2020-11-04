# Developer Guide

## Welcome to EZ Manager
![EZ Manager Welcome](https://i.ibb.co/n7zphMR/ezmanagerterminal.png)

## Changelog
Identifier | Changes | Date
---------- | ------------------- | ----
A | Incorporated feedback from CS2101 review <ul><li>Include table of content</li><li>Include preface for sections</li><li>Add introductory sections</li><li> Address the reader directly – “You”</li></ul> | 29 October 2020
B | 

## Table of Contents
- [Introduction — Welcome to EZ Manager](#introduction)
- [Setting Up](#setting-up)
- Design 
- Implementation
- Testing
- Dev Ops
  - Making A Release
- Appendices
  - Appendix A: Product Scope
  - Appendix B: User Stories
  - Appendix C: Commands Summary
  - Appendix D: Instructions for Manual Testing
 
## Introduction 
The EZ Manager command line application designed to help you get more done as a Software Engineering Project Manager. Organize your projects, keep track of team members and analyze the tasks pertaining to your projects.

This guideis designed to help you understand the inner workings of EZ Manager from the first steps of setting up the project to the high-level application structures and even the sequence of operations when a command is triggered.

Let us hit the ground running with the next section about setting up!

## Setting Up 
**Prerequisites**
1. Java Development Kit (JDK) version 11 and above. [Here](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A) is an installation guide for JDK 11.
2. The Intellij Intergrated Development Environment (IDE). [Here](https://www.jetbrains.com/help/idea/installation-guide.html) is an installation guidefor Intellij.

**Setting up the project on your computer**
1. Fork this repo, and clone the fork to your computer
2. Open IntelliJ (if you are not in the welcome screen, click `File > Close Project` to close the existing project dialog first)
3. Set up the correct JDK version for Gradle
  a. Go to `File > Project Structure`, then select Project and ensure that the Project SDK is Java 11.
  b. Else, click `New...` and find the directory of the JDK
4. Click `Import Project`
5. Locate the `build.gradlefile` and select it. Click `OK`
6. Click `Open as Project`
7. Click `OK` to accept the default settings
8. After the importing is complete, verify that the project is working, locate the `src/main/java/seedu/duke/Duke.javafile`, right-click it, and choose `Run Duke.main()`. 

If the setup is correct, you should see the welcome screen and greeting.



Thank you for taking the time to test out EZ Manager. [Here](https://www.loom.com/share/f64bb5fd4b7a4089b31a96ddc8e1ea79) is a quick video to introduce you to some of the commands you can use on EZ Manager v2.0.

PDF developer guide available [here](https://we.tl/t-UkcnzA4i8P)

**User Stories**

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

Priority | As a ... | I want to ... | So that I can ...
---------- | ------------ | ------------------- | -------------------
`***` | new user | see usage instructions | refer to the commands when I forget how to use the App
`***` | project manager | add a new project | track the progress of my new project 
`***` | project manager | add tasks under a project | track the project tasks needed to finish the project
`***` | project manager | add a new member | manage members in my team 
`***` | project manager | select a project | go into a particular project to make changes such as adding tasks and deadline specific to the project
`***` | project manager | navigate between home view and project view | switch from one project to the other project
`***` | project manager | delete an existing project | remove projects that are not required anymore
`***` | project manager | delete an existing task | remove tasks that are not required anymore
`***` | project manager | remove an existing member | remove members that have left the team
`***` | project manager | add a deadline to an existing project | keep the project on track and deliver the product on time
`***` | project manager | add a deadline to an existing task | keep the task on track and finish it on time
`***` | project manager | mark completed projects as done | see which projects are done and which still needs to be done
`***` | project manager | mark completed tasks as done | see which tasks are done and which still needs to be done
`***` | project manager | add a project description | have a better understanding of the concept and context of the project
`***` | project manager | add a task description | have a better understand of the task and know what needs to be done
`***` | project manager | assign a member to a project | allocate projects to team members 
`***` | project manager | assign a member to a task | allocate equal workload to every team member
`***` | project manager | assign priority to a task | organise the tasks in order of priority and focus on those that are more urgent
`**` | project manager | assign estimated time needed to complete a task | give my team a rough estimate of how long is expected for them to finish the task
`**` | project manager | assign actual time used to complete a task | find out the amount of time spent and understand which task is taking more time than expected
`**` | project manager | display all the projects and members all in one view | have an overview of all the projects and members
`**` | project manager | display all the tasks and members allocated to the project all in one view | have an overview of the unfinished tasks and members assigned to those tasks
`**` | project manager | sort my list of projects in terms of deadline | prioritise projects that are urgent and focus on completing the project before the deadline
`**` | project manager | sort my list of tasks in terms of deadline | focus on the tasks that have a closer deadline
`**` | project manager | sort my list of tasks in terms of priority | focus on the tasks that are most important as some are base level tasks which are required for the project to be up and running
`**` | project manager | sort my list of tasks in terms of actual time spent | have an overview of which tasks are taking up more time and required more manpower in the future
`*` | project manager | add the roles of my team members | allocate appropriate tasks to appropriate members
`*` | project manager | send out reminders to my team members | have them shift gears or change something in real time  









