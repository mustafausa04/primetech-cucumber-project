# Transform below test cases into Gherkin language using Given/When/
# ThenTest case 1:
# On saucedemo.com home page
# Verify that login button is displayed
# And verify Swag labs label is displayed
# Test case 2:
# On saucedemo.com home page
# Enter username standard_user
# Enter password secret_sauce
# Verify Products label is displ




Feature: Login feature
  As a user I should be able to verify that login is working as expected


  Scenario: User can login using valid username and password
    Given User is navigated to saucedemo.com
    When User enters "standard_user" in the username field
    And User enters "secret_sauce" in the password field
    And User clicks on Login Button
    Then User is able to verify the "Products" label is displayed


  #to comment out everything, high light everything and do ctrl+/
#  Scenario: User cannot login using invalid username and valid password
#    Given User is navigated to saucedemo.com
#    When User enters "locked_out_user" in the username field
#    And User enters "secret_sauce" in the password field
#    Then User is able to verify that the error message "Epic sadface: Sorry, this user has been locked out." is displayed