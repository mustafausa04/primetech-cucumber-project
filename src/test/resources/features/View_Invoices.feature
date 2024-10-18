# BElow is an example of the manual test case for the gherkin
#  1.	Navigate to Crater application (You are able to login successfully)
#  2.	Navigate to the Invoices page.
#  3.	Verify Invoices label is displayed
#  6.	Click on a specific invoice to view its details.
#  7.	Verify the invoice details are displayed correctly on the right side of the screen.



# we add @crater so when we execute the crater app only scenarios with @crater will run
@crater
Feature: View Invoices

  Scenario: Successfully view and navigate to the invoices page
    Given user is logged in successfully
    And the user is on the invoices page
    Then the Invoices label should be displayed
    And the user clicks on a specific invoice
    Then the invoice details should be displayed on the right side of the screen

# note: make sure the (Given) step above is always the same so you can use it all the time in different scenarios
# because if there is any letter change in it different than what you have in the other scenario it will be undefined
# and the (DryTestRunner) will generate a new step for it and you have to implemented again



