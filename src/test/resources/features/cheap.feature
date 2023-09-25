
Feature: add the cheap
  Scenario: add the cheapest frozen product to the cart
    Given I am logged inn
    When i got to frozens sectionn
    And i ckick on sort
    And add the first product to the cart
    Then i have the cheapest product in the cart