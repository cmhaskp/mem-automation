Feature: User verifies the units list, adds Meters and Submeters Meter Distribution tree, does points mapping to the meters added.

  @test
  Scenario: User verifies the units list displayed under Units button on Meter Configuration screen
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to Meter configuration screen
    And User waits to load "Meter Configuration page" completely
    When User clicks on the Units push button
    Then Verify that units displayed on "Meter configuration" screen are matching with the units from the "Units".json file
