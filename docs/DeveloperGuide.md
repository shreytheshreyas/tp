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

## Design
Developers are welcome to contribute by submitting issues or pull requests on our repository. The design section is a good place to start learning about EZ Manager’s architecture and various components. Most developers will contribute to the app mainly through addition of new user commands. The section “Addition of new commands” will provide a step-by-step walkthrough to ensure new commands follow the overall architecture. Figure 2 below shows the overall class diagram for EZ Manager.  

### Consideration
Eazy was developed via a breadth first iterative approach with new commands progressively added. An n-tier architecture ensured separation of concern between various layers of the architecture but much of the program’s logic remained in the Command classes. This design architecture ensured minimal changes to the codebase when new commands were added. Often, new commands or feature addition required changes to only a single data class and addition of a new independent command class. 

### Overall Architecture
EZ Manager consists of 4 main layers:  
* Ui: Handles the output of the app 
* Logic: Command parser and executor 
* Model: Data classes 
* Storage: Handles the saving and loading of data to the hard disk 

The Ui and Storage layer contains a single class. The model layer contained a member, a task and a project class and the logic layer contained a single parser class and various command classes. Functionality was exposed directly through these command classes, eliminating the need for redundant classes with few methods. In a small app like EZ Manager, this enhanced code maintainability and readability. 
 
Now, we will delve into more detail about each component. 

### UI Component
API: Ui.java 
Introduction: 
The Ui.java is a class made up of various acknowledgement messages to be displayed after the user inputs a command. 
Abstraction: 
Every message in the class is stored as a String and it is abstracted to a method. This method is called after the execution of a command.  
Access: 
Every method in the Ui class is a static method. Hence, every command class calls the appropriate static methods directly from the Ui class. 

### Logic Component
As user commands follow a fixed format, a generic parser can extract command types and parameter for all commands. This is handled by the parser class. The parser then passes the extracted values to specific command classes. Below are the workings of the Parser and Commands. 
 
**Parser**

User inputs are passed to the static parse method of the parser class. The parser then calls instances of command classes for command execution. The following are handled by the parser. 
* Command type is extracted and used to determine which command class is called for command execution.  
* Command parameters are extracted using a regex and stored in a hashmap. This hashmap is passed to the command class.  
    * Extracting parameters using a regex allows for parameters to be specified in any sequence.
    * The regex splits the parameters into groups of parameter TYPE/VALUE.
    * To recognise the boundaries of each group, and to prevent capturing of the next group, it includes a positive look-ahead of the next group.
* A projectIndex pointer keeps track of the view the user is currently in.  
    * If the user is in a project view, this allows the parser to know which project the task to be manipulated is in.  
    * If the user is in the home view, this allows the parser to know that projects are to be manipulated instead. 
    * This pointer is passed to the command class. 
 
**Commands** 

Each command class represents a specific user command. The bulk of the program’s logic resides here. It manipulates data objects (model layer) and tasks the Ui to display output. The following is a more specific description of command classes. 
* The constructor extracts individual command parameters from the HashMap given to it from the parser. 
* From main(), executeCommand method is called which passes these parameters to methods in the model layer, which manipulates data objects. 
* ExecuteCommand also calls methods in the Ui to display output messages to the user. 

### Model Component

The model component is to provide you with a conceptual understanding of how the data is stored in EZ Manager. EZ Manager has three classes which store data, the Project class, the Task class and the Team Member class. This section will explain how each of these classes interact with one another. The diagram below shows the attributes associated with each of the objects. 

Each project can contain many tasks and have multiple team members assigned to the project. To facilitate this, the Project class contains an ArrayList of Task and an ArrayList of TeamMembers. Other attributes of the Project include its name, description, deadline and its status. All these fields are represented in the Home View of EZ Manager. 
 
Furthermore, for each task that you create, you can add a priority (to allow for sorting in later versions of EZ Manager), status, deadline, assign a member to work on the task and even include the estimates and actual time that a task takes to complete. 

