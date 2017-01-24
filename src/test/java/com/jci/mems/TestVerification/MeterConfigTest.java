package com.jci.mems.TestVerification;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.CucumberPageObject.DataMappingPage;
import com.jci.mems.CucumberPageObject.MeterConfigPage;
import com.jci.mems.mems_automation.ReadJson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MeterConfigTest {
	WebDriver driver;
	String url;
	MeterConfigPage meterconfigpage;
	DataMappingPage datamappingpage;
	WebDriverWait wait;
	String currentWindowHandle;
	JSONObject json; 
	List<WebElement> allUnits;
	
	public MeterConfigTest(){
		
		driver = Hooks.driver; 
		url = Hooks.envURL;
	}
	
	@Given("^User navigates to Meter configuration screen$")
	public void user_navigates_to_Meter_configuration_screen() throws Throwable {
	
		driver.navigate().to(url + "Configuration/#/meters");
		driver.manage().window().maximize();
		
	}
	
	@Given("User waits to load \"(.*?)\" page completely$")
	public void verify_that_Meter_configuration_page_loaded() throws Throwable {
	  int wait = 0;
	  
	  for (int count=0;count<20;count++){
		  
			  if (!driver.findElement(By.id("imgloaderMeter")).isDisplayed()) {
				  
				  System.out.println("page loaded completely");
				  
				  break;
				  
			  }  else {
				  
				  System.out.println("Waiting for the page to load " + count);
				  wait++;
			  }  
		  
		  
	  }
	  
	  if (wait>19) {
		  
		  System.out.println("Timeout : Meter configuration page not loaded");
	  }
		  
	  
	}

	@When("^User clicks on the Units push button$")
	public void user_clicks_on_the_Units_push_button() throws Throwable {
		meterconfigpage = new MeterConfigPage(driver);	
		currentWindowHandle = driver.getWindowHandle();
		meterconfigpage.selectUnitsButton();
	
			   
	}

	@SuppressWarnings("unchecked")
	@Then("^Verify that units displayed on \"(.*?)\" screen are matching with the units from the \"(.*?)\"\\.json file$")
	public void verify_that_units_displayed_on_the_units_pop_up_are_matching_with_the_units_from_the_file(String page,String filename) throws Throwable {
	
		System.out.println("Filename" + filename );
		
		json = ReadJson.readJsonFile(filename);
		
		JSONArray expunits = (JSONArray) json.get("units");
		
		expunits.toArray();
		
		Collections.sort(expunits);
				
		ArrayList <String> actunits = new ArrayList<String>();
		
		ArrayList <String> missingunits = new ArrayList<String>();
		
		switch(page){
		
			case "Meter configuration" :
				
				allUnits = meterconfigpage.getUnitsMeterConfigPage();
				
				break; 
				
			case "Data Mapping" :
				datamappingpage = new DataMappingPage(driver);
				allUnits = datamappingpage.getUnitsDataMappingPage();
				
				break;
				
		}				
		
			try {
				if (!allUnits.isEmpty()){
					for (WebElement unit: allUnits){
					
						actunits.add(unit.getText());
					
					}
				}
				
				Collections.sort(actunits);
			
				
				if (!actunits.isEmpty()){
					for(String unit:actunits ){	
						if (!expunits.contains(unit)) {
							missingunits.add(unit);
							}
						
						}
					
					Assert.assertTrue("Unit "+ Arrays.asList(missingunits) + " not found in the expected unit list", missingunits.isEmpty());
					
					}  
				}
			catch (Exception e) {
		         System.out.println("Exception occoured : " + e);
		      }
				
				
			} 					
	}
	
	

