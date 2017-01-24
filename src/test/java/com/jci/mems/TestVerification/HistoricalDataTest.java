package com.jci.mems.TestVerification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jci.mems.CucumberPageObject.DataMappingPage;
import com.jci.mems.CucumberPageObject.DatasourceConfigPage;
import com.jci.mems.CucumberPageObject.HistoricalDataPage;

import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HistoricalDataTest {
	
	HistoricalDataPage historicaldatapage;
	DataMappingPage datamappingpage;
	WebDriver driver;
	String url;
	
	public HistoricalDataTest(){
		
		driver = Hooks.driver; 
		url = Hooks.envURL;
	}
	
	@Given("^User navigates to \"(.*?)\" screen$")
	public void user_navigates_to_screen(String page) throws Throwable {
		datamappingpage = new DataMappingPage(driver);
		historicaldatapage = new HistoricalDataPage(driver);
		SapceConfigTest spaceconfigpage = new SapceConfigTest();
		System.out.println("Navigating to Setting page..");
		driver.navigate().to(url + "Configuration/#/datasource");
		datamappingpage.switchToiFrame();
		spaceconfigpage.user_waits_to_load_completely("Setup-Datasource page");	
		switch(page){
	    case "Data Mapping" :
	    	datamappingpage.selectDataMappingTab();
	       break; 
	    case "Historical data" :
	    	historicaldatapage.selectHistoricalDataTab();
	       break; 
		}   
	}

	@When("^User selects the points for historian data request$")
	public void user_selects_the_points_for_historian_data_request() throws Throwable {
	 
		historicaldatapage.selectPointsForHistorian();
	}

	@When("^User selects From date and To date as below$")
	public void user_selects_From_date_and_To_date(DataTable dateRange) throws Throwable {
		List<Map<String,String>> data = dateRange.asMaps(String.class, String.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");   
		
		//Date fromDate = new Date();
		//Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		
		WebElement fromDateElement = historicaldatapage.setStartDate();
		WebElement toDateElement = historicaldatapage.setToDate();
		
		for (Map map : data) {
			
			//Date fDate = (Date) map.get("From date");
			
			Date fDate = sdf.parse(map.get("From date").toString());
			String fromDate =sdf.format(fDate);
			
			//Date tDate = (Date) map.get("To date");
			Date tDate = sdf.parse(map.get("To date").toString());
			String toDate =sdf.format(tDate);
			
			System.out.println("From date " + fDate + "To date " + tDate);
							  
			fromDateElement.sendKeys(fromDate);
			fromDateElement.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			toDateElement.sendKeys(toDate);
			Thread.sleep(1000);
			toDateElement.sendKeys(Keys.TAB);
		}
	}

	@When("^User submits the historian request$")
	public void user_submits_the_historian_request() throws Throwable {
		
		historicaldatapage.submitHistorianRequest();
	    
	}

	
}
