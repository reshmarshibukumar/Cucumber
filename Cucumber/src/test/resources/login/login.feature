Feature: LoginCheck

  Scenario: Valid Login
    Given user is on login page
    When user enters username "student" and password "Password123"
    And clicks on submit  button
    Then user navigated to next page
