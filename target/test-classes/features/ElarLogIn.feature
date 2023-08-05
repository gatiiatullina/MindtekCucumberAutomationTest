
@regression, @smoke, @login
Feature: ElarLogistic application login feature

  Scenario: Validating login feature with valid credentials
    #before
  Given User navigates to "ElarLogistic" application
    When User enters username "student@mindtekbootcamp.com" and password "ilovejava"
    And User click on login button
    Then User validates application is logged in
    #after