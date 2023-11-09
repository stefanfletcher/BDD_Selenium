Feature: Login with Valid Credentials

  @Regression
  Scenario:
    Given User Launches Browser
    And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters a valid username as "Admin" and password as "admin123"
    And Clicks on the Login button
    Then User is navigated to MyAccount Page