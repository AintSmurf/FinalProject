Feature: create a a Quick Buy

  Background:
    Given I am on homepage
    And I click on QuickBuy

  Scenario: Add products to the cart from my Quick Buy list
    When I start add these products:
      | במבה  |
      | שוקו  |
      | פררו  |
    And I start adding all of the products to the cart
    And click on finished
    Then I have the products in the cart:
      | שוקו יטבתה 1 ליטר |
      | בונבוניירת פררו רושה 200 גרם  |
      | במבה חטיף בוטנים אסם 10*25 גרם |

