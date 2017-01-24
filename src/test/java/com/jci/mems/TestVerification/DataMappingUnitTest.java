package com.jci.mems.TestVerification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.CucumberPageObject.DataMappingPage;
import com.jci.mems.CucumberPageObject.DatasourceConfigPage;
import com.jci.mems.CucumberPageObject.HistoricalDataPage;
import com.jci.mems.CucumberPageObject.MeterConfigPage;
import com.jci.mems.CucumberPageObject.SpaceConfigPage;
import com.jci.mems.mems_automation.ReadJson;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataMappingUnitTest {

		WebDriver driver;
		String url;
		DataMappingPage datamappingpage;
		DatasourceConfigPage datasourceconfigpage;
		WebDriverWait wait;
		String currentWindowHandle;
		JSONObject json; 
		HistoricalDataPage historicaldatapage;
		
		public DataMappingUnitTest(){
			
			driver = Hooks.driver; 
			url = Hooks.envURL;
		}
		
		@When("^User clicks on the Units push button on Data Mapping screen$")
		public void user_clicks_on_the_Units_push_button() throws Throwable {
			currentWindowHandle = driver.getWindowHandle();
			datamappingpage.selectUnitsButton();  
		}	
		
		@When("^User waits until loader settles down$")
		public void verify_that_Meter_configuration_page_loaded() throws Throwable {
		  int wait = 0;
		  
		  datamappingpage = new DataMappingPage(driver);  
		  
		  for (int count=0;count<20;count++){
			  
			  WebElement loader = datamappingpage.waitForLoader();
			  
				  if (!loader.isDisplayed()) {
					  
					  System.out.println("page loaded completely");
					  
					  break;
					  
				  }  else {
					  
					  System.out.println("Waiting for the page to load " + count);
					  Thread.sleep(500);
					  wait++;
				  }  
			  
			  
		  }
		  
		  if (wait>19) {
			  
			  System.out.println("Timeout : Meter configuration page not loaded");
		  }
			  
		  
		}
		
		@When("^User selects the datsource from Select datasource drop down$")
		public void user_selects_the_datsource_from_Select_datasource_drop_down(DataTable Datasource) throws Throwable {
		 
			List<Map<String, String>> data = Datasource.asMaps(String.class, String.class);
			
			for (Map map : data) {
				
				datasourceconfigpage = new DatasourceConfigPage(driver);
				  
				Select selectDatasource = datasourceconfigpage.selectDatasource();
				selectDatasource.selectByVisibleText(map.get("Data Source").toString());
			}
		  
		}

		@When("^User clicks on the Discover button$")
		public void user_clicks_on_the_Discover_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			datamappingpage = new DataMappingPage(driver);
			datamappingpage.selectDiscoverButton();
		}

		@Then("^Verify that points tree is populated$")
		public void verify_that_points_tree_is_populated() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			List<WebElement> pointsTree = datamappingpage.checkPointsTree();
			if(pointsTree.size()!=0 && pointsTree != null ){
				
				System.out.println("Points tree populated successfully");
				
			} else {
				
				throw new NullPointerException();
			}
			
		}
		
		@Then("^Map the points from points tree$")
		public void map_the_points_from_points_tree() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			List<WebElement> sourceElements = datamappingpage.checkPointsTree();
			WebElement destElement = datamappingpage.getdestElement();
			System.out.println("Destination Element " + destElement);
			datamappingpage.dragAndDrop(sourceElements,destElement);
			
			
		}

		@Then("^User sets the point template and clicks on the update button$")
		public void user_sets_the_point_template_and_clicks_on_the_update_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			datamappingpage.setEntityTemplate();
		  
		}

		@Then("^User syncs the points with entity api$")
		public void user_syncs_the_points_with_entity_api() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			datamappingpage.clickOnSyncButton();
		}
		
		@Then("^User waits until sync message goes away$")
		public void User_waits_until_sync_message_goes_away() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			int wait =0 ;
			
			for (int count=0;count<30;count++){
				  
				String syncMessage = datamappingpage.verifySyncMessage();
				  
					  if (syncMessage.isEmpty()) {
						  
						  System.out.println("Points synced to entity API");
						  
						  break;
						  
					  }  else {
						  
						  System.out.println("Waiting for the points to sync " + count);
						  Thread.sleep(1000);
						  wait++;
					  }  
				  
				  
			  }
			  
			  if (wait>29) {
				  
				  //System.out.println("Timeout : Syc message does not go away, there is some problem with syncing the points..");
				  
				  throw new TimeoutException("Timeout : Syc message does not go away, there is some problem with syncing the points..");
			  }
			
			
		}
		
				
}
		
