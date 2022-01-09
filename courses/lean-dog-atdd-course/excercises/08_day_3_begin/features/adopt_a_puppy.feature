Feature: Adopt A Puppy
  As an animal lover
  I want to adopt a puppy
  So that I can have a great companion and give a puppy a better life

  Background:
    Given I am looking for a puppy to adopt

  Scenario: Adopt One Puppy
    When I view the details of puppy 1
    And I adopt the puppy
    And I complete the adoption
    And I checkout with:
      | name      | address      | email        | payment type |
      | Pat Kelly | 123 Main St. | pat@atdd.com | Check        |
    Then I should see the message "Thank you for adopting a puppy!"

  Scenario: Adopt Two Puppies
    When I view the details of puppy 1
    And I adopt the puppy
    And I adopt another puppy
    When I view the details of puppy 2
    And I adopt the puppy
    And I complete the adoption
    And I checkout with:
      | name      | address      | email        | payment type |
      | Pat Kelly | 123 Main St. | pat@atdd.com | Check        |
    Then I should see the message "Thank you for adopting a puppy!"