### Storage Component

This is section will explain how EZ Manager ensures that the data in the application persists after each session has been terminated (with the bye command). Figure 3 outlines the responsibility of the Storage component for loading and storing the data during the lifecycle of the application. 

More specifically, Figure 4 shows us how the text file would look like when it is populated. In the load method of Storage that is called at the beginning of each application, the first thing that is recalled are the team members that are part of the overall organization that is being managed by EZ Manager.  

Once the team members are in, the load method registers the projects. Each project is stored in a block that starts with “Project ProjectNameHere” so in Figure 4, the project is project “how are you”. Data pertaining to the project, which includes, the project’s status (whether it is done or not), the project description all the way to the tasks and members associated with the project can be extracted from here and loaded into the current instance of the application. That completes the loading process. 
 
Once the loading process is over, the application proceeds to its normal operation where it receives input from you and responds accordingly. The next important part is when you input the exit command “bye” once this is triggered, before the application terminates, we call the save method. 
 
The save method from the Storage component clears the ezmanager.txt file and then populates it with the current data using the saveFormat function (available in the Project, Task and TeamMember) to ensure that the formatting is consistent with EZ Manager’s saving convention. Once this step is done, you can be assured that your data has been saved.  

## Implementation

### Adding a new project
This section will explain the creation of new projects and how the objects interact with each other. 
The user can create new projects to be added to the list of projects with the project command. 
This command is facilitated with the help of the ProjectCommand class. An instance of the ProjectCommand class will have the following properties: 
* tasks: An array list of tasks 
* members: An array list of members 
* projectName: The name of the project as a String object 
*projectDescription: The description of the project as a String object 
projectDeadline: The deadline of the project as a Local Date object 
Step 1: The user types the project command followed by the name of the project e.g. project n/Project One.  
The main Duke class will call the Parser class. 
The Parser class will check which state the app is in and will then call the appropriate class constructor. In this case, the Parser will call the ProjectCommand constructor. The ProjectCommand constructor will also check for the validity of the user’s input. 
The Parser class will then initialize a new instance of the ProjectCommand constructor with the project name “Project One” and return it back to the main Duke class. 
The Duke class will call the executeCommand function from the returned instance which will execute the command. 
The executeCommand function will create a new Project instance 
It will then add that instance to the static projects list.  
Lastly, it will call the printProjectCreated method from the Ui class and return it to the main Duke class. 
The Duke class will then receive the acknowledgement message and display it to the user in the terminal. 
The above is illustrated below in a sequence diagram. The sequence diagram will only encompass the sequence in the executeCommand function. 

### Deleting Tasks
This command allows project managers to delete tasks from projects. 
The logic for this command is primarily written in TaskDeleteCommand class. It extends from the abstract Command class. 
The steps below show how such a class is initialized and used to execute the command. 

**User enters Command**

User enters command delete t/3 
 
**Implementation**
1. Parser initializes TaskDeleteCommand by passing a hashmap of input parameters together with projectIndex into its constructor. 
2. Parse() method of TaskDeleteCommand extracts the task index from the hashmap. 
3. ExecuteCommand() method of TaskDeleteCommand is called by Duke main class, which passes it the program’s arraylist of projects. 
    
    3.1 Existing project is retrieved from the arraylist of projects using projectIndex. 
    
    3.2 The method deleteTask of the project is called with taskIndex. 
    
    3.3 This simply removes the task from the arraylist of tasks the project contains. 
    
    3.4 The Ui class prints an acknowledgement that the task has been deleted. 
    
### Adding Deadline to Tasks

This command allows project managers to add deadline to tasks. 
The logic for this command is primarily written in DeadlineCommand class. It extends from the abstract Command class. 
The steps below show how such a class is initialized and used to execute the command. 

**User enters Command**

User enters command deadline t/3 h/2 m/32 

**Implementation**

