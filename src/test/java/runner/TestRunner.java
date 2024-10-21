package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//here we need to tell junit to run the TestRunner class as a cucumber test so we do the below
@RunWith(Cucumber.class)

//here we need to tell the TestRunner, this is the path for the features files to run them.
//(to get the path, right click on Login_saucedemo.feature, copy path/reference, path from content root, so the path will
//be    src/test/resources/features/Login_saucedemo.feature   this will execute the (Login_saucedemo.feature) file only but if we
//need the TestRunner to execute all the files there we just erase the (Login_saucedemo.feature) file and keep the rest
//of the path like this   src/test/resources/features/  to execute all the files there )
//now the second part is where the step definitions are which is in (stepdefinitions) folder so we put it in
//(glue) part without need to get its path because cucumber will complains, so basically what we just did is we
//linked up the (features) files or cucumber files to (stepdefinitions) files which is java files so we can
//execute them and run them.
//now let's run it, on the console left side click on the first scenario (User can login using valid username
//and password) located under (Login feature), we will copy the steps starting from annotation (@Given) all the
//way to the end but make sure that is for that scenario only because on the console left side you will see
//(Login feature) and 2 scenarios under it, so if you click on the (Login feature) you will get the full steps
// on the right side of the console but if you click on any scenario under the (Login feature) you will get the
// steps only for that specific scenario on the right side of the console.
//go to (Login_StepDef) file and paste it there
@CucumberOptions(features = "src/test/resources/features/Add-New_Invoices.feature",
        glue = {"stepdefinitions", "hooks"}, //we will add the package names of (hooks) and (stepdefinitions)
        plugin = {"pretty" ,"html:target/primetech-report.html", //this is to generate a report for us since it
                            "json:target/primetech-report.json", //has 4 values then we need to put them in { }
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //this is to generate report also
        "rerun:target/failed_scenarios.txt"},//this will capture any failed test case and put it in target folder
        //tags = "@saucedemo"
        //tags = "(@smoke) and (not @ignore)"//run all smoke test except the one @ignore
        //tags = "(@smoke) and (not @saucedemo)"//run all smoke test except the one in @saucedemo
        //tags = "@smoke or @regression"//this will execute all the scenarios with @smoke or @regression.
        //tags = "@smoke and @regression"//this will execute only the scenarios with these 2 tags.
        //tags = "@smoke"//this will run only the scenario with the @smoke tag after scanning all features files
        tags = "@crater"//this will run "User_Access.feature" only not the other files like (Login_saucedemo.feature)
        //dryRun = true //if you run this it will show you any step in the features files that is not working
                        //so we will create an exact copy of this file but we will activate the dryRun there
                        //so we can run it anytime we want to see steps that are not executing and we will keep
                        //this copy for regular performance.
        //monochrome = true //is to make the the console output pretty
)


//This class will allow us to execute and run our feature files/step definitions.
//run this class it will pass and generate a report for you so go to the left menu click on (target) folder
//then double click on (primetech-report.html) it will open a file on the right side go there you see browsers
//icons, choose chrome you will see the report. if you click on (primetech-report.json) you will get the report
//in json format which is key and value.
public class TestRunner {

}
