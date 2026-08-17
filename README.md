# Task Service

A Java application developed for my **CS 320: Software Test, Automation, and Quality Assurance** course. The project demonstrates object-oriented programming, input validation, service-layer operations, automated unit testing, and code coverage analysis.

## Project Overview

The Task Service manages task records using in-memory data structures. It allows tasks to be created, updated, and deleted while enforcing specific requirements for task IDs, names, and descriptions.

The project does not use a database or user interface. Its main focus is validating software requirements through automated unit testing.

## Features

* Create new tasks
* Store tasks using unique task IDs
* Update task names
* Update task descriptions
* Delete tasks by ID
* Prevent duplicate task IDs
* Validate task information
* Automated unit testing with JUnit 5
* Code coverage reporting with JaCoCo

## Task Requirements

Each task must meet the following requirements:

* Task ID cannot be null
* Task ID cannot exceed 10 characters
* Task IDs must be unique
* Task ID cannot be changed after creation
* Task name cannot be null
* Task name cannot exceed 20 characters
* Task description cannot be null
* Task description cannot exceed 50 characters

## Project Structure

```text
TaskService/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── task/
│   │           ├── Task.java
│   │           └── TaskService.java
│   └── test/
│       └── java/
│           └── task/
│               ├── TaskTest.java
│               └── TaskServiceTest.java
└── .gitignore
```

## Technologies Used

* Java
* JDK 21
* Maven
* JUnit 5
* JaCoCo 0.8.13
* IntelliJ IDEA
* Git
* GitHub

## Testing

JUnit tests are included to verify that the `Task` and `TaskService` classes meet the required specifications.

Tests cover areas such as:

* Valid task creation
* Invalid task IDs
* Invalid task names
* Invalid task descriptions
* Adding tasks
* Preventing duplicate task IDs
* Updating task names
* Updating task descriptions
* Deleting tasks

## Running the Tests

From the project directory, run:

```bash
mvn test
```

This will compile the project, run the JUnit tests, and generate the JaCoCo code coverage report.

## Viewing the JaCoCo Coverage Report

After running the tests, the HTML coverage report can be found at:

```text
target/site/jacoco/index.html
```

On macOS, open it with:

```bash
open target/site/jacoco/index.html
```

The JaCoCo report provides coverage information for classes, methods, branches, and lines of code.

## What I Learned

This project helped me practice writing maintainable Java code, designing unit tests based on software requirements, and using automated code coverage tools. It also reinforced the importance of input validation, test coverage, and verifying that software behaves correctly under both valid and invalid conditions.

## Author

**Ramon Baez**

Computer Science Student
Software Development
