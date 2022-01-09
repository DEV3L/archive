Feature: Making Cheese
  As a cheese lover
  I want to make cheese
  So I can make everyone happy

  Scenario: Cheese is produced upon request by a user
    Given no cheese exists
    When I request cheese
    Then cheese was produced