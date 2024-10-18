#1.	Navigate to the Invoices page.
#2.	Click on the Add New Invoice button.
#3.	Select a client from the New Customer dropdown.
#4.	Enter Exchange rate 23
#5.	Select an Item from the Item dropdowns
#6.	Enter a quantity of 2
#7.	Enter a Price 4.99
#8.	Click the Save Invoice button.
#9.	Verify the invoice is saved and listed in the invoices list.
#10. Verify the invoice total matches the added items and their quantities.



@crater
Feature: Add new invoice
  As a user
  I should be able to add a new invoice

  Scenario: Successfully add a new invoice
    Given user is logged in successfully
    And the user is on the invoices page
    When the user clicks on the Add New Invoice button
    And the user selects a client from the New Customer dropdown
    And the user select the first item
    And the user add exchange rate "23"
    And the user enters the price "4.99"
    And the user clicks on the Save Invoice button
    Then the invoice should be saved and listed in the invoices list
    #And the invoice total should match the items and their quantities



