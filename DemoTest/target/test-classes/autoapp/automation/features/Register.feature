Feature: Registering to automation practice

  Scenario: Validate user is able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto.com"
    Then I should be able to register with my below details
      | Gender | FirstName | LastName  | Password  | Address            | City      | State  | Zip   | Mobile     |
      | Mr     | TestFName | TestLName | Password1 | 100 Spencer Street | Anchorage | Alaska | 30000 | 0406345454 |

  Scenario: Validate user sees an error message for invalid email
    Given Automation practice application is opened
    When I click sign in
    And I create an account with an invalid emailid "testRandom"
    Then I should see an invalid email error

  Scenario: Validate user successfully navigates to Summer Dresses category
    Given Automation practice application is opened
    When I Navigate to Summer Dresses
    Then I should see the Summer Dresses selection

  Scenario: Validate user successfully navigates to Summer Dresses category
    Given Automation practice application is opened
    When I Navigate to Summer Dresses
    Then I should see the Summer Dresses selection

  Scenario: Adding item to card and verifying cart contents
    Given Automation practice application is opened
    When I Navigate to Summer Dresses
    And I use the quickview to add a blue dress to the cart
    Then I should see the correct item in the cart summary
