# Welcome to M.O.M Automation!

- **Git Clone URL** : https://github.com/Fire00/NoBroker-automation-Framework.git
- **Maintained / Developed By** : [Siddhartha Pandey](pandeysiddhartha007@gmail.com)
- **Contact** :[Siddhartha Pandey](pandeysiddhartha007@gmail.com)
------

# Contents

- [Introduction](#introduction)
- [Folder Structure](#folder-structure)
- [Environment Setup](#environment-setup)
- [Developer Attention](#developer-attention)
- [Pre Execution](#pre-execution)
- [Execution](#execution)
- [Post Execution](#post-execution)

------

## Introduction

This is a hybrid automation framework designed with below technical stack.

### Technical Stack :

- Java Language (Programming Language)
- [Selenium Webdriver](https://selenium.dev) (Utility to communicate to Web browsers)
- [BDD Cucumber](https://cucumber.io) (Utility to develop Test Steps through Behavioural Driven)
- [Maven](https://maven.apache.org)(To Manage dependencies and perfrom build & execution)
- [TestNG](https://testng.org) (Unit Testing framework)

### Features :

- Easy Setup & Execution
- Dynamic Reporting Structure
- Easily Scalable & Maintenance
- Depends on functionality & dependency
------

## Folder Structure

```
NoBroker-automation-Framework
    |-src
       |-main
           |-java
              |-BaseTestSession()
              |-pageObjects()
              |-reporter ()
              |-specs ()
              |-stepDef ()
              |-stepInit ()
           |-resources
              |-configInit ()
       |test
           |-features ()
           |-java ()
       |-target()
       |-pom.xml
       |-README.md
```              

> Note : In Above, anything without extension is either a package or directory. Files are specified with it's extension.

------

## Environment Setup

### Softwares & Accesses

##### For Execution Only

##### Softwares :

1. Apache Maven (Preferably 3.6.0 and above) - Mandatory
2. Git for Windows - Optional (if user wants to update project regularly)
3. Chrome Browser & Chrome Driver (Equivalent Versions) - Mandatory
4. Java JDK


##### For Execution & Development

##### Softwares :

1. Apache Maven (Preferably 3.6.0 and above) - Mandatory
2. Git for Windows - Mandatory (if user wants to update project regularly)
3. Chrome Browser & Chrome Driver (Equivalent Versions) - Mandatory
4. Java IDE (IntelliJ IDEA Community Edition)
5. Java JDK

##### Accesses :

1. Access to Git Repo (for Cloning/updating)

------ 

## Developer Attention

**SCENARIO TAGS**
- If the scenario involve opening UI (Ex: FrontEnd/Webapp Testing). add tag **@UI**
    - Opens UI (Web Browser).
    - Broswer Name define in 
     **config.yml** file
    - url define in 
     **config.yml** file

 

- If the scenario doesn't involve opening UI (Ex: Backend Testing). add tag **@noUI**
    - Doesn't Open UI (Web Browser). Hence no Login to a WebPage nor any validation


------ 
## Execution

### How to Execute, different types

1. As Cucumber Feature/Scenario `Use during debugging/development`
    - Open project in IntelliJ
    - Open the cucumber feature
    - If you need to execute the whole feature. Right-Click and Select Run Feature
    - If you need to execute the Scenario. Right-Click and Select Run Scenario

2. With Maven (Maven -> TestNG -> Cucumber Feature) `Recommended`
       - If Execution with IntelliJ,
        - Open the project in IntelliJ
        - Click on Add Configurations (if not already added)
        - Select Maven, and specify command **`clean verify @TAGEXPRESSION`**
        - Click apply & OK
        - Click on the Run Button


------

## Post Execution

1. In the project root directory **`target`** folder is generated
2. Open **`target->Extent-Reports`** to check the generated reports
------
