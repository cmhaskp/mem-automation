package com.jci.mems.TestVerification;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.jci.mems.mems_automation.ReadEnvData;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks<CucumberResultsOverview> {

	public static WebDriver driver;
	public static String envURL;
	Properties prop;
	@Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        String browser = System.getProperty("browser");
        System.out.println("browser name  from jenkins is " +browser);
        
        /*
        if(browser==null)
        {
           
           browser = System.getenv("browser");
           System.out.println("browser name  from  is " +browser);
            if(browser==null)
            {
                browser= "chrome";
            }
        }
        */
        
        prop = ReadEnvData.readEnvData();
        switch (browser.toLowerCase())
        {
            case "chrome":
            	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
            	driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
            	System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));
                driver = new InternetExplorerDriver();
                break;
            case "safari":
            	driver = new SafariDriver();
            default:
                driver = new SafariDriver();
                break;
        }
           System.out.println("Opening Browser...."+browser);
           driver.manage().deleteAllCookies();
    }
	
	@Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void testEnvironment() throws MalformedURLException {
        String environment = System.getProperty("env");
        if(environment==null)
        {
        	environment = System.getenv("env");
            if(environment==null)
            {
            	environment= "UAT";
            }
        }
        prop = ReadEnvData.readEnvData();
        switch (environment)
        {
            case "UAT":
               	envURL = prop.getProperty("UAT");          	
                break;
            case "SIT":
            	envURL = prop.getProperty("SIT");
                break;
            case "DEV":
            	envURL = prop.getProperty("DEV");
                break;
            default:
            	envURL = prop.getProperty("DEV");
                break;
        }
           System.out.println("Test environment...."+environment);
    }
   @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
        try {
            scenario.write("Current Page URL is " + driver.getCurrentUrl());
            //byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        }
        driver.close();
    }  
}