1. Parser initializes DeadlineCommand by passing a hashmap of input parameters together with projectIndex into its constructor. 
2. Parse() method of DeadlineCommand extracts the task index and deadline date from the hashmap. 
3. ExecuteCommand() method of DeadlineCommand is called by Duke main class, which passes it the program’s arraylist of projects. 
   
    3.1 Existing task is retrieved with taskIndex after retrieving the project it belongs to from the arraylist of project. 
    
    3.2 The method addDeadline of the task is called that sets its date property. 
    
    3.3 The Ui class then prints the deadline and the task description. 
    
### Assign Actual Duration to Tasks    
This command allows project managers to record the actual duration that completed tasks take. 
The logic for this command is primarily written in ActualTimeCommand class. It extends from the abstract Command class. 
The steps below show how such a class is initialized and used to execute the command. 

**User enters Command**

User enters command actual t/3 h/2 m/32 

**Implementation**
1. Parser initializes ActualTimeCommand by passing a hashmap of input parameters together with projectIndex into its constructor. 
2. Parse() method of ActualTimeCommand extracts the task index, hours and minutes from the hashmap. 
3. ExecuteCommand() method of ActualTimeCommand is run. 
  
    3.1 Existing task is retrieved using projectIndex and taskIndex. 

    3.2 The task is checked to determine if it is completed. 

    3.3 If the task is completed, the task instance will have its actualInMinutes property set based on the hours and minutes retrieved. 

    3.4 Otherwise, an exception is thrown. 
  
    3.5 The Ui class then prints the task description and the duration the task took. 
    
### Assign Estimated Duration to Tasks    
This command allows project managers to add an estimate for the duration tasks will take. 
The logic for this command is primarily written in EstimatedTimeCommand class. It extends from the abstract Command class. 
The steps below show how such a class is initialized and used to execute the command. 

**User enters Command**

User enters command estimate t/3 h/2 m/32 

**Implementation**
1. Parser initializes EstimatedTimeCommand by passing a hashmap of input parameters together with projectIndex into its constructor. 
2. Parse() method of EstimatedTimeCommand extracts the task index, hours and minutes from the hashmap. 
3. ExecuteCommand() method of EstimateTimeCommand is run. 
    
    3.1 Existing task is retrieved using projectIndex and taskIndex. 
    
    3.2 addEstimate() method of task is called, and the task will have its estimateInMinutes property set based on the hours and minutes retrieved. 

    3.3 The Ui class then prints the task description and the estimated duration added to the task. 
 
### Assign priority to task 
This section will explain the assigning of priorities to tasks and how the objects interact with each other. 

The user can assign a priority to any existing task with the `priority` command. 

This command is facilitated with the help of the TaskAssignPriorityCommand class. An instance of the TaskAssignPriorityCommand class has the following properties. 
- projectIndex: The index of the project as an Integer 
- taskIndex: The index of the task as an Integer 
- priority: The priority to be assigned as a String 

Step 1: The user types the priority command e.g. `priority t/1 p/1`
1. The main Duke class will call the Parser class. 
2. The Parser class will check which state the app is in and will then call the appropriate class constructor. In this case, the Parser will call the ProjectListCommand constructor. The ProjectListCommand constructor will also check for the validity of the user’s input. The constraints of the input are as follows:
  - Not a number for either task index or priority 
  - Not a positive number for either task index or priority
  - An index of a task that does not exist 
3. The Parser class will then initialize a new instance of the TaskAssignPriorityCommand constructor and return it back to the main Duke class. 
4. The Duke class will call the executeCommand function from the returned instance which will execute the command. 
  - The executeCommand will get the specified task using the taskIndex. 
  - It will then set the priority property of the task as the specified priority. 
  - Lastly, it will call the printPriorityAssignedToTaskMessage method from the Ui class and send the acknowledgement message to the main Duke class. 
