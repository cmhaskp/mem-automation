package com.jci.mems.mems_automation;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
	
	static JSONParser parser;
	static JSONObject json;
	//static String file = "C://Users/cmhaskp/Mems-BDD/Selenium-Cucumber/mems-automation/TestData/userProfile.json";
	
	public static JSONObject readJsonFile(String filename) throws IOException, ParseException{
		String file = "C://Users/cmhaskp/Mems-BDD/Selenium-Cucumber/mems-automation/TestData/"+ filename +".json";
		 parser = new JSONParser();
		 System.out.println("Reading JSON file from Java program" + file);
        //FileReader fileReader = new FileReader(file);
        Object obj = (JSONObject) parser.parse(new FileReader(file));
        JSONObject json = (JSONObject) obj;
//        String username = (String) json.get("username");
//        System.out.println("USername " + username);
		return json;

	 }

}
