package com.jci.mems.CucumberPageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.gl.E;

public class SpaceConfigPage extends AbstractPage {
	
	public SpaceConfigPage(WebDriver driver) {
		super(driver);
		
	}

	public SpaceConfigPage selectPortfolio(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='wrapper']/div[3]/ng-view/div[1]/div[2]/div[1]/div[3]/ol/li/div/div/div[2]")));
		driver.findElement(By.xpath("//*[@id='wrapper']/div[3]/ng-view/div[1]/div[2]/div[1]/div[3]/ol/li/div/div/div[2]")).click();
		return new SpaceConfigPage(driver);	
	}

	public SpaceConfigPage addFacility(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addnodeorgtree")));
		driver.findElement(By.id("addnodeorgtree")).click();
		return new SpaceConfigPage(driver);	
	}

	public SpaceConfigPage selectUnitsPopUp(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='SetCommodityDropDown']")));
		driver.findElement(By.cssSelector("button[ng-click*='SetCommodityDropDown']")).click();
		return new SpaceConfigPage(driver);	
	}

	public Select setElectricity(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("consumptionDefault")));
		Select selectelectricity = new Select(driver.findElement(By.name("consumptionDefault")));
		return selectelectricity;	
	}

	public Select setElectricalDemand(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("demandDefault")));
		Select selectelectricaldemand = new Select(driver.findElement(By.name("demandDefault")));
		return selectelectricaldemand;	
	}

	public Select setWater(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("waterDefault")));
		Select selectwater = new Select(driver.findElement(By.name("waterDefault")));
		return selectwater;	
	}

	public Select setHotWater(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("hotWaterDefault")));
		Select selecthotwater = new Select(driver.findElement(By.name("hotWaterDefault")));
		return selecthotwater;	
	}

	public Select setChilledWater(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("chilledWaterDefault")));
		Select selectchilledtwater = new Select(driver.findElement(By.name("chilledWaterDefault")));
		return selectchilledtwater;	
	}

	public Select setGas(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("gasDefault")));
		Select selectgas = new Select(driver.findElement(By.name("gasDefault")));
		return selectgas;	
	}

	public Select setSteam(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("steamDefault")));
		Select selectsteam = new Select(driver.findElement(By.name("steamDefault")));
		return selectsteam;	
	}

	public Select setFuelOil(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fuelOilDefault")));
		Select selectfueloil = new Select(driver.findElement(By.name("fuelOilDefault")));
		return selectfueloil;	
	}

	public Select setPropane(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("propaneDefault")));
		Select selectpropane = new Select(driver.findElement(By.name("propaneDefault")));
		return selectpropane;	
	}

	public Select setDiesel(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("dieselDefault")));
		Select selectdiesel = new Select(driver.findElement(By.name("dieselDefault")));
		return selectdiesel;	
	}
	
	public Select setAreaUnit(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("areaunit")));
		Select selectareaunit = new Select(driver.findElement(By.name("areaunit")));
		return selectareaunit;	
	}
	
	public Select setCurrency(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("currency")));
		Select selectcurrency = new Select(driver.findElement(By.name("currency")));
		return selectcurrency;	
	}
	
	
	public SpaceConfigPage browseFile() throws Throwable{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='wrapper-new']/div[2]/ng-view/div[1]/div[2]/div[4]/div/fieldset/div[2]/div/div/span/span")));
		driver.findElement(By.xpath("//*[@id='wrapper-new']/div[2]/ng-view/div[1]/div[2]/div[4]/div/fieldset/div[2]/div/div/span/span")).click();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("orgExcelUploadedFileName")));
		//driver.findElement(By.id("orgExcelUploadedFileName")).sendKeys("C:\\Users\\cmhaskp\\Mems-BDD\\Selenium-Cucumber\\mems-automation\\TestData\\ExcelUpload_Spaces_Portfolio.xlsx");
			
		return new SpaceConfigPage(driver);	
	}
	
	public SpaceConfigPage uploadFile(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/ng-view/div[1]/div[2]/div[4]/div/fieldset/div[2]/span/button")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/ng-view/div[1]/div[2]/div[4]/div/fieldset/div[2]/span/button")).click();
		return new SpaceConfigPage(driver);	
	}
	
	public List<WebElement> readRateLable(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='unitspopupbody']/div/div/label[2]")));
		List<WebElement> rates = driver.findElements(By.xpath("//*[@id='unitspopupbody']/div/div/label[2]"));
		rates.remove(0);
		return rates;
	}
	
	public List<WebElement> readDefaultUnits(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='unitspopupbody']/div/div/span/select")));
		List<WebElement> defaultUnits = driver.findElements(By.xpath(".//*[@id='unitspopupbody']/div/div/span/select"));
		defaultUnits.remove(0);
		defaultUnits.remove(0);
		return defaultUnits;
	}
	
	public WebElement getCurrency(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='unitspopupbody']/div[1]/div/span[2]/select")));
		WebElement currency = driver.findElement(By.xpath(".//*[@id='unitspopupbody']/div[1]/div/span[2]/select"));
		return currency;
	}
	
	public SpaceConfigPage submitDefaultUnits(){
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='SaveReportingUnits']")));
		driver.findElement(By.cssSelector("button[ng-click*='SaveReportingUnits']")).click();
		return new SpaceConfigPage(driver);	
	}
	
	public List<String> verifyMessages(){
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class*='growl-message']")));
		List<WebElement> MessageElements = driver.findElements(By.cssSelector("div[class*='growl-message']"));
		List<String> successMessages = new ArrayList<>();
		for (WebElement messageElement : MessageElements) {
			successMessages.add(messageElement.getText());
		}
		return successMessages;	
	}
	
	
	public boolean alertMessage(){
		wait = new WebDriverWait(driver,10);
		boolean alterMessage;
		
		try
		{
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
			 alterMessage = driver.findElement(By.cssSelector(".alert-success")).isDisplayed();
		}catch (NoSuchElementException|TimeoutException e)
		{
			//System.out.println(e.getMessage());
			
			alterMessage = false;
		}
		
		return alterMessage;
	}



}