5. The Duke class will then display the acknowledgement message to the user in the terminal 
The above is illustrated below in a sequence diagram. The sequence diagram will only encompass the sequence in the executeCommand function. 

### Marking a task as done 
This command allows you to mark a task in a selected project. 

The logic for this command is written in the TaskDoneCommand class which inherits its general properties from the abstract Command class. 

The following states how the functionality is used in the application and how it is implemented: 

User enters Command
User enters command `done t/1`

Implementation
1. The parser class uses the `TaskDoneCommand` constructor to initialize a new instance of that class type by passing a hash map which consists of the parameters of that command along with the respective project index of the project in which the task is present in. 
2. The `parse()` method in the `TaskDoneCommand` class extracts the task index of the task that is to be marked done. If the task index is not present in the task list of that project, an exception is thrown. 
3. The `executeCommand()` of the `TaskDoneCommand` class is called by the `main()` method of the `Duke` class and which passes the project and team members array list to the respective method.
  - The current project is obtained using the project array list and the project index that was passed during the instantiation of the `TaskDoneCommand` object.
  - Now, the method fetches the required task by using task index extracted from the  `parse()`.
  - The task object obtained is used to call the member function `markAsDone()` which sets the Boolean field in a task from false to true which the indicates that the task is completed. 
  - The `Ui` class then prints an acknowledgement message to let the user know that a task has been marked as done. 
  
### Sorting Tasks in the TaskList
This command allows you to sort the tasks in a task list in a selected project. 

The logic for this command is written in the `TaskSortCommand` class which inherits its general properties from the abstract Command class. 

The following states how the functionality is used in the application and how it is implemented: 

User enters command: `sort p/`, `sort t/` or `sort d/`
1. The parser class uses the `TaskSortCommand` constructor to initialize a new instance of that class type by passing the input which consists of the parameter of that command. 
2. The `parse()` method in the `TaskSortCommand` class extracts the sorting type (deadline, priority, actual time). 
3. The `executeCommand()` of the `TaskDoneCommand` class is called by the `main()` method of the `Duke` class and which passes the project and team members array list to the respective method. 
  - The current project is obtained using the project array list and the project index that was passed during the instantiation of the TaskSortCommand object. 
  - Now, based on the sorting type the method will choose a case statement in a switch-case that reflects the type of sorting.
  - The `Ui` class then prints an acknowledgement message to let the user know that the tasks have been sorted according to the respective sorting type. 


## Running Tests 
There are two ways to run tests for EZ manager. 
> To check for test coverage, please ensure that you `Run with coverage` when right clicking on the tests to run. 

**Method 1: Using IntelliJ JUnit test runner**
- To run all tests available, right-click on the `src/test/java` folder and choose `Run  All Tests`
- To run a some of the tests, you can right-click on a test package, test class, or a test and choose `Run Particular Test Name Here` 

**Method 2: Using Gradle**
- On Windows, run the command `gradlew clean allTests` in a terminal 
- On Mac or Linux, run the command `./gradlew clean allTests` in a terminal 

## DevOps — Making a Release 
Here are the steps to create a new release. 
1. Update the version number in Duke.java 
2. Generate a JAR file using Gradle
3. Tag the repo with the version number. e.g. v0.1 
4. Create a new release using GitHub and upload the JAR file you created. 

## Appendix A: Product Scope 
Target user profile: 
- Project Manager of Software Engineering projects 
- Needs to manage teams for different projects 

Value proposition:
Manage projects in a smooth and seamless way to allow the team to get more done 

**User Stories**

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

