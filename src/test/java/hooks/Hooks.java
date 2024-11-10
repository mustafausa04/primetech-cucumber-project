package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {
    //Hooks in Cucumber-Java are blocks of code that run before or after each scenario. (Similar to TestNG –
    // Before/After annotations
    //They allow you to set up and tear down the test environment, such as opening and closing browsers,
    //initializing test data, or logging test execution.
    //Hooks can be useful for reducing code duplication and managing the test execution flow.
    //There are several annotations used to define hooks in Cucumber-Java:
    // @Before: This annotation is used to run a block of code before each scenario. It is typically used for
    // setup tasks.
    // @After: This annotation is used to run a block of code after each scenario. It is typically used for
    // cleanup tasks.
    // @BeforeStep: This annotation is used to run a block of code before each step in a scenario. It can be
    // useful for setting up specific conditions before each step.
    // @AfterStep: This annotation is used to run a block of code after each step in a scenario. It can be
    // useful for performing actions after each step, such as ta

    //we can add anything before the scenario using @Before annotation, also we can add (order) next to it to make
    //it run first or second if we decide to split them like below look at the example at the end of the page. we
    //can also add (@smoke) which means before you run the scenario add those steps (maximize, implicitly) with
    //exception only if that scenario has @smoke annotation on it, so basically run those steps(maximize, implicitly)
    //before any scenario has @smoke, if the scenario doesn't have @smoke will still be run but without those steps
    //(maximize, and implicitly)
    //("not @demo") this means do not run those Before steps for anything has demo tag and api tag
    @Before("not @demo and not @api") //("@smoke") //make sure you import this from io.cucumber.java
    public void beforeScenario(){
        System.out.println("This will be printed before each scenario");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //we can add anything after the scenario using @After annotation
    //("not @demo") this means do not run those After steps for anything has demo tag and api tag
    @After("not @demo and not @api")                         //make sure you import this from io.cucumber.java
    public void afterScenario(Scenario scenario) {//make sure you import (Scenario) from io.cucumber.java
        System.out.println("This will be printed after each scenario");

        //this is just to get a screenshot if the scenario is failed
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/png", scenario.getName());
        }
        Driver.closeDriver();//this will end each scenario at the end of that scenario
    }

//    //we can add anything before each step using @BeforeStep annotation
//    @BeforeStep                    //make sure you import this from io.cucumber.java
//    public void beforeStep(){
//        System.out.println("This line will get printed before each step");
//    }
//
//    //we can add anything after each step using @AfterStep annotation
//    @AfterStep("not @demo and not @api")       //make sure you import this from io.cucumber.java
//    public void afterStep() throws InterruptedException {
//        System.out.println("This line will get printed after each step");
//        Thread.sleep(2000);//this will apply for each step
//    }

}

//THis is a note for using order as parameter in the annotation
//@Before(order=1)  //we could change this (order=2) to do negative testing
//public void beforeScenario(){
//    System.out.println("This will be printed before each scenario");
//    Driver.getDriver().manage().window().maximize();
//    Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    System.out.println("This is running as order 1 in before method");
//}
//
//@Before(order=2)  //we could change this (order=1) to do negative testing
//public void beforeScenario2(){
//    System.out.println("This is running as order 2 in before method");
//}


//another note
// We can use tag inside the annotation parameter
//    @Before("@smoke")   //or @regression
//    public void beforeScenario(){
//        System.out.println("We are running before each scenario");
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//    }
