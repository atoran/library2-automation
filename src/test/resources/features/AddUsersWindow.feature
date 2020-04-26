@wip
Feature: Add Users Window

  Background:
    Given I access Users page as a librarian
    When I click on Add User

  Scenario: Add users window default date
    Then start date should be today's date
    And end date should be one month from today

  Scenario: Add users close button
    And I enter new user information with random email
    When I click the Close link
    Then the users table should not contain user with that email

