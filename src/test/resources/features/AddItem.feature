Feature: FrozenPage functionalities

  Background:
    Given I'am on homepage
    When i am navigating to frozen page

  Scenario: add item to cart
    And i add a random item
    Then the cart has a single item in it
  Scenario: Sort By Cheapest then add item
    And i click on sort
    And add the first product to the cart
    Then i have the cheapest product in the cart
  Scenario: Add products to the cart using the QuickBuy list and remove the list instead of processing checkout
    And : i click on QuickBuy
    And I write the products:
      | גלידה |
      | בשר   |
      | שוקולד|
    And I start adding all of them to the cart
    Then I remove it
    And I have an empty list


