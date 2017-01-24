Feature: User verifies the units list, does points mapping on the Data Mapping screen

  # @test
  # Scenario: User verifies the units list displayed under Units button on Data mapping screen
  #  Given User logged in to Mems application with credentials from the "userProfile".json file
  # And User navigates to Data Mapping screen
  # And User waits to load "Data Mapping" page completely
  # When User clicks on the Units push button on Data Mapping screen
  # Then Verify that units displayed on "Data Mapping" screen are matching with the units from the "Units".json file
  
  @SmokeTestMap
  Scenario Outline: User discovers the points from DC database
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to "Data Mapping" screen
    And User waits to load "Setup-Data mapping pag" completely
    When User selects the datsource from Select datasource drop down
      | Data Source  |
      | <Datasource> |
    #And User waits until loader settles down
    And Verify that "No points under selected datasource.Please initiate discovery." message displayed
    And User clicks on the Discover button
    And User waits to load "Setup-Data mapping page" completely
    Then Verify that "Point discovery completed" message displayed
    And Verify that points tree is populated

    Examples: 
      | Datasource    |
      | Metasys_test1 |
      | Metasys_1			|
      | Metasys_2		  |
      
  @SmokeTestMapSync
  Scenario Outline: User maps the points and sync them to entity API
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to "Data Mapping" screen
    And User waits to load "Setup-Data mapping page" completely
    When User selects the datsource from Select datasource drop down
      | Data Source  |
      | <Datasource> |
    And User waits until loader settles down
    And Verify that points tree is populated
    Then Map the points from points tree
    And User waits until loader settles down
    And User sets the point template and clicks on the update button
    And User syncs the points with entity api
    And User waits until sync message goes away

    Examples: 
      | Datasource    |
      | Metasys_test1 |
