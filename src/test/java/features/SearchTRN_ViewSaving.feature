Feature: Testing dbankdemo Search TRN of View Savings feature

  Scenario: Testing for Searching TRN of View Savings page 
    Given User is on View Savings page
    Then Validate Search box with valid TRN on View Savings
    And Validate Search box with invalid TRN on View Savings