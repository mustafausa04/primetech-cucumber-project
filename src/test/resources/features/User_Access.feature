# 1. test case: Login Functionality
# steps:
# 1. navigate to login page
# 2. enter valid email address "entityadmin@primetechschool.com"
# 3. enter valid password "primetech@school"
# 4. click on the login button
# 5. verify the user is redirected to the dashboard
# 6. verify a success message is displayed


Feature: User Access Management
  As a user I want to login to my crater application

  Scenario: User should be able to login with valid credentials
    Given user is navigated to Crater login page
    When user enters valid username and valid password
    And user clicks on login button
    Then user should be logged in successfully


# Cucumber reuses the steps that are already implemented.
# if there are same two steps, cucumber only generates one step definition and reuses that step definition
# between that two steps, so the first step Given and third one are the same in both scenario that's why
# cucumber will reuse them in the second scenario without generate them in the console when we run the
# DryTestRunner or TestRunner

  Scenario: User should not be able to login with invalid email
    Given user is navigated to Crater login page
    When user enters invalid username and valid password
    And user clicks on login button
    Then user should see an error message "These credentials do not match our records." displayed
    And user should not be logged in