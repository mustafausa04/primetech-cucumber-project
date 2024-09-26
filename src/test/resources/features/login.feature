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