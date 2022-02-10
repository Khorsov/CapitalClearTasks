Feature: Products to Shopping Cart from Main page
   As User can add product to Shopping cart from main page

  Background: Main page
    Given User is on the main page

  Scenario: User picks the first product using search bar
      When User is searching sofa out of searchbar
      Then User picks first item from the list

  Scenario: User picks the third product using search bar
      When User is searching table out of searchbar
      Then User picks third item from the list
