Feature: Testing dbankdemo Visa Direct Transfer feature

  Scenario: Testing  Visa Direct Transfer
    Given User is on  Visa Direct Transfer page
    Then Validating Submit button without filling any fields
    When Validating Select Account drop-down without selecting actual account
    Then Validating Submit button with zero amount field
    Then Validating Submit button with amount as decimals more than two
    And Validating succesful Visa Direct Transfer transaction with valid credentials