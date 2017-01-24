package com.jci.mems.CucumberPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jci.mems.TestVerification.DatasourceConfigTest;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;


public class DataMappingPage extends AbstractPage{
	
	//WebElement sourceElement = null;
	
	List<WebElement> getUnitsElements;
	DatasourceConfigTest datasourceconfigtest;

	public DataMappingPage(WebDriver driver) {
		super(driver);
	}
	
	public DataMappingPage switchToiFrame(){
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iFrame);
		
		return new DataMappingPage(driver);	
	}
	
	public DataMappingPage selectDataMappingTab() {
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='#MeterConfiguration']")));
		driver.findElement(By.cssSelector("a[href='#MeterConfiguration']")).click();	
		return new DataMappingPage(driver);	
	}

	public DataMappingPage selectUnitsButton() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='ShowUnitPopup']")));
		driver.findElement(By.cssSelector("button[ng-click*='ShowUnitPopup']")).click();	
		return new DataMappingPage(driver);
	}
	
	public List<WebElement> getUnitsDataMappingPage() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='UnitFilter']/div/div/div[3]/label/span")));
		
		List<WebElement> totalUnits = driver.findElements(By.xpath("//div[@id='UnitFilter']/div/div/div[3]/label/span"));
			
		return totalUnits;
		}
	
	public DataMappingPage selectDiscoverButton() throws InterruptedException {
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click*='UpdateDiscoverPointsStatus']")));
		driver.findElement(By.cssSelector("button[ng-click*='UpdateDiscoverPointsStatus']")).click();	
		return new DataMappingPage(driver);
	}
	
	public WebElement waitForLoader() throws InterruptedException {
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".imageloader")));
		WebElement loader = driver.findElement(By.cssSelector(".imageloader"));	
		return loader;
	}
	
	public List<WebElement> checkPointsTree() throws InterruptedException {
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tree']/ol/li/ol/li/ol/li/ol/li/ol/li/ol/li/div/div/span[3]")));
		List<WebElement> pointsTree = driver.findElements(By.xpath(".//*[@id='tree']/ol/li/ol/li/ol/li/ol/li/ol/li/ol/li/div/div/span[3]"));	
		return pointsTree;
	}

	public WebElement getdestElement() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='mappedPointData']/tbody")));
		WebElement destElement = driver.findElement(By.xpath(".//*[@id='mappedPointData']/tbody"));
		return destElement;
	}
	
	public WebElement getsourceElement() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tree']/ol/li/ol/li/ol/li/ol/li/ol/li/ol/li/div/div/span[3]")));
		WebElement sourceElement = driver.findElement(By.xpath(".//*[@id='tree']/ol/li/ol/li/ol/li/ol/li/ol/li/ol/li/div/div/span[3]"));
		return sourceElement;
	}
	
	public List<WebElement> getPointUnits() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='mappedPointData']/tbody/tr/td[5]")));
		List<WebElement> getUnitsElements = driver.findElements(By.xpath(".//*[@id='mappedPointData']/tbody/tr/td[5]"));
		return getUnitsElements;
		
	}
	
	public DataMappingPage clickEntityTemplate() throws InterruptedException {		
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-id*='ddlEntityTemplate']")));
			driver.findElement(By.cssSelector("button[data-id*='ddlEntityTemplate']")).click();
			return new DataMappingPage(driver);
			
		}

	public WebElement enterEntityTemplate() throws InterruptedException {		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='DatasourceModal']/div/div/div[2]/form/div[6]/div[1]/div/div/div/input")));
		WebElement EntityTemplateElement =driver.findElement(By.xpath("//*[@id='DatasourceModal']/div/div/div[2]/form/div[6]/div[1]/div/div/div/input"));
		return EntityTemplateElement;
		
	}
	

	public String verifySyncMessage() throws InterruptedException {		
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='page-content-wrapper']/div/div/div[1]/div[2]/div[2]/div[2]/div")));
			String syncMessage =driver.findElement(By.xpath(".//*[@id='page-content-wrapper']/div/div/div[1]/div[2]/div[2]/div[2]/div")).getText();
			return syncMessage;
			
		}

	
	public void setEntityTemplate() throws Throwable {
		
		    List<WebElement> getUnits = getPointUnits();
		    datasourceconfigtest = new DatasourceConfigTest();
		    WebElement unit = null;
			//List<String> unitsOfPoints = new ArrayList<>();
			
		    if(getUnits != null && getUnits.size()!=0 ){
		    	
		    	 for (int i=1;i<=getUnits.size();i++) {
		    		 
		    		 try {
						
						unit = driver.findElement(By.xpath(".//*[@id='mappedPointData']/tbody/tr["+i+"]/td[5]"));
						
						unit.click();
						 
						String unitType = getUnitType();
						
						clickEntityTemplate();
						 
						 if (unitType.equals("Energy")){
							 
							 enterEntityTemplate().sendKeys("Instantaneous Consumption");
							 enterEntityTemplate().sendKeys(Keys.ENTER);
							 
						 } else if(unitType.equals("Power")){
							 
							 enterEntityTemplate().sendKeys("Instantaneous Demand");
							 enterEntityTemplate().sendKeys(Keys.ENTER);
						 
						 } else if(unitType.equals("Volume")){
							 
							 enterEntityTemplate().sendKeys("Volumetric Consumption");
							 enterEntityTemplate().sendKeys(Keys.ENTER);
						 } else {
							 
							 throw new NullPointerException("Unit type us not set for the point");
						 }
						
						 clickOnUpdateButton();
						 
						 datasourceconfigtest.verify_that_datasource_added_successfully_message_displayed("Point updated successfully");
					} catch (StaleElementReferenceException e) {
						System.out.println("Element with " + unit + " is not attached to the page document "
								+ e.getStackTrace());
					} catch (NoSuchElementException e) {
						System.out.println("Element " + unit + " was not found in DOM "+ e.getStackTrace());
					} catch (Exception e) {
						System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
					} 
						
						
					}
		    }
		    	 
	}
		   
			
		
	public String getUnitType() throws InterruptedException {
			
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlUnitType")));
			String unitTypeText = new Select(driver.findElement(By.id("ddlUnitType"))).getFirstSelectedOption().getText();
			return unitTypeText;
		}

	public DataMappingPage clickOnUpdateButton() throws InterruptedException {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click *= 'SaveValue']")));
		driver.findElement(By.cssSelector("button[ng-click *= 'SaveValue']")).click();
		return new DataMappingPage(driver);
	}

	public DataMappingPage clickOnSyncButton() throws Throwable {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click *= 'UpdateSyncDataSourceStatus']")));
		driver.findElement(By.cssSelector("button[ng-click *= 'UpdateSyncDataSourceStatus']")).click();
		datasourceconfigtest.verify_that_datasource_added_successfully_message_displayed("Sync status updated");
		return new DataMappingPage(driver);
	}

	public void dragAndDrop(List<WebElement> sourceElements, WebElement destElement) throws InterruptedException {
		
		System.out.println("Performing Drag and Drop ...");
		WebElement sourceElement = null;
		Actions builder = new Actions(driver);
		
		if (sourceElements != null && sourceElements.size() != 0 ){
			
			for (int i=0;i<sourceElements.size();i++){
					
			try{
				
				sourceElement = getsourceElement();	
				//System.out.println("source Element " + sourceElement);
				if (sourceElement.isDisplayed() && destElement.isDisplayed()) { 
			        builder.clickAndHold(sourceElement);
			        builder.moveToElement(destElement);
			        builder.perform();
			        Thread.sleep(1000);
			        builder.release(destElement);
			        builder.perform();
			        Thread.sleep(2000);
			    } else {
			        
			        throw new NoSuchElementException();
			     }
				} catch (StaleElementReferenceException e) {
					System.out.println("Element with " + sourceElement + "or" + destElement + " is not attached to the page document "
							+ e.getStackTrace());
				} catch (NoSuchElementException e) {
					System.out.println("Element " + sourceElement + " or " + destElement + " was not found in DOM "+ e.getStackTrace());
				} catch (Exception e) {
					System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
				} 	
			}
		} else {
			
			throw new NullPointerException("Points not returned in the source elements");
		}
	}
}
