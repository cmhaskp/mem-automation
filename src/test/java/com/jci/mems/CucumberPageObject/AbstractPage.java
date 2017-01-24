package com.jci.mems.CucumberPageObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.TestVerification.Hooks;

public class AbstractPage {

	public WebDriver driver;
	public String url;
	WebDriverWait  wait;
	JSONParser parser;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
		url = Hooks.envURL;
	}
	public LoginPage navigateToWebApp() throws InterruptedException{
		driver.navigate().to(url);
		return new LoginPage(driver);
	}

	
}