Priority | As a ... | I want to ... | So that I can ...
---------- | -------------------- | ------------------------- | -------------------------
`* * *` | new user | see usage instructions | refer to the commands when I forget how to use the App
`* * *` | project manager | add a new project | track the progress of my new project 
`* * *` | project manager | add tasks under a project | track the project tasks needed to finish the project
`* * *` | project manager | add a new member | manage members in my team 
`* * *` | project manager | select a project | go into a particular project to make changes such as adding tasks and deadline specific to the project
`* * *` | project manager | navigate between home view and project view | switch from one project to the other project
`* * *` | project manager | delete an existing project | remove projects that are not required anymore
`* * *` | project manager | delete an existing task | remove tasks that are not required anymore
`* * *` | project manager | remove an existing member | remove members that have left the team
`* * *` | project manager | add a deadline to an existing project | keep the project on track and deliver the product on time
`* * *` | project manager | add a deadline to an existing task | keep the task on track and finish it on time
`* * *` | project manager | mark completed projects as done | see which projects are done and which still needs to be done
`* * *` | project manager | mark completed tasks as done | see which tasks are done and which still needs to be done
`* * *` | project manager | add a project description | have a better understanding of the concept and context of the project
`* * *` | project manager | add a task description | have a better understand of the task and know what needs to be done
`* * *` | project manager | assign a member to a project | allocate projects to team members 
`* * *` | project manager | assign a member to a task | allocate equal workload to every team member
`* * *` | project manager | assign priority to a task | organise the tasks in order of priority and focus on those that are more urgent
`* *` | project manager | assign estimated time needed to complete a task | give my team a rough estimate of how long is expected for them to finish the task
`* *` | project manager | assign actual time used to complete a task | find out the amount of time spent and understand which task is taking more time than expected
`* *` | project manager | display all the projects and members all in one view | have an overview of all the projects and members
`* *` | project manager | display all the tasks and members allocated to the project all in one view | have an overview of the unfinished tasks and members assigned to those tasks
`* *` | project manager | sort my list of projects in terms of deadline | prioritise projects that are urgent and focus on completing the project before the deadline
`* *` | project manager | sort my list of tasks in terms of deadline | focus on the tasks that have a closer deadline
`* *` | project manager | sort my list of tasks in terms of priority | focus on the tasks that are most important as some are base level tasks which are required for the project to be up and running
`* *` | project manager | sort my list of tasks in terms of actual time spent | have an overview of which tasks are taking up more time and required more manpower in the future
`*` | project manager | add the roles of my team members | allocate appropriate tasks to appropriate members
`*` | project manager | send out reminders to my team members | have them shift gears or change something in real time  

## Appendix C: Instructions for Manual Testing (Shreyas)

### <ins>Project-Specific Tests</ins>

#### C.1 Creating a Project
1. Creating a Project when you are in the Home-View
    * Prerequisites: Only Required to be in the Home-View 
    * Test case: `project n/p1`: A new project named as p1 will be created and added to the project list. A message will be displayed on the screen to ensure the user that the project has been created.
    * Test case: `project p1`: Since the n/ parameter has not been provided, it is considered as an incorrect command in the application and hence the program throws an exception.
    
2. Creating a Project when you are in the Project-View
    * Prerequisites: Required to be in Project-View
    * Test case: `project n/p1`: Since the state of the program is in project view, the user will not be allowed to create a project and hence the program throws an exception.
    
#### C.2 Deleting a Project
1. Deleting a Project when you are in the Home-View
    * Prerequisites: Only Required to be in the Home-View
    * Test case: `delete p/1`: The project named as p1 will be deleted and from the project list. A message will be displayed on the screen to ensure the user that the project has been deleted.
    * Test case: `delete p1`: Since the p/ parameter has not been provided, it is considered as an incorrect command in the application and hence the program throws an exception.

2. Deleting a Project whose project-id is greater that the total number of projects
    * Prerequisites: Required to be in the Home-View and have three projects created.
    * Test case: `delete p/4`: Since there are only three projects in the project list, the project-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid project-id.

3. Creating a Project when you are in the Project-View
    * Prerequisites: Required to be in Project-View.
    * Test case: `delete p/1`: Since the state of the program is in project view, the user will not be allowed to delete a project and hence the program will not be able to recognize the p/ parameter and will hence throw an exception.

