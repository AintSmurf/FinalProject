
Feature: Search for items
  Background:
    Given I am on the home page

  Scenario Outline: Search for a keyword on the RamiLevi website
    When I search for "<keyword>"
    Then I verify the keyword "<expectedKeyword>"

    Examples:
      | keyword    | expectedKeyword |
      | גלידה      | גלידה           |
      | שוקולד    | שוקולד          |
      | מקרר       | מקרר            |