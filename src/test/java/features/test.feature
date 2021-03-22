Feature: The user can log into the system and control of the product name,product price and total amount of items in the basket

  Scenario: Login with correct username and password
    Given Navigate to the login page
    When Fill in email and password
    And Press login button
    Then Have to check the page address

  Scenario: Adding one dress and one t-shirt to the basket and assert the price,product name and total amount
    When Log into the system
    And Go to dresses category
    And Go to summer dresses category
    And Add second product in the basket.Product name and product price are noted
    And Go to t-shirt category
    And Add any product in the basket.Product name and product price are noted
    And Go to cart page
    Then Assert dress and shirt names
    And Assert dress and shirt prices
    And Assert total price
