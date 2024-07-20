Feature: Trello UI CRUD operations

Background:
		#Given user launches browser
    When user is on login page
    Then user enters "riddhika.chatterjee0005@gmail.com" and "Srikanta2024"
    And clicks on login button
    Then user verifies page title "Boards | Trello"
    Then user is navigated to home page

@ui @positive
  Scenario: Create a new Trello board
    
    When user clicks on create new board button
    And user enters board name "TestBoard"
    And user clicks on create board button
    Then the board "TestBoard" should be created
    When user clicks on logout link
    Then user verifies page title contains "Log out of your Atlassian account" 
    
@ui @positive
  Scenario: Read the Trello board
    
    When user clicks on "TestBoard" board
    Then the board title should be "TestBoard"
    When user clicks on logout link
    Then user verifies page title contains "Log out of your Atlassian account"

@ui @positive
 Scenario: Update the Trello board name
    
    When user clicks on "TestBoard" board
    Then the board title should be "TestBoard"
    When user changes the board name to "UpdatedTestBoard"
    Then the board title should be "UpdatedTestBoard"
    When user clicks on logout link
    Then user verifies page title contains "Log out of your Atlassian account"

@ui @positive
  Scenario: Delete the Trello board
    
    When user clicks on "UpdatedTestBoard" board
    Then the board title should be "UpdatedTestBoard"
    When user clicks on Show Menu
    And user clicks on Close Board
    Then user confirms Close Board
    And user clicks on Permanently Delete Board
    And user views delete confirmation message "Board deleted."
    Then the board should be deleted successfully "TestBoard"
    When user clicks on logout link
    Then user verifies page title contains "Log out of your Atlassian account"
    
@ui @negative
    Scenario: User attempts to create a board without entering a board name
    When user clicks on create new board button
    And user verifies "Board title is required"
   	When user checks if create board is disabled
    
 