#### C.3 Selecting a Project
1. Selecting a Project when you are in the Home-View
    * Prerequisites: Only Required to be in the Home View (Initial state of the application) and, the project p1 has already been created.
    * Test case: `select p/1`: The project with the index of 1 will be will selected from the
      project list and, you will enter project view of that respective project.
    * Test case: `select p1`: Since the p/ parameter has not been provided, it is considered as an incorrect command in the application and hence the program throws an exception.

2. Selecting a Project whose project-id is greater that the total number of projects
    * Prerequisites: Required to be in the Home View and have three project created.
    * Test case: `select p/4`: Since there are only three projects in the project list, the project-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid project-id.

3. Selecting a Project when you are in the Project-View
    * Prerequisites: Required to be in Project-View
    * Test case: `select p/1`: Since the state of the program is in project view, the user will not be allowed to delete a project and hence the program will not be able to recognize the p/ parameter and will hence throw an exception.
      
#### C.4 Providing a Description for a Project (need to update this)
1. Providing a description for the Project when you are in the Project-View
    * Prerequisites: Required to be in the Project-View.
    * Test case: `description p/1 d/This is a description`: Since we are in Project-View, we would not be able to add a description to any of them and hence the program will throw an exception.
   
2. Providing a description for the Project when you are in the Home-View 
    * Prerequisites: Required to be in Home-View.
    * Test case: `description p/1 d/This is a description`: Since the state of the program is in Home-View, the description 'This is a description' will be added to the project having an index of 1. An acknowledgement message is printed on the screen to ensure the user that the project has been provided with a description.
    
### <ins>Task-Specific Tests</ins>

#### C.5 Creating a Task
1. Creating a Task when you are in the Project-View
    * Prerequisites: Only Required to be in Project-View.
    * Test case: `task n/t1`: A new task named as t1 should be created and added to the task list of that project. A acknowledgement message will be displayed on the screen to ensure the user that the task has been created.

2. Creating a Task when you are in the Home-View
    * Prerequisites: Required to be in Home-View.
    * Test case: `task n/1`: Since the state of the program is in Home-View, the user will not be allowed to create a task and hence the program throws an exception.
    
#### C.6 Deleting a Task
1. Deleting a Task when you are in the Project-View
    * Prerequisites: Required to be in Project-View. 
    * Test case: `delete t/1`: The first task in the task list of the project will be deleted and, an acknowledgement message will be displayed on the screen to ensure the user that the required task has been deleted.

2. Deleting a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `select t/7`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.    

3. Deleting a Task when you are in the Home-View
    * Prerequisites: Required to be in Home-View.
    * Test case: `delete t/1`: Since the state of the program is in Home view, the user will not be allowed to delete a task and hence the program throws an exception.
    
#### C.7 Marking a Task as Completed
1. Marking a Task as done in Project-View
    * Prerequisites: Required to be in Project-View of a created project and have tasks created in that respective project.
    * Test case: `done t/1`: The first task in the task list of that project will be marked as completed and an acknoweldegement message will be displayed on the screen to ensure the user that the task has been marked as completed.

2. Marking a Task as done whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `done t/7`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id. 

3. Marking a Task as done in Home-View 
    * Prerequisites: Required to be in Home-View
    * Test case: `done t/1`: Since the state of the program is in Home view, there will only be projects present so the user will not be able to mark a task as completed and the program throws an exception.

#### C.8 Assigning a Deadline to a Task
1. Assigning a Deadline to a Task in Project-View
    * Prerequisites: Required to be in Project-View of a created project and have tasks created in that respective project.
    * Test case: `deadline t/1 d/2020-11-09`: Since the state of the program is in Project-View and the deadline mentioned is in the format YYYY-MM-DD the program assigns the date 2020-11-09 as the deadline to task 1. An acknoweldegment message is also displayed to ensure the user that the required task has been assigned to the respective deadline. 
    * Test case: `deadline t/1 d/09-10-2020`: Eventhough the state of the program is in Project-View the deadline is of the format DD-MM-YYYY which is the incorrect format while inputting the date. An exception mesaage is also thrown by the program to tell the user to enter the date in the YYYY-MM-DD format.
    * Test case: `deadline t/1 d/11-25-2020`: Eventhough the state of the program is in Project-View the deadline is of the format MM-DD-YYYY which is the incorrect format while inputting the date. An exception mesaage is also thrown by the program to tell the user to enter the date in the YYYY-MM-DD format.

