package com.jci.mems.CucumberPageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatasourceConfigPage extends AbstractPage {

	public DatasourceConfigPage(WebDriver driver) {
		super(driver);
		
	}
	
	public DatasourceConfigPage selectDataSourceTab() {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='#Datasources']")));
		driver.findElement(By.cssSelector("a[href='#Datasources']")).click();	
		return new DatasourceConfigPage(driver);	
	}

	public Select selectDatasource(){
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ddlDataSourceType")));
		Select dataSourceType = new Select(driver.findElement(By.name("ddlDataSourceType")));
		return dataSourceType;	
	}

	public Select selectTimezone(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlTimeZone")));
		Select selectTimezone = new Select(driver.findElement(By.id("ddlTimeZone")));
		return selectTimezone;	
	}

	public WebElement getDatasourceName(){
		WebElement dataSourceName = null;
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[ng-model='DataSourceName']")));
		
		if((driver.findElement(By.xpath("//*[@id='divMetasyscol1']/form/div[1]/div[2]/input"))).isDisplayed()){
			
			dataSourceName = driver.findElement(By.xpath("//*[@id='divMetasyscol1']/form/div[1]/div[2]/input"));
			
		} else if((driver.findElement(By.xpath("//*[@id='divModbusCol1']/form/div[1]/div[2]/input"))).isDisplayed()) {
			
			dataSourceName = driver.findElement(By.xpath("//*[@id='divModbusCol1']/form/div[1]/div[2]/input"));
			
		} else {
			
			dataSourceName = driver.findElement(By.xpath("//*[@id='divBacnet2']/form/div[1]/div[2]/input"));
		}
		return dataSourceName;
	}
	
	public WebElement getServerIP(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtServerIp")));
		WebElement serverIp = driver.findElement(By.name("txtServerIp"));
		return serverIp;
	}
	
	public WebElement getDatabasePath(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtDatabasePath")));
		WebElement databasePath = driver.findElement(By.name("txtDatabasePath"));
		return databasePath;
	}
	
	public WebElement getUser(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[ng-model='UName']")));
		WebElement user = driver.findElement(By.cssSelector("input[ng-model='UName']"));
		return user;
	}
	
	public WebElement getPassword(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[ng-model='Psw']")));
		WebElement password = driver.findElement(By.cssSelector("input[ng-model='Psw']"));
		return password;
	}
	
	public WebElement getIpAddress(){
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtModbusIp")));
		WebElement IpAddress = driver.findElement(By.name("txtModbusIp"));
		return IpAddress;
	}
	
	public WebElement getPort(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtModbusPort")));
		WebElement port = driver.findElement(By.name("txtModbusPort"));
		return port;
	}
	
	
	
	public DatasourceConfigPage enableDriver(){
		wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[ng-model='IsDriverEnable']")));
		
		if((driver.findElement(By.id("cbDriverEnable"))).isDisplayed()){
			
			 driver.findElement(By.id("cbDriverEnable")).click();
			
		} else if((driver.findElement(By.xpath("//*[@id='divModbusCol2']/form/div[2]/div[2]/input"))).isDisplayed()) {
			
			 driver.findElement(By.xpath("//*[@id='divModbusCol2']/form/div[2]/div[2]/input")).click();
			
		} else {
			
			driver.findElement(By.xpath("//*[@id='divBacnet2']/form/div/div[2]/input/following::input")).click();
		}
		
		
		return new DatasourceConfigPage(driver);
	}
	
	
	public DatasourceConfigPage addDatasource(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='AddDataSource']")));
		driver.findElement(By.cssSelector("button[ng-click*='AddDataSource']")).click();
		return new DatasourceConfigPage(driver);
	}
	
	public DatasourceConfigPage selectDatasourcefromGrid(String dataSourceName){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='accordion']/div/div/div/table/tbody/tr/td[contains(text(),'" + dataSourceName + "')]")));
		driver.findElement(By.xpath(".//*[@id='accordion']/div/div/div/table/tbody/tr/td[contains(text(),'" + dataSourceName + "')]")).click();
		return new DatasourceConfigPage(driver);
	}
	
	
	public String switchToWindow(){
		String parentWindowHandle = driver.getWindowHandle(); 
		String subWindowHandle = null;

		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandle = iterator.next();
		}
		driver.switchTo().window(subWindowHandle); 
		
		return parentWindowHandle;
		//driver.switchTo().window(parentWindowHandle); 
	}
	
	public String getPopUpMessage(){
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popup_message")));
		String popupMessage = driver.findElement(By.id("popup_message")).getText();
		System.out.println("popup message :" + popupMessage);
	return popupMessage;
	}
	
	public DatasourceConfigPage closePopUp(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popup_ok")));
		driver.findElement(By.id("popup_ok")).click();
		return new DatasourceConfigPage(driver);
	}
	
	public DatasourceConfigPage testConnection(){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='TestConnection']")));
		driver.findElement(By.cssSelector("button[ng-click*='TestConnection']")).click();
		return new DatasourceConfigPage(driver);		
	}
	
	public String checkDatasourceStatus(String dataSourceName){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='accordion']/div/div/div/table/tbody/tr/td[contains(text(),'" + dataSourceName + "')]/following::td[6]")));
		String datasoureStatus = driver.findElement(By.xpath(".//*[@id='accordion']/div/div/div/table/tbody/tr/td[contains(text(),'" + dataSourceName + "')]/following::td[6]")).getText();
		return datasoureStatus;	
	}
	
}
