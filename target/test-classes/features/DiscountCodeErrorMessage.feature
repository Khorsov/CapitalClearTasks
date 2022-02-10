Feature: User sees discount error message when applying in the Shopping Cart

  Scenario: User can see correct amount of products added
    Given User on shopping cart page
    Then User can see correct amount of products added

  Scenario: User applying discount with incorrect code
    Given User can see Use A Discount Code button
    When User clicks on discount code button
    And User add incorrect discount code
    And User clicks Apply discount
    Then User can see invalid coupon code error message is displayed

