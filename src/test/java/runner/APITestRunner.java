package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "src/test/resources/features/api_features",//we will execute the files inside the api_features
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty" , "html:target/primetech-report.html",
                "json:target/primetech-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"},

        tags= "@api"//you need to add (,) if you uncomment the dryRun below
        //dryRun = true//we will run this to generate the steps in the console se we can copy them
)


public class APITestRunner {

}
// This class will allow us to execute and run our feature files/step definitions