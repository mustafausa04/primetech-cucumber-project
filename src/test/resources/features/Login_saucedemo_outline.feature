# Scenario outline means we will use this scenario multiple times with different data set in the parameters,
# the data set is what type of data you going to put in the parameters, what is parameters is the one in between
# <...> for ex <username>, <password>

Feature: Login to sauce demo
  As a user
  I should not be able to login using invalid credentials
# To make a scenario outline we have three rules
#  1. We need to use Scenario outline instead of Scenario
#  2. We need to parameterize the fields that will have different values
#  3. we need to use Examples for the parameters

#  Note: make sure you don't leave space in (Scenario Outline) and (:) like this (Scenario Outline :) it will
#  complain
  Scenario Outline: can not login with invalid credentials
    Given user on login page
    When user enters  "<username>" and enters "<password>"
    Then user should not be able to login

# use those from saucedemo.com with password secret_sauce to put them in the Example
#  locked_out_user
#  problem_user
#  performance_glitch_user
#  error_user
# if the those under (Examples:) are disorganized you can go up left, click on (Code) then Reformat Code they will
# organized like below
    Examples:
      | username                | password     |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_abc   |
      | performance_glitch_user | secret_xyz   |
      | error_user              | secret_rrr   |


