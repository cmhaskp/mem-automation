package com.jci.mems.TestVerification;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.jci.mems.CucumberPageObject.AbstractPage;
import com.jci.mems.CucumberPageObject.LoginPage;
import com.jci.mems.CucumberPageObject.OverviewDashboardPage;
import com.jci.mems.mems_automation.ReadJson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class LoginTest{
		
	WebDriver driver; 
	
	LoginPage loginpage;
	OverviewDashboardPage overviewdashboardpage;
	AbstractPage abstractpage;
	JSONParser parser;
	JSONObject json; 
	String file = "C://Users/cmhaskp/Mems-BDD/Selenium-Cucumber/mems-automation/TestData/userProfile.json";
	
	public LoginTest() {
		driver = Hooks.driver; 	
	}
	
//	 public static void readJson(String file) throws IOException, ParseException{
//		 parser = new JSONParser();
//		 System.out.println("Reading JSON file from Java program");
//         FileReader fileReader = new FileReader(file);
//         json = (JSONObject) parser.parse(fileReader);
//
//	 }
//	
	
	@Given("^User enters mems url into the browser$")
	public void user_logged_in_to_on() throws Throwable {
		loginpage = new LoginPage(driver);
		loginpage.navigateToWebApp();
	}
	
	@When("^User enters LoginUserName as in the \"(.*?)\"\\.json file$")
	public void user_enters_as(String filename) throws Throwable {
		json = ReadJson.readJsonFile(filename);
		System.out.println("Username is "+ (String) json.get("username"));
		loginpage.setUserName((String) json.get("username"));
	}

	@When("^User enters LoginPassword$")
	public void user_enter_as() throws Throwable {
		System.out.println("Password: "+ (String) json.get("password"));
		loginpage.setPassword((String) json.get("password"));
	    //throw new PendingException();
	}

	@Then("^User click on the login button$")
	public void user_click_on_the_button() throws Throwable {
		overviewdashboardpage =loginpage.submitForm();
	    //throw new PendingException();
	}

	@SuppressWarnings("deprecation")
	@Then("^verify that Overview dashboard screen should be displayed$")
	public void logged_in_username_should_be() throws Throwable {
	   Thread.sleep(5000);
	   String getTitle = overviewdashboardpage.getTitle();
	   System.out.println("We are on the" + getTitle + " page");
	   Assert.assertTrue(overviewdashboardpage.getTitle().equalsIgnoreCase("Overview-Dashboard"));
	    //throw new PendingException();
	}
	
}
