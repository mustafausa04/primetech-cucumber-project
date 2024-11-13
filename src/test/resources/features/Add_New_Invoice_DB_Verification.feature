#this is an example of data base testing using cucumber
@db-test
Feature: Add new Invoice

  Scenario: Add new invoice and verify in the DB
    Given user is logged in successfully
    And the user is on the invoices page
    When the user clicks on the Add New Invoice button
    And the user selects a client from the New Customer dropdown
    And the user select the first item
    And the user add exchange rate "23"
    And the user enters the price "4.99"
    And the user clicks on the Save Invoice button
    Then the invoice should be saved and listed in the invoices list
    And the invoice should be added to the database