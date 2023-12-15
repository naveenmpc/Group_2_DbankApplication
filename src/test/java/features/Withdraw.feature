Feature: Testing dbankdemo Withdraw from Account feature

  Scenario: Testing Withdraw from Account
    Given User is on Withdraw page
    When Validating Reset button of Withdraw page
    Then Validating Submit button without data
    And Validating Submit button with Amount as zero
    Then Validating succesful Withdraw transaction with valid credentials
