Feature: main page functionalities

  Background:
    Given I am logged in

  Scenario: add item to cart
    When i got to frozens section
    And i add a random item
    Then the cart has a single item in it

    Scenario: add the cheapest frozen product to the cart
      When i ckick on sort
      And add the first product to the cart
      Then i have the cheapest product in the cart