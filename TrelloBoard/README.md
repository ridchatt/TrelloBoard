# Trello Board CRUD Operations Testing

This project aims to test the CRUD (Create, Read, Update, Delete) operations on Trello boards. It uses Maven for project management, Cucumber for behavior-driven development (BDD), and JUnit for running tests.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Test Cases](#test-cases)
- [Project Structure](#project-structure)

## Prerequisites
- Java Development Kit (JDK) 21
- Maven
- Internet connection for downloading dependencies

## Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/trello-board-crud.git
cd trello-board-crud
```

2. Install dependencies:

```bash
mvn clean install
 ```

## Running Tests

### Running All Tests

To run all tests, use the following command:

```bash
mvn test
````

### To run specific test scenarios, configure your Cucumber options or use tags:

```bash
mvn test -Dcucumber.options="--tags @tagname"
````

##Test Cases

### Overview

This document outlines the test cases for CRUD (Create, Read, Update, Delete) operations on a Trello board. The test cases cover both positive and negative scenarios for the Trello user interface (UI) and API.

## 1. Create Operations

### Positive Test Cases

#### A) Create a New Board

**Description:** Verify that a new board can be successfully created.  
**Steps:**
1. Login to Trello.
2. Click on the "Create New Board" button.
3. Enter a valid board name and select a background color.
4. Click "Create Board".
**Expected Result:** The new board should appear on the dashboard with the specified name and background color.

### Negative Test Cases

#### B) Create a Board with Empty Name

**Description:** Verify that the user cannot create a board with an empty name.  
**Steps:**
1. Login to Trello.
2. Click on the "Create New Board" button.
3. Leave the board name field empty.
4. Click "Create Board".
**Expected Result:** Board should not be created with an empty name. A message should be displayed indicating that the board name cannot be empty.

---

## 2. Read Operations

### Positive Test Cases

#### A) View Board Details

**Description:** Verify that board details (e.g., name, lists, cards) are correctly displayed.  
**Steps:**
1. Login to Trello.
2. Open an existing board.
3. Verify the board's name, background color, lists, and cards.
**Expected Result:** The board details should match the saved configuration.

### Negative Test Cases

#### B) Try to View a Non-Existent Board

**Description:** Verify that the user cannot view a non-existent board.  
**Steps:**
1. Login to Trello.
2. Attempt to open a board with an invalid or deleted ID.
**Expected Result:** An error message should be displayed, indicating that the board does not exist.

---

## 3. Update Operations

### Positive Test Cases

#### A) Update Board Name

**Description:** Verify that the board name can be updated successfully.  
**Steps:**
1. Login to Trello.
2. Open an existing board.
3. Click on the board name and edit it.
4. Save the changes.
**Expected Result:** The board name should be updated and displayed correctly.

### Negative Test Cases

#### B) Update Board Name to Empty String

**Description:** Verify that the user cannot update the board name to an empty string.  
**Steps:**
1. Login to Trello.
2. Open an existing board.
3. Attempt to change the board name to an empty string.
4. Save the changes.
**Expected Result:** The board cannot be saved with an empty name.

---

## 4. Delete Operations

### Positive Test Cases

#### A) Delete a Board

**Description:** Verify that a board can be successfully deleted.  
**Steps:**
1. Login to Trello.
2. Open an existing board.
3. Click on "Show Menu" and select "More" > "Close Board".
4. Confirm the deletion.
**Expected Result:** The board should be removed from the dashboard.

---

## API Test Cases

### Positive Test Cases

#### 1. Create a Board

**Description:** Create a board with a valid name and optional description.  
**Steps:**
1. Send a POST request to the Trello API endpoint to create a board.
2. Include a valid name in the request payload.
**Expected Result:** The board is created successfully, and a valid response containing the board's details is returned.

#### 2. Retrieve a Board

**Description:** Retrieve a board using a valid board ID.  
**Steps:**
1. Send a GET request to the Trello API endpoint with a valid board ID.
**Expected Result:** The board details are returned successfully.

#### 3. Update a Board

**Description:** Update the name of an existing board.  
**Steps:**
1. Send a PUT request to the Trello API endpoint with the board ID and new name.
**Expected Result:** The board's name is updated successfully, and the updated board details are returned.

#### 4. Delete a Board

**Description:** Delete a board using a valid board ID.  
**Steps:**
1. Send a DELETE request to the Trello API endpoint with the board ID.
**Expected Result:** The board is deleted successfully, and a confirmation response is returned.

### Negative Test Cases

#### 1. Create Board with Empty Name

**Description:** Attempt to create a board without providing a name.  
**Steps:**
1. Send a POST request without including a name.
**Expected Result:** The request fails, and an error message is returned indicating that the name is required.

#### 2. Retrieve Board with Invalid ID

**Description:** Attempt to retrieve a board using an invalid board ID.  
**Steps:**
1. Send a GET request with an invalid board ID.
**Expected Result:** The request fails, and an error message is returned indicating that the board was not found.

#### 3. Retrieve Board without Authentication

**Description:** Attempt to retrieve a board without providing authentication credentials.  
**Steps:**
1. Send a GET request without authentication tokens.
**Expected Result:** The request fails, and an error message is returned indicating that authentication is required.

#### 4. Update Board with Invalid ID

**Description:** Attempt to update a board using an invalid board ID.  
**Steps:**
1. Send a PUT request with an invalid board ID.
**Expected Result:** The request fails, and an error message is returned indicating that the board was not found.

#### 5. Delete Board with Invalid ID

**Description:** Attempt to delete a board using an invalid board ID.  
**Steps:**
1. Send a DELETE request with an invalid board ID.
**Expected Result:** The request fails, and an error message is returned indicating that the board was not found.

#### 6. Delete Board without Authentication

**Description:** Attempt to delete a board without providing authentication credentials.  
**Steps:**
1. Send a DELETE request without authentication tokens.
**Expected Result:** The request fails, and an error message is returned indicating that authentication is required.

---

## Project Structure

```markdown

TrelloBoard [TrelloBoard master]
├── JRE System Library [JavaSE-1.8]
├── Maven Dependencies
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── api
│   │   │   │   └── TrelloApiClient.java
│   │   │   ├── pages
│   │   │   │   ├── BoardPage.java
│   │   │   │   ├── DashboardPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   └── LoginPage.java
│   │   │   ├── resources
│   │   │   │   └── config.properties
│   │   │   └── utilities
│   │   │       ├── ConfigReader.java
│   │   │       └── WaitHelper.java
│   ├── test
│   │   ├── java
│   │   │   ├── features
│   │   │   │   ├── TrelloCRUDAPI.feature
│   │   │   │   └── TrelloCRUDUI.feature
│   │   │   ├── runners
│   │   │   │   ├── TestRunner.java
│   │   │   │   ├── TestRunnerAPI.java
│   │   │   │   └── TestRunnerUI.java
│   │   │   └── stepDefinitions
│   │   │       ├── TrelloAPISteps.java
│   │   │       └── TrelloUISteps.java
├── JUnit 4
├── Drivers
│   └── chromedriver.exe
├── src
├── target
├── pom.xml
└── README.md





