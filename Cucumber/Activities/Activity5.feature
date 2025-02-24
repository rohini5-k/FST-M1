@activity5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Get your page title and confirmation message
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |