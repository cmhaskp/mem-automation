package com.jci.mems.TestVerification;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
format = {"pretty", "json:target/cucumber.json"}, 
features = {"src/test/resource"},
tags = {"@Logintest" })

public class RunCucumberTest {

	
}
