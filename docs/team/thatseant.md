# Sean Tan's Project Portfolio Page

## Project: EZ Manager
EZ Manager is a CLI project management tool for software managers that allows them to manage the projects and members on their teams.

This documents highlights my contributions to EZ Manager.

### Code Contributed 

#### [Sean's RepoSense](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=thatseant)



## Features added

### **Architecture**

**Implementation of App's Parser**

My main enhancement was concentrated around the app’s architecture. I advocated the team move most of the logic to the individual command classes for iterative and independent development. I implemented the app’s parser to support this. In getParams(), a generic regex allows for retrieving any parameters for any command. With the parameters stored in a hashmap, I then sent this hashmap to the command classes in getCommand(). Furthermore, this meant that the user can specify parameters in any order. This made development so much easier for my teammates as they can concentrate on writing the logic of command execution with parsing done.

**Refactoring of App**

I restructured the app to make it more user-friendly. Previously, there were team member list, tasks list and project list. Users were prone to confusion due to multiple lists that showed only limited information. I advocated for the team to implement Home View and Project View and replaced the List Command to display these views. Additionally, I designed mockups for the team so they understood what I meant. With this change, users immediately know which view they are in and which commands they could execute.

**Classes written**

* Parser
* TaskCommand
* ActualTimeCommand
* EstimatedTimeCommand
* TaskAssignDeadlineCommand
* TaskAssignPriorityCommand
* TeamMemberHoursCommand



## **Contributions to User Guide (UG)**

My contributions were the following:

- Restructured UG so commands were grouped by Home View and Project View
- Added expected output to all UG commands.
- Added warnings and tips so users knew what to take note of when using the app.



## **Contributions to Developer Guide (UG)**

My contributions were the following:
- Design section, specifically the introduction, consideration and overall architecture, and logic components. 
- Delete Task
- Assign Deadlines to Task
- Assign actual duration for tasks
- Assign estimated duration for tasks.



## **Contributions to Team-Based Tasks**

* Initiated the team’s practice of creating issues for our user stories by creating tags and opening issues during the first weeks. Advocated for my team to do these for issues they were assigned in the following weeks. 
* Categorise all of the issues from PE Dry-Run so my team has a better understanding of what had to be fixed and we can assign work to each other.
* Increased the number of approvals required for each pull request to 2 which resulted in better code quality and communication between members.

#### Contributions to reviewing/mentoring

Of the 71 closed pull requests as of 7th November, I reviewed 34. In many of these pull requests, I looked through the code line-by-line and noted down issues or areas where the new code did not fit in well with the rest of the codebase.

https://docs.google.com/document/d/1bKq28FjPE9JTeszGBGBwi5R1I_JmIS6Zhv00lq6c6ik/edit
