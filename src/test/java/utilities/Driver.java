package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    //The (singleton pattern) in software engineering is a design pattern that
    //restricts the instantiation of a class to one object only. which means we create a driver and we force to use it
    //by it self not any other driver that's it's called (singleton pattern)
    //What if we keep instantiating new driver for every test ?
    //When you run a suite of tests, it creates multiple browser windows which can cause:
    //1.Increased overhead (resource usage).
    //2.Risk of one test interfering with another due to shared resources or race conditions.a.This type of issue can
    //occur especially when you want to run test in parallel in the future
    //3.Tests failing due to session timeouts or browser performance issues.
    //basically we will instantiate one driver for all sessions or all test cases in this case we don't have to create
    //a driver for each session or each test case imagine if we have 1000 test case and we do regression then we will
    //have all these drivers run at the same time and it will be conflict between them

    //we made the driver static because we will call it inside static method in class SauceDemoLogin and we just
    //declared it here we haven't assigned it
    private static WebDriver driver;

    //here we will make the driver private so no one can create a driver in the class (SauceDemoLogin) in this case we
    //force everyone to use the method getDriver() below
    private Driver(){
    }

    //Static method to get the single instance of WebDriver
    //here we creating a utility method to get the driver, so we will say if the driver is null, which is the driver is
    //null at the beginning because there is no driver at the beginning, then create a driver which
    //is ChromeDriver and start the session and then return it to use it (we have to return it because we put the return
    //type (WebDriver) before the name of the method (getDriver), if we put (void) then we don't need to return anything
    public static WebDriver getDriver(){
        System.out.println("Getting an instance of the driver");
        if(driver == null){//here we assigned the driver
            driver = new ChromeDriver(); //Instantiate only once
        }
        return driver;// this is an existing one that is not null ( driver this is alive)
    }

    /**
     * This method will quit the driver and set it to null
     */
    public static void closeDriver() {
        //We Check if the driver still alive then quit the driver and set the driver object to null to make sure it is
        //died
        System.out.println("Closing the driver");
        if (driver != null) {
            driver.quit();
            driver = null;//this is extra step to make sure the driver is not exist
        }
    }


}
