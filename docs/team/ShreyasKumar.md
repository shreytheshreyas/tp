# Samuel Leow Wei Han - Project Portfolio Page

## Project: EzManager
EZ Manager is a simple and efficient project management tool for software project managers. 
EZ Manager is a desktop application with the user interacting with the CLI 
(Command Line Interface) to manage projects, tasks and team members.

### Summary of Contributions
Given below are my contributions to the project.

* **Code contributed**: [RepoSense Link](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=shreytheshreyas)

* **Features Added**: 
    * **Remove member (Initial Remove Member Command)**: Allows the user to remove a member from the members Array-list
    * **Assign member to a specific project**: Allows the user to assign a member to a particular project
    * **Sort**: This command allows a user to sort a set of tasks in the Project-View based on a particular feature. 
    
* **Noteworthy Feature**: Sort Tasks in a particular project. (Pull Requests #97 and #175)
    * What it does: This feature allows a specific the user to sor
    * Justification: This feature improves the product significantly because the user do not have to type in multiple commands
    to view a list of projects or a list of members separately. An overview could be seen with one command.
    * Highlights: This feature displays remarks of each project, which shows the user the next task with an upcoming deadline.
    If the deadline is within 5 days from today's date, and the task has not been done, "!!!!!WARNING!!!!!" will be displayed in the remarks to alert
    the user.
    
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
        
    