2. Assigning a Deadline to a Task in Home-View
    * Prerequisites: Required to be in Home-View.
    * Test case: `deadline t/1 d/2020-11-09`: Since the state of the program is in Home-View, there will only be projects present, so the user will not be able to mark a task as completed and the program throws an exception.

3. Assigning a Deadline to a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `deadline t/7 d/2020-12-22`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.

#### C.9 Assigning a Priority to a Task
1. Assigning a Priority to a Task in Project-View. 
    * Prerequisites: Required to be in Project-View of a created project and have tasks created in that respective project.
    * Test case: `priority t/1 p/1`: Since the state of the program is in Project-View, the priority 1 will be assigned to task 1 and an acknoweldegment message is also displayed on the screen to ensure the user that the priority has been assigned.

2. Assigning a Priority to a Task in Home-View
    * Prerequisites: Required to be in Home-View.
    * Test case: `priority t/1 p/1`: Since the state of the program is in Home-View, there will only be projects present, so the user will not be able to assign a prirority to a task and the program throws an exception.

3. Assigning a Priority to a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `priority t/7 p/3`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.

#### C.10 Assigning Estimated Completion Time to Task
1. Assigning an Estimated completion time to a Task in Project-View
    * Prerequisites: Required to be in Project-View of a created project and have tasks created in that respective project.
    * Test case: `estimate t/1 h/3 m/10`:  Since the state of the program is in Project-View an estimated completion time of 1 hour and 10 minutes will be assigned to task 1 and an acknoweldegment message is also displayed on the screen to ensure the user that the estimated completion time has been assigned.

2. Assigning an Estimated completion time to a Task in Home-View
    * Prerequisites: Required to be in Home-View
    * Test case: `estimate t/1 h/3 m/10`: Since the state of the program is in Home-View, there will only be projects present, so the user will not be able to assign an estimated completion time to a task and the program throws an exception.

3. Assigning an Estimated completion time to a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `estimate t/7 h/3 m/20`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.

#### C.11 Assigning Actual Completion Time to Task
1. Assigning an Actual completion time to a completed Task in Project-View
    * Prerequisites: Required to be in Project-View of a created project and have atleast one completed task in that respective project.
    * Test case: `actual t/1 h/3 m/10`:  Since the state of the program is in Project-View and the task in marked as completed, an actual completion time of 1 hour and 10 mimnutes will be assigned to task 1 and an acknoweldegment message is also displayed on the screen to ensure the user that the actual completion time has been assigned.

2. Assigning an Actual completion time to a incompleted Task in Project-View
    * Prerequisites: Required to be in Project-View of a created project and have tasks created in that respective project.
    * Test case: `actual t/1 h/3 m/10`:  Since the state of the program is in Project-View and task 1 has not been completed an actual completion time cannot be assigned to the task and the program will display an exception message that informs the user that the task should be marked as completed.

3. Assigning an Actual completion time to a Task in Home-View
    * Prerequisites: Required to be in Home-View.
    * Test case: `actual t/1 h/3 m/10`: Since the state of the program is in Home-View, there will only be projects present, so the user will not be able to assign an actual completion time to a task and the program throws an exception.

4. Assigning an Actual completion time to a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `actual t/7 h/3 m/25`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.
#### C.12 Sorting Tasks in TaskList

