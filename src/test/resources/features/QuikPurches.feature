Feature: create a a Quick Buy
  Scenario: Add products to the cart from my Quick Buy list
    Given I am on the home pag
    And I open myList tapp
    When adding these proucts:
      | Milk     |
      | Meat     |
      | Icecream |
    And click on finished
    Then I have milk and meat and icecream on my cart
