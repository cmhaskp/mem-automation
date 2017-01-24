package com.jci.mems.CucumberPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.TestVerification.Hooks;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public LoginPage setUserName(String value){
	
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(value);
		return new LoginPage(driver);
	}
	public LoginPage setPassword(String value){
		wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys(value);
		return new LoginPage(driver);
	}
	
	public OverviewDashboardPage submitForm(){
		wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login-button")));
		driver.findElement(By.cssSelector(".login-button")).click();
		return new OverviewDashboardPage(driver);
	}
	
	public static int main(String args[] )
	{
		System.out.println("In main");
		return 0;
	}
	
}