1. Sorting Tasks by deadline in Project-View
    *Prerequisites: Required to be in Project-View of a created project and have tasks in that respective project.
    *Test case: `sort s/d`: Since the state of the program is in project-view, all the tasks in the list that have a deadline will be sorted in ascending order and the tasks that do not have a deadline are placed towards the end.

2. Sorting Tasks by completion time in Project-View
    *Prerequisites:  Required to be in Project-View of a created project and have tasks in that respective project.
    *Test case: `sort s/t`: Since the state of the program is in Project-View, all the tasks in the list that have an actual time will be sorted in ascending order and the tasks that do not have an actual time are placed towards the end of the list.

3. Sorting Tasks by priority in Project-View
    *Prerequisites:  Required to be in Project-View of a created project and have tasks in that respective project.
    *Test case: `sort s/p`: Since the state of the program is in Project-View, all the tasks in the list that have a priority will be sorted in ascending order of priority and the tasks that do not have a priority are placed towards the end of the list.

4. Sorting Tasks in Home-View.
    * Prerequisites: Required to be in Home-View.
    * Test case: `sort s/t`: Since the state of the program is in Home-View, there will only be projects present, so the user will not be able to sort any sets of tasks and the program throws an exception.

### <ins>Member-Specific Tests</ins>

#### C.13 Adding a Member

1. Adding a member in Home-View 
    * Prerequisites: Required to be in Home-View.
    * Test case: `member n/John Doe`: Since the state of the program is in home view, the member will be created and added to the member arraylist. The program also displays an acknoweldegment message to ensure the user that a new member has been added.

2. Adding a member in Project-View 
    * Prerequisites: Required to be in Project-View.
    * Test case: `member n/John Doe`: Since the state of the program is in Project-View, the program will throw an exception message to the user because a member can only be added in the Home-View.

#### C.14 Removing a Member

1. Removing a member in Home-View 
    * Prerequisites: Required to be in Home-View.
    * Test case: `remove m/1`: Since the state of the program is in Home-View, the member will be removed from the member arraylist. The program also displays an acknoweldegment message to ensure the user that the member has has been removed.

2. Removing a member in Project-View 
    * Prerequisites: Required to be in Project-View
    * Test case: `remove m/2`: Since the state of the program is in Project-View, the program will throw an exception message to the user because a member can only be removed in the Home-View.

3. Removing a member from a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in Home-View with five members added to the members list.
    * Test case: `remove m/6`: Since there are only five members in the members list, the member-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid member-id.

#### C.15 Assigning a Member to a Project

1. Assigning a member to a project in Home-View 
    * Prerequisites: Required to be in Home-View.
    * Test case: `assign m/2 p/1`: Since the state of the program is in Home-View, the member will be assigned to the respective project. The program also displays an acknoweldegment message to ensure the user that a new member has been added.

2. Assigning a member to a project in Project-View 
    * Prerequisites: Required to be in Project-View.
    * Test case: `assign m/1 p/1`: Since the state of the program is in Project-View, the program will throw an exception message to the user because a members can only be assigned to projects in the Home-View.

#### C.16 Assigning a Member to a Task

1. Assigning a member to a project in Home-View 
    * Prerequisites: Required to be in Home-View.
    * Test case: `assign t/1 m/2`: Since the state of the program is in Project-View, the program will throw an exception message to the user because a member can only be assigned to tasks in the Project-View.

2. Assigning a member to a project in Project-View 
    * Prerequisites: Required to be in Project-View.
    * Test case: `assign t/2 m/1`: Since the state of the program is in  Project-View, the member will be assigned to the respective project. The program also displays an acknoweldegment message to ensure the user that the new member has been assigned to the respective task.

4. Assigning a member to a Task whose task-id is greater than the total number of tasks
    * Prerequisites: Required to be in the Project-View and have five tasks created.
    * Test case: `assign m/1 t/8`: Since there are only five tasks in the task list, the task-id provided to the program is invalid and the program will throw an exception to tell the user to enter a valid task-id.









