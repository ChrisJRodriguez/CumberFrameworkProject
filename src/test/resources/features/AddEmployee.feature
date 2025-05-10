Feature: Adding employees

  Background:
    #Given user is able to access HRMS application
    When user enters valid login username and password
    And user clicks on the login button
    When user clicks on PIM option
    And user clicks on Add Employee option

  @EID
  Scenario: Adding one employee
    When user enters <firstname> and <lastname>
    And user clicks on save button
    And the system generates a unique EID
    Then employee is added successfully

  @noEID
  Scenario: Adding one employee with a unique employee ID
    When user enters <firstname> and <lastname> and <EID>
    And user clicks on save button
    Then user is added successfully

  @errorMsg
  Scenario: Adding employee incorrectly
    When user skips the first or last name entry
    And user clicks on save button
    Then user can see the error message