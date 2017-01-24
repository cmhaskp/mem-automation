Feature: User verifies the add, update, delete to the datasources.

  @SmokeTest
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
      | Data source name | Server IP                         | Database            |
      #| Metasys_test1    | 10.109.211.206,1433\\MEMS-IEC-DEV | JCIHistorianDB      |
      | Metasys_test2    | 10.109.211.206,1433\\MEMS-IEC-DEV | JCIHistorianDBTest1 |

    @SmokeTest
    Scenario Outline: To verify that user is able to add BACnet datasource
     And User deletes browser cookies
     And User maximize the browser window
     Given User logged in to Mems application with credentials from the "userProfile".json file
     And User navigates to datasource screen
     And User waits to load "Setup-Datasource page" completely
     When User adds the "BACnet" datasource with below inputs
       | Data source type | Data source name | Time zone                                       |
       | BACnet           | BACnet_Mum       | (GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi |
     Then Verify that "Data source added successfully" message displayed
    Examples:
    | Data source name |
    | BACnet_test1     |
    #| BACnet_test2     |
 
  @SmokeTest
  Scenario Outline: To verify that user is able to add Modbus datasource
    And User deletes browser cookies
    And User maximize the browser window
    Given User logged in to Mems application with credentials from the "userProfile".json file
    And User navigates to datasource screen
    And User waits to load "Setup-Datasource page" completely
    When User adds the "Modbus" datasource with below inputs
     | Data source type | Data source name   | Time zone                                       | Port | IP address     |
     | Modbus           | <Data source name> | (GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi | 502  | 10.109.211.239 |
   Then Verify that "Data source added successfully" message displayed

    Examples: 
     | Data source name |
     | Modbus_test1     |
    # | Modbus_test2     |
