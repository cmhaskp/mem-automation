Feature: User can request historian data using Historical data tab for the selected datasource.

  @SmokeTestHistorian
  Scenario Outline: User puts a historian request for all the data for selected datasource
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to "Historical data" screen
    And User waits to load "Setup-Historical data page" completely
    When User selects the datsource from Select datasource drop down
      | Data Source  |
      | <Datasource> |
    And User selects the points for historian data request
    And User selects From date and To date as below
    	| From date		| To date     |
    	| 01/01/2016 	| 08/22/2016  |
    And User submits the historian request
    Then Verify that "Historian data requested" message displayed
    
		Examples: 
      | Datasource   |
      | Metasys_1 	 |    
      

  
