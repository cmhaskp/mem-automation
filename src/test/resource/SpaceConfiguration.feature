Feature: User adds node to the space tree to create space hierarchy on the settings screen

  @testspace
  Scenario: User add a space hierarchy via excel upload
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User maximize the browser window
    And User navigates to Space configuration screen
    When User browses the excel sheet
    And User uploads the excel sheet
    And User waits to load "Setup-Space page" completely
    Then Verify that space hierarchy created successfully

  Scenario: User adds a facility to the portfolio
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to Space configuration screen
    When User selects portfolio and adds a facility
    And User saves the facility to entity api
    Then Verify that facility is added at the end of tree

  Scenario: User adds a Building to the to the facility
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to Space configuration screen
    When User selects a facility and adds a building
    And User saves the building to entity api
    Then Verify that building is added below the facility
 
  #@SmokeTest
  Scenario: User sets the commodity units and cost per unit rate at the portfolio level
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to Space configuration screen
    And User waits to load "Setup-Space page" completely
    When User selects a Select Units button
    And User sets the Default units to all the commodities as in the table below :
      | Electricity | ElectricalDemand | Water | HotWater | ChilledWater | Gas | Steam | FuelOil | Propane | Diesel  | Sewage  | Coal | AreaUnit   | Currency  |
      | kWh         | kW               | cu ft | Btu      |  Btu         | cu m|  lb   | IMP Gal | kL      | IMP Gal | US Gal | kg   | square feet| US Dollar |
    Then Verify that label for text box displayed correctly
    And User submits the Default units
    And User waits to load "Setup-Space page" completely
    And Verify that saved successfully message displayed as in "successmessage".json file
    
      