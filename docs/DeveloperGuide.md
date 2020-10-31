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
