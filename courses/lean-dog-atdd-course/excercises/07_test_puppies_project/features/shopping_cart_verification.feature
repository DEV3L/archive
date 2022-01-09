Feature: Shopping Cart Verification
  As a puppy lover
  I want my shopping cart to display relevant details of my order
  So that I know I am adopting the puppy I love best before checking out

  Scenario: Shopping cart displays the details of the selected puppy
    Given I am looking for a puppy
    When I view the details puppy 1
    And I adopt the puppy
    Then I should see "Brook" as the name of the puppy in my cart
    Then I should see "Female - Golden Retriever" as the type of the puppy in my cart
    Then I should see "$34.95" as the price of the puppy in my cart
    Then I should see "$34.95" as the total price of my cart

  Scenario: Shopping cart displays the details of two selected puppy
    Given I am looking for a puppy
    When I view the details puppy 1
    And I adopt the puppy
    And I want to adopt another puppy
    When I view the details puppy 2
    And I adopt the puppy
    Then I should see "Brook" as the name of the puppy in my cart
    Then I should see "Female - Golden Retriever" as the type of the puppy in my cart
    Then I should see "$34.95" as the price of the puppy in my cart
    Then I should see "$57.94" as the total price of my cart