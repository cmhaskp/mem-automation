package com.jci.mems.CucumberPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewDashboardPage extends AbstractPage {

	public OverviewDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle(){
		
		//return driver.findElement(By.cssSelector(".m_heading titletext")).getText();
		wait = new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='wrapper']/header/h2[2]")));
		return driver.findElement(By.xpath("//*[@id='wrapper']/header/h2[2]")).getText();
	}
	

}
