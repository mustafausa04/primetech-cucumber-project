#we start with Feature: and give it a name and we will tag it with @api so we can run by its tag name
#then we put the rest of steps
@api
Feature: Get list of invoices

  Scenario: Get list og invoices
    Given Im logged in successfully
    When I perform GET operation for "api/v1/invoices" endpoint
    Then I should get 200 status code
    And I should get list of invoices