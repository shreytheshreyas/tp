# Samuel Paul Christopher - Project Portfolio Page

## Project: EzManager
EZ Manager is a simple and efficient project management tool for software project managers. 
EZ Manager is a desktop application with the user interacting with the CLI 
(Command Line Interface) to manage projects, tasks and team members.

### Summary of Contributions
Given below are my contributions to the project.

* **Code contributed**: [RepoSense Link](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=samuelchristopher)

* **Features Added**: 
    * **Project View**: Allows the user to have an overview of all the tasks and members in the project.
    * **Create Member (In home view)**: Allows the user to add a member to program.
    * **Delete Project (In home view)**: Allows the user to remove a specified project from the program. 
    * **Mark Project As Completed**: Allows the user to mark a new project as completed. 
    * **Mark Tasks As Completed**: Allows the user to mark a project as completed.
    * **Storage**: Allows the data on EZ Manager to be persisted.
    
* **Noteworthy Features**: 

1. Added Project View feature.
    * What it does: Allows the user to have an overview of all the tasks and members in the project.
    This includes important information such as:
       - status of the task (is it done or not?)
       - description
       - deadline
       - priority of the task
       - estimated hours to spend on the task
       - actual time spent on the task 
       - members involved with the task
    * Justification: This feature allows our project managers to get a glance of the projects all in one command. 
    Features like this one are essential to allow the project manager to determine of the project is on track.
    
2. Data persistance
* **Enhancement to existing feature**
    * Extracted printing elements to Ui class. (Pull Request #50)
    * Show correct assigned members in each project. (Pull Request #90)
    * List of projects in home view sorted by their deadlines as default view. (Pull Request #76)
    * Assign command does not allow assignment of repeated projects and tasks (Pull Request #179)
    
* **Documentation**:
    * User Guide:
        * Added documentation for the features `remove`, `project`, `description`, `deadline` and `list`.
    * Developer Guide:
        * Design section: Model Component
        * Home view
        * Add deadlines to projects
        * Add description to projects
        * Delete a specified project
        * Mark project as done
        * Remove members
        * Appendix A Product Scope: User Stories
        
* **Contributions to reviewing/mentoring**:
    * Our project had about 70 closed pull requests as of 8/11/2020. I reviewed, commented and approved about 20 of those PRs.
    In those reviews, I provided extensive problem recognitions to those codes that were not suitable and provided explanations
    to my teammates in parts of the codes that they did not understand. 
        
    
