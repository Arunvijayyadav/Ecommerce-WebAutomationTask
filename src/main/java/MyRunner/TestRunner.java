package MyRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"C:\\Users\\DELL\\Downloads\\CucumberSeleniumFramework-master-1\\CucumberSeleniumFramework-master-1\\src\\main\\java\\Features\\iphone.feature"},
		glue={"stepDefinitions"}, //the path of the step definition files
		//plugin= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		plugin= {"pretty","html:target/HTMLReport",},
		monochrome = true, //display the console output in a proper readable format
		stepNotifications = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file
		//,tags = "@FlightReservation"
		//tags = {"@Smoke" , "@RegressionTest", "@End2End"}			
		)

public class TestRunner {

}

//ORed : tags = {"~@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest


