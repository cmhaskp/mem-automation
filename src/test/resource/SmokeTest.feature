#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @SmokeTestAddDC
  Scenario Outline: To verify that user is able to add Metasys datasource
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to datasource screen
    And User waits to load "Setup-Datasource page" completely
    When User adds the "Metasys" datasource with below inputs
      | Data source type | Data source name   | Server IP   | Database   | Time zone                                       | Username | Password   |
      | Metasys          | <Data source name> | <Server IP> | <Database> | (GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi | sa       | XMG3-Rel.1 |
    Then Verify that "Data source added successfully" message displayed
    And User waits until datasource comes online
    And User verifies the test connection for added datasource
    And User waits to load "Setup-Datasource page" completely
    And Verify that "Test connection success" message displayed

    Examples: 
      | Data source name | Server IP                         | Database       |
      | Metasys_test1    | 10.109.211.206,1433\\MEMS-IEC-DEV | JCIHistorianDB |

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
      | From date  | To date    |
      | 01/01/2016 | 08/22/2016 |
    And User submits the historian request
    Then Verify that "Historian data requested" message displayed

    Examples: 
      | Datasource |
      | Metasys_1  |
