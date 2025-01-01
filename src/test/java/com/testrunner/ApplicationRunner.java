package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/com/features"},
		glue= {"com/stepdefinitions","com/hooks"},
		plugin= {"pretty"},
		monochrome=true
		
		)

public class ApplicationRunner extends AbstractTestNGCucumberTests{

	
}
