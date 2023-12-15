Feature: Testing dbankdemo Search TRN of View Checking feature

  Scenario: Testing for Searching TRN of View Checking page 
    Given User is on View Checking page
    Then Validate Search box with valid TRN
    And Validate Search box with invalid TRN