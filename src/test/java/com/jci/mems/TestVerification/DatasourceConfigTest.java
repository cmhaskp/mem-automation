package com.jci.mems.TestVerification;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jci.mems.CucumberPageObject.AbstractPage;
import com.jci.mems.CucumberPageObject.DataMappingPage;
import com.jci.mems.CucumberPageObject.DatasourceConfigPage;
import com.jci.mems.CucumberPageObject.SpaceConfigPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DatasourceConfigTest {
	
	WebDriver driver; 
	String url;
	SpaceConfigPage spaceconfigpage;
	DatasourceConfigPage datasourceconfigpage;
	DataMappingPage datamappingpage;
	AbstractPage abstractpage;
	JSONParser parser;
	JSONObject json;
	String parentWindow;
	String dataSource;
	
	
	public DatasourceConfigTest() {
		driver = Hooks.driver; 	
		url = Hooks.envURL;
	}
	
	@Given("^User navigates to datasource screen$")
	public void user_navigates_to_datasource_screen() throws Throwable {
		
		datasourceconfigpage = new DatasourceConfigPage(driver);
		
		driver.navigate().to(url + "Configuration/#/datasource");
		
		datamappingpage = new DataMappingPage(driver);
		
		datamappingpage.switchToiFrame();
		
		//datasourceconfigpage.selectDataSourceTab();
			    
	}


	@When("^User adds the \"(.*?)\" datasource with below inputs$")
	public void user_adds_the_Metasys_datasource_with_below_inputs(String dataSourceType, DataTable datasource) throws Throwable {
			    
		List<Map<String, String>> data  = datasource.asMaps(String.class, String.class);
		
		for (Map<String, String> map : data) {
			
						
			Select selectDatasource = datasourceconfigpage.selectDatasource();
			selectDatasource.selectByVisibleText(map.get("Data source type").toString()); 
			
			dataSource = map.get("Data source name");
			
			WebElement dataSourceName = datasourceconfigpage.getDatasourceName();
			dataSourceName.sendKeys(dataSource);
			
			if (dataSourceType.equals("Modbus")){
							
				WebElement port = datasourceconfigpage.getPort();
				port.sendKeys(map.get("Port"));
				
				WebElement ipAddress = datasourceconfigpage.getIpAddress();
				ipAddress.sendKeys(map.get("IP address"));
				
			}
			
			if (dataSourceType.equals("Metasys")){
				
				WebElement serverIp = datasourceconfigpage.getServerIP();
				serverIp.sendKeys(map.get("Server IP"));
				
				WebElement databaseName = datasourceconfigpage.getDatabasePath();
				databaseName.sendKeys(map.get("Database"));
				
				WebElement user = datasourceconfigpage.getUser();
				user.sendKeys(map.get("Username"));
				
				WebElement password = datasourceconfigpage.getPassword();
				password.sendKeys(map.get("Password"));
			
			}
						
			Select selectTimezone = datasourceconfigpage.selectTimezone();
			selectTimezone.selectByVisibleText(map.get("Time zone").toString()); 	
			
			Thread.sleep(1000);
			datasourceconfigpage.enableDriver();
			
		}
		
		datasourceconfigpage.addDatasource();
	}

	@Then("^Verify that \"(.*?)\" message displayed$")
	public void verify_that_datasource_added_successfully_message_displayed(String expectedPopUpMessage) throws Throwable {
			
		datasourceconfigpage = new DatasourceConfigPage(driver);
		
		String actualPopUpMessage = datasourceconfigpage.getPopUpMessage().replaceAll("[\r\n]+", "").trim();
						
	    System.out.println("Actual Message :" + actualPopUpMessage);
		
		datasourceconfigpage.closePopUp();
		
		if (actualPopUpMessage != null){
		
		Assert.assertEquals("Pop up message not as expected", expectedPopUpMessage, actualPopUpMessage);
		
		} else {
			
			throw new NullPointerException();
		}	    
	}
	

	@Then("^User waits until datasource comes online$")
	public void user_waits_until_datasource_comes_online() throws Throwable {
	    		
		int wait = 0;
		  
		  for (int count=0;count<60;count++){
			  
			  String datasoureStatus = datasourceconfigpage.checkDatasourceStatus(dataSource);
			  
				  if (datasoureStatus.equals("Online")) {
					  
					  System.out.println("Datasource is online");
					  
					  break;
					  
				  }  else {
					  System.out.println("Waiting for the the datasource to come online count: " + count);
					  Thread.sleep(1000);
					  wait++;
				  }  
			  
			  
		  }
		  
		  if (wait>59) {
			  
			  System.out.println("Timeout : Datasource is not online");
		  }
			  
	
	}
	
	@Then("^User verifies the test connection for added datasource$")
	public void user_verifies_the_test_connection_for_added_datasource() throws Throwable {
	    
		datasourceconfigpage.selectDatasourcefromGrid(dataSource);
		
		datasourceconfigpage.testConnection();
	}

}
