@activity4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given User is on the Login page
    When User enters his "admin" and "password"
    Then Read current page title and confirmation message