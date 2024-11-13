@db-test
Feature: Add Item
  As a user
  I want to add an item to the list of item
  So i can see it as part of the list

  Scenario: Successfully add a new item and verifiy it in the DB
    Given user is logged in successfully
    And the user is on the item page
    When the user clicks on the Add Item button
    And the user enters the item name
    And the user enters the item description
    And the user enters the item price "12.99"
    And the user enters the item unit "grams"
    And the user clicks on the Save Item button
    Then the item should be listed in the items table
    And the item is added into the DB