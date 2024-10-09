# we can use datatable if we have a situation like this below when we have multiple (and..and..and) so we will
# run the scenario one time only but we will run the list in it this is what's called (datatable)
# not like you running the scenario multiple times like (scenario outline).


Feature: Example of cucumber data table implementation

# this is the regular way
#  Given I like apple
#  And I like banana
#  And I like orange
#  And I like kiwi
#  When I go to the market
#  Then I should have 4 fruits in my basket

# this is the Datatable way
  @demo
  Scenario: List of fruit I like
    Given I have the following list of fruit
      | fruit  |
      | apple  |
      | banana |
      | orange |
      | kiwi   |
    When I go to the market
    Then I should have 4 fruits in my basket



