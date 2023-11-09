Feature: Login with Valid Credentials DDT

  @Regression
  Scenario Outline:
    Given User Launches Browser
    And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters a valid username and password with excel row "<row_index>"
    And Clicks on the Login button
    Then User is navigated to MyAccount Page

    Examples:
      |row_index|
      |1|
      |2|