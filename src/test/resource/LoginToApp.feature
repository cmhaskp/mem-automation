Feature: User logged into the MEMs application with the correct credentials

  @Login
  Scenario: User logs into the MEMs application
    Given User enters mems url into the browser
    When User enters LoginUserName as in the "userProfile".json file
    And User enters LoginPassword
    Then User click on the login button
    And verify that Overview dashboard screen should be displayed
