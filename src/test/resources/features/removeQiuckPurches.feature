Feature: create a a QuickBuy list and preform on it
  Scenario: Add products to the car using the QuickBuy list and remove the list instead of processing checkout
    Given : i'am on home page
    And : i click on QuickBuy
    When I write the products:
      | גלידה     |
      | בשר     |
      | שוקלוד |
    And I start adding all of them to the cart
    Then I remove it
    And I have an empty list



