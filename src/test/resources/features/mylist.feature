Feature: create a a Quick Buy and preform on it

  Scenario: Add products to the cart and remove the list instead of processing checkout
    Given I am on the home pagee
    And I open myList tap
    When I add the these products to the list:
      | Milk     |
      | Meat     |
      | Icecream |
    When I go back to the List
    And remove it
    Then my list is empty

