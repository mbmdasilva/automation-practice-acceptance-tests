Feature: Search by Price

  @smoke-test
  Scenario: Search for expensive dress on new account
    Given A new customer account is created
    And The customer logs in with the new account
    When The customer search for the most expensive dresses
    And The selected dress is added to cart
    And The customer log out and back in again
    Then The selected dress must still be in the cart