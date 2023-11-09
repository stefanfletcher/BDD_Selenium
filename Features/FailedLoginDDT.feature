Feature: Login with Invalid Credentials DDT

  @Regression
  Scenario Outline:
    Given User Launches Browser
    And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters an Invalid username as "<Username>" and password as "<Password>"
    And Clicks on the Login button
    Then User is shown invalid details message and page remains the same

    Examples:
      | Username      | Password         |
      | Admin2        | admin123         |
      | Admin1        | admin123         |
      | Admin2        | admin123         |