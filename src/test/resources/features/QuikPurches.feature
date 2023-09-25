Feature: create a a Quick Buy
  Scenario: Add products to the cart from my Quick Buy list
    Given : iam on homepage
    And : i click on QuickBuy
    When I write the products:
      | גלידה     |
      | בשר     |
      | שוקלוד |
    And I start adding all of them to the cart
    And click on finished
    Then I have milk and meat and icecream on my cart
