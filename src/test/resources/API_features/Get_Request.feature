Feature: API Automation

  Scenario: sends GET request with query parameters
    Given I perform operation with GET endpoint "/data"
    And I use given query parameters
    Then I should see the list of data
