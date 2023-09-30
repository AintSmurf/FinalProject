Feature: main page functionalities

  Background:
    Given I am logged in

  Scenario: add item
    When navigate to frozenpage.
    And i add an item.
    Then the cart has a single item in it
