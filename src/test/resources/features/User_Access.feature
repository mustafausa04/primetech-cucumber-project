# 1. test case: Login Functionality
# steps:
# 1. navigate to login page
# 2. enter valid email address "entityadmin@primetechschool.com"
# 3. enter valid password "primetech@school"
# 4. click on the login button
# 5. verify the user is redirected to the dashboard
# 6. verify a success message is displayed


# we will use the (tag) @crater to run it by itself if we want to just by put the tags = "@crater" in the
# (TestRunner) class
@crater
Feature: User Access Management
  As a user I want to login to my crater application

# Rule keyword in Gherkin is used to group scenarios that share the same context or preconditions.
# It was introduced in Gherkin 6 and is a way to organize scenarios that belong to the same rule or business rule.
#• This helps in structuring your feature files more effectively, making them easier to read and understand.
#• A Rule should contain one or more scenarios that illustrate the p
  Rule: valid login
    The application should allow valid users to log in

# we will use the key word Background to keep all the repeated steps in the other scenarios, in it so we don't
# have to repeat them in the other scenarios anymore
  Background:
    Given user is navigated to Crater login page


# we can add the tag @smoke in the scenarios level to do smoke test to this specific scenario, but if we put it
# the top above Feature it will execute the smoke test in all the scenarios in the Feature.
# now if we put @smoke @regression together then we need to use either (and) or (or) in TestRunner class to
# execute only the scenario that has those 2 tags at the same time so it will not execute the ones with @smoke
# only or @regression only but if we use (or) this will execute all @smoke and all @regression.
# if you put this tag @smoke @ignore it means run all smoke except the one with @ignore on it.
# @dev – If the scenario is still being worked on by dev team and its not in the testing queue yet , You want to
# make sure that this scenario is tested but when it arrives to testing queue
# @wip – Work in Progress -- This is added to scenario that were done by development teams but automation
# scripts still in progress.

# @smoke
# @smoke @ignore
  @smoke @regression
  Scenario: User should be able to login with valid credentials
    When user enters valid username and valid password
    And user clicks on login button
    Then user should be logged in successfully


# Cucumber reuses the steps that are already implemented.
# if there are same two steps, cucumber only generates one step definition and reuses that step definition
# between that two steps, so the first step Given and third one are the same in both scenario that's why
# cucumber will reuse them in the second scenario without generate them in the console when we run the
# DryTestRunner or TestRunner

  @regression
  Scenario: User should not be able to login with invalid email
    When user enters invalid username and valid password
    And user clicks on login button
    Then user should see an error message "These credentials do not match our records." displayed
    And user should not be logged in