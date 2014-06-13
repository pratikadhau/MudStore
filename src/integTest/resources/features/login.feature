Feature:Login

Scenario: Login_should_not_be_allowed
    When I entered username pratik1 and password adhau.
    Then I should not allowed to login
    
Scenario: Successfull login should land up in home page
    When I entered username pratik and password adhau.
    Then I should be able to see home page
