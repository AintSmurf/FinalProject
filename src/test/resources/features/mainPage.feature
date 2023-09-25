Feature: main page functionalities

#  Background:
#    Given I am logged in

  Scenario: add item to cart
    Given I am logged in
    When i got to frozens section
    And i add a random item
    Then the cart has a single item in it
