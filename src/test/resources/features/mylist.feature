Feature: create a a Quick Buy and preform on it

  Background:
    Given I am on the home pagee
    And I open myList tap

  Scenario: Add products to the cart and remove the list instead of processing checkout
    When I add the these products to the list:
      | Milk     |
      | Meat     |
      | Icecream |
    When I go back to the List
    And remove it
    Then my list is empty

  Scenario: Add products to the cart from my Quick Buy list
    When I add the these products to the list:
      | Milk     |
      | Meat     |
      | Icecream |
    And click on finished
    Then I have milk and meat and icecream on my cart
