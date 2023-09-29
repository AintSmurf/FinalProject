Feature: remove all the products form the cart
  Scenario: add product and then remove it
    Given iam in the frozen page
    When i add a some item
    And i remove all the cart
    Then i have an empty cart