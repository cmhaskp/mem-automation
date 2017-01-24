package com.jci.mems.mems_automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadEnvData {
	
	public static Properties readEnvData(){
		
		File file = new File("C://Users/cmhaskp/Mems-BDD/Selenium-Cucumber/mems-automation/TestData/Envdata.properties");
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Reading the URL" + prop);
		return prop;
	}

}
