Feature: main page functionalities

  Background:
    Given I am logged in

  Scenario: add item
    When I add an item
    Then the cart has a single item in it