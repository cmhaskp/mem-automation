package com.jci.mems.CucumberPageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.TestVerification.SapceConfigTest;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import java.util.Date;

public class HistoricalDataPage extends AbstractPage {
	
	public HistoricalDataPage(WebDriver driver) {
		super(driver);
	}
	
	HistoricalDataPage historicaldatapage;
	DataMappingPage datamappingpage;
	
	public HistoricalDataPage selectHistoricalDataTab() {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='#HistoricalData']")));
		driver.findElement(By.cssSelector("a[href='#HistoricalData']")).click();	
		return new HistoricalDataPage(driver);	
	}
	
	public HistoricalDataPage selectPointsForHistorian() {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='historical-data-points']/thead/tr/th[1]/span[2]/input")));
		driver.findElement(By.xpath(".//*[@id='historical-data-points']/thead/tr/th[1]/span[2]/input")).click();	
		return new HistoricalDataPage(driver);	
	}
	
	public WebElement setStartDate() throws ParseException {
		
		//SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		
		//Date formattedFromDate = in.parse(fromDate);
		//calculator = new DateCalculator(date);
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("date-picker-1")));
		WebElement fromDate = driver.findElement(By.id("date-picker-1"));
		return fromDate;	
	}
	
	public WebElement setToDate() {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("date-picker-2")));
		WebElement toDate = driver.findElement(By.id("date-picker-2"));	
		return toDate;	
	}
	
	public HistoricalDataPage submitHistorianRequest() {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click *= 'RequestHistoricalData']")));
		driver.findElement(By.cssSelector("button[ng-click *= 'RequestHistoricalData']")).click();	
		return new HistoricalDataPage(driver);	
	}
	
}
