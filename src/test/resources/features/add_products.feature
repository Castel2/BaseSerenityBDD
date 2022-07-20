Feature: Add products to shopping cart
  As a user of the Swag Labs
  I need to add products
  To the make my purchases

  Scenario: Add products
    Given User logs in the whit credentials
      | username      | password     |
      | standard_user | secret_sauce |
    When Select product from 9.99
    Then View the product in the shopping cart