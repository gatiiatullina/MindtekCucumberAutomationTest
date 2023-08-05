@regression @ui @etsy
  Feature: Validating Search functionality

#    Background will run steps bellow once for each Scenario.
    Background: Repeated Steps
      Given User navigates to Etsy application
      When User searches for "carpet"


      @itemDescription
    Scenario: Validating search result matches with the searched item
#      Given User navigates to Etsy application
#      When User searches for "carpet"
      Then User validates search result contains "carpet"
        | carpet  |
        | rug     |
        | turkish |
        | persian |
#      The value above are in a DataTable format. @Then step will accept values that are bellow in pipes.

    @priceRange
  Scenario: Validating price range functionality for searched item
    And User selects price range over 1000
    Then User validates price range for items over 1000.00
