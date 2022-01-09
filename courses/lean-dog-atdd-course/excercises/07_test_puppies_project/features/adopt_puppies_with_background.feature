Feature: Adopt a puppy
  As a puppy lover
  I want to adopt a puppy
  So that I can give a puppy a better life

  Background:
    Given I am looking for a puppy
    When I view the details puppy 1
    Then I should see details for "Brook"

  Scenario: Adopt the first puppy
    And I adopt the puppy
    And I complete the adoption
    And I enter "Pat Kelly" as the name
    And I enter "123 Main St." as the address
    And I enter "jus.beall@gmail.com" as the email
    And I select "Check" as the payment type
    And I complete the order
    Then I should see the message "Thank you for adopting a puppy!"

  Scenario: Adopt the first puppy using table arguments
    And I adopt the puppy
    And I complete the adoption
    And I fill out the details form
      | name      | address      | email               | payment |
      | Pat Kelly | 123 Main St. | jus.beall@gmail.com | Check   |
    And I complete the order
    Then I should see the message "Thank you for adopting a puppy!"

  Scenario: Adopt the two puppies
    And I adopt the puppy
    And I want to adopt another puppy
    When I view the details puppy 2
    Then I should see details for "Hanna"
    And I adopt the puppy
    And I complete the adoption
    And I fill out the details form
      | name      | address      | email               | payment |
      | Pat Kelly | 123 Main St. | jus.beall@gmail.com | Check   |
    And I complete the order
    Then I should see the message "Thank you for adopting a puppy!"
