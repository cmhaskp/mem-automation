package com.jci.mems.CucumberPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeterConfigPage extends AbstractPage {

	public MeterConfigPage(WebDriver driver) {
		super(driver);
	}

	public MeterConfigPage selectUnitsButton() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("unitsbutton")));
		//Thread.sleep(1000);
		driver.findElement(By.id("unitsbutton")).click();	
		return new MeterConfigPage(driver);
		
	}
public List<WebElement> getUnitsMeterConfigPage() throws InterruptedException {
		
	wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkboxcontainer']/div/label")));
	
	
	
	List<WebElement> totalUnits = driver.findElements(By.xpath("//div[@class='checkboxcontainer']/div/label"));
		
	return totalUnits;
	}
}
