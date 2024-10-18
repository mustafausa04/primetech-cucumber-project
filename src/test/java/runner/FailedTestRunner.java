package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//This class will allow us to execute and run the failed files in the "@target/failed_scenarios.txt"
@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "@target/failed_scenarios.txt", //this path where to find failed scenarios to run them
                 glue = "stepdefinitions",
                 plugin = {"pretty" , "html:target/primetech-report.html",
                 "json:target/primetech-report.json"}
)

public class FailedTestRunner {
}
