Feature: Trello Board API CRUD operations

Background:
    Given I have API credentials

@api @positive
Scenario: Create a new Trello board
    When I create a board with name "Test Board"
    Then the board "Test Board" should be created successfully
    
@api @positive
	Scenario: Retrieve a Trello board
		And I create a board with name "Test Board"
    When I retrieve the created board
    Then the board name should be "Test Board"
    
@api @positive
	Scenario: Update the created Trello board
    When I create a board with name "Test Board"
    When I update the created board name to "Updated Board"
    Then the board should be updated successfully
    
@api @positive
  Scenario: Delete a Trello board
    When I create a board with name "Test Board"
    When I delete the created board
    Then the board should be deleted successfully
    
@api @negative
   Scenario: Attempt to create a board with invalid API credentials
    Given I have invalid API credentials
    When I attempt to create a board with name "Test Board" using invalid credentials
    Then the board creation should fail with a 401 Unauthorized error
    And an error message indicating "invalid key" should be displayed
    
 