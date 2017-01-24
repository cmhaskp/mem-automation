package com.jci.mems.TestVerification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jci.mems.CucumberPageObject.AbstractPage;
import com.jci.mems.CucumberPageObject.LoginPage;
import com.jci.mems.CucumberPageObject.OverviewDashboardPage;
import com.jci.mems.CucumberPageObject.SpaceConfigPage;
import com.jci.mems.mems_automation.ReadJson;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SapceConfigTest {
	
	static WebDriver driver; 
	static String url;
	SpaceConfigPage spaceconfigpage = new SpaceConfigPage(driver);
	LoginPage loginpage;
	OverviewDashboardPage overviewdashboardpage;
	AbstractPage abstractpage;
	JSONParser parser;
	JSONObject json;
	String parentWindow;
	private Map<String, String> commodityUnits;
	
	public SapceConfigTest() {
		driver = Hooks.driver; 	
		url = Hooks.envURL;
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Given("^User logged in to Mems application with credentials from the \"(.*?)\"\\.json file$")
	public void user_logged_in_to_on(String filename) throws Throwable {
		loginpage = new LoginPage(driver);
		loginpage.navigateToWebApp();
		json = ReadJson.readJsonFile(filename);
		loginpage.setUserName((String) json.get("username"));
		loginpage.setPassword((String) json.get("password"));
		overviewdashboardpage =loginpage.submitForm();
		String getTitle = overviewdashboardpage.getTitle();
		System.out.println("We are on the" + getTitle + "page");
		Assert.assertTrue(overviewdashboardpage.getTitle().equalsIgnoreCase("Overview-Dashboard"));
		//Assert.assertTrue(overviewdashboardpage.getTitle().equalsIgnoreCase("Overview-Dashboard"), "We are not on the overview dashboard page");
	}
	
	
	@Given("^User maximize the browser window$")
	public void user_maximize_the_browser_window() throws Throwable {
		System.out.println("Maximizing the browser window..");
		driver.manage().window().maximize();
	}
	
	@Given("^User deletes browser cookies$")
	public void user_delets_browser_cookies() throws Throwable {
		System.out.println("Deleting the browser cookies..");
		driver.manage().deleteAllCookies();
	}
	
	@Given("^User navigates to Space configuration screen$")
	public void user_navigates_to_Space_configuration_screen() throws Throwable {
	  
		driver.navigate().to(url + "/Configuration/#/spaces");
		
	}

	@When("^User selects portfolio and adds a facility$")
	public void user_selects_portfolio_and_adds_a_facility() throws Throwable {
		spaceconfigpage = new SpaceConfigPage(driver);
		
		//Selecting the portfolio from the Space tree
		spaceconfigpage.selectPortfolio();

		//Clicking on '+' button on the Space tree
		spaceconfigpage.addFacility();
	}

	@Then("^Verify that facility is added at the end of tree$")
	public void verify_that_facility_is_added_at_the_end_of_tree() throws Throwable {
	  System.out.println("Facility is added in the space tree");
	}

	@When("^User saves the facility to entity api$")
	public void user_saves_the_facility_to_entity_api() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@When("^User selects a facility and adds a building$")
	public void user_selects_a_facility_and_adds_a_building() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^User saves the building to entity api$")
	public void user_saves_the_building_to_entity_api() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Verify that building is added below the facility$")
	public void verify_that_building_is_added_below_the_facility() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
	}

	@Given("^User waits to load \"(.*?)\" completely$")
	public void user_waits_to_load_completely(String page) throws Throwable {
	 
		int wait = 0;
		  
		  for (int count=0;count<60;count++){
			  
				  if (!driver.findElement(By.cssSelector(".imageloader")).isDisplayed()) {
					  
					  System.out.println("page" + page + "loaded completely");
					  
					  break;
					  
				  }  else {
					  System.out.println("Waiting for the page to load " + count);
					  Thread.sleep(500);
					  wait++;
				  }  
			  
			  
		  }
		  
		  if (wait>59) {
			  
			  System.out.println("Timeout : " + page + "page not loaded");
		  }
			  
	    
	}

	@When("^User selects a Select Units button$")
	public void user_selects_a_Select_Units_button() throws Throwable {
		spaceconfigpage = new SpaceConfigPage(driver);
	  	spaceconfigpage.selectUnitsPopUp();
		
	}

	@When("^User sets the Default units to all the commodities as in the table below :$")
	public void user_sets_the_Default_units_to_all_the_commodities_as_in_the_table_below(DataTable commodityTable) throws Throwable {
		
		 List<Map<String, String>> data = commodityTable.asMaps(String.class, String.class);
	for (Map map : data) {
		  
		Select setelectricity = spaceconfigpage.setElectricity();
		setelectricity.selectByVisibleText(map.get("Electricity").toString());
		
		Select setElectricalDemand = spaceconfigpage.setElectricalDemand();
		setElectricalDemand.selectByVisibleText(map.get("ElectricalDemand").toString());
		
		Select setWater = spaceconfigpage.setWater();
		setWater.selectByVisibleText(map.get("Water").toString());
		
		Select setHotWater = spaceconfigpage.setHotWater();
		setHotWater.selectByVisibleText(map.get("HotWater").toString());
		
		Select setChilledWater = spaceconfigpage.setChilledWater();
		setChilledWater.selectByVisibleText(map.get("HotWater").toString());
		
		Select setGas = spaceconfigpage.setGas();
		setGas.selectByVisibleText(map.get("Gas").toString());
		
		Select setSteam = spaceconfigpage.setSteam();
		setSteam.selectByVisibleText(map.get("Steam").toString());
		
		Select setFuelOil = spaceconfigpage.setFuelOil();
		setFuelOil.selectByVisibleText(map.get("FuelOil").toString());
		
		Select setPropane = spaceconfigpage.setPropane();
		setPropane.selectByVisibleText(map.get("Propane").toString());
		
		Select setDiesel = spaceconfigpage.setDiesel();
		setDiesel.selectByVisibleText(map.get("Diesel").toString());
		
		Select setAreaUnit = spaceconfigpage.setAreaUnit();
		setAreaUnit.selectByVisibleText(map.get("AreaUnit").toString());
		
		Select setCurrency = spaceconfigpage.setCurrency();
		setCurrency.selectByVisibleText(map.get("Currency").toString());
		  
		  }
		//selectelectricity.selectByVisibleText(arg0);
	}

	@SuppressWarnings("null")
	@Then("^Verify that label for text box displayed correctly$")
	public void verify_that_label_for_text_box_displayed_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> RateTextElements = spaceconfigpage.readRateLable();
		List<String> expectedRateText = new ArrayList<String>();
		for (WebElement RateTextElement : RateTextElements) {
			//String value = .toString();
			expectedRateText.add(RateTextElement.getText().toString());
			
		}
		
		System.out.println("Lable " + expectedRateText);
		
		List<WebElement> ReadDefaultUnits = spaceconfigpage.readDefaultUnits();
		WebElement currency = spaceconfigpage.getCurrency();
		List <String> actualRateLableText = new ArrayList<String>();
		for (WebElement defaultUnit : ReadDefaultUnits) {
			
			actualRateLableText.add(new Select(currency).getFirstSelectedOption().getText().toString() + " Per " + new Select(defaultUnit).getFirstSelectedOption().getText().toString());
		}
		
		System.out.println("Lable " + actualRateLableText);
		
		 if(expectedRateText != null && actualRateLableText != null && (actualRateLableText.size() == expectedRateText.size())){
			 for (String actualRateText : actualRateLableText) {
				
				 Assert.assertTrue("The Rate text " + actualRateText.toString() + " does not found in expected rate text list", expectedRateText.contains(actualRateText.toString()));
			}
			 //Assert.assertTrue("Rate text is not matching", actualRateLableText.equals(expectedRateText));
		 } else
		 {
			 System.out.println("actualRateLableText List and expectedRateText are not equal");
		 }
		
		
	}
	
	@When("^User browses the excel sheet$")
	public void user_browses_the_excel_sheet() throws Throwable {
	   spaceconfigpage = new SpaceConfigPage(driver);
	   spaceconfigpage.browseFile();
	   Runtime.getRuntime().exec("C:\\Users\\cmhaskp\\Mems-BDD\\Selenium-Cucumber\\mems-automation\\TestData\\Space.exe");
	   Thread.sleep(1000);
	}

	@When("^User uploads the excel sheet$")
	public void user_uploads_the_excel_sheet() throws Throwable {
	  	spaceconfigpage.uploadFile();
	}

	@Then("^Verify that space hierarchy created successfully$")
	public void verify_that_space_hierarchy_created_succussfully() throws Throwable {
	   //spaceconfigpage = new SpaceConfigPage(driver);
	    
	   boolean alertMessage =spaceconfigpage.alertMessage();
	   
	  // Assert.assertTrue(alertMessage, "Space was not uploaded successfully" );
	   Assert.assertTrue("Space was not uploaded successfully", alertMessage);
	}

	@Then("^User submits the Default units$")
	public void user_submits_the_Default_units() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		spaceconfigpage.submitDefaultUnits();
	    
	}

	@Then("^Verify that saved successfully message displayed as in \"(.*?)\"\\.json file$")
	public void user_saves_the_submitted_Default_units(String filename) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		json = ReadJson.readJsonFile(filename);
		List<String> verifyMessage = spaceconfigpage.verifyMessages();
		
		String submitUnits = (String)json.get("submitdefaultunits");
		String submitEmmission = (String)json.get("submitdefaultunits");
		System.out.println("Messages " + verifyMessage);
		
		if (verifyMessage != null && verifyMessage.size()>0 ) {
		
		Assert.assertTrue("Message " + submitUnits + "not displayed", verifyMessage.contains(submitUnits));
		
		Assert.assertTrue("Message " + submitEmmission + "not displayed", verifyMessage.contains(submitEmmission));
	   } else {
		   
		   throw new NullPointerException();
	   }
	}
	
	

}
