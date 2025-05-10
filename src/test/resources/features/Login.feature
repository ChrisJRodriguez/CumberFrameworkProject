Feature: Login feature functionality

  @validLogin
  Scenario: Valid admin login functionality
    When user enters valid login username and password
    And user clicks on the login button
    Then user is successfully logged in

  @invalidLogin
  Scenario: Invalid login functionality
    When user enters invalid username and password
    And user clicks on the login button
    Then user is able to see error message