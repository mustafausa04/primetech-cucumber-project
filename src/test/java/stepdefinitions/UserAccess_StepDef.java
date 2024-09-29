package stepdefinitions;

import io.cucumber.java.en.*;//we could use this for all of the below
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SettingsPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.And;

public class UserAccess_StepDef {
    //1. get rid of these code in every step
    //    // Write code here that turns the phrase above into concrete actions
    //    throw new io.cucumber.java.PendingException();
    //2. compare all the steps here with the steps in (User_Access.feature) to make sure they are the same

    //since we have the (Driver) class then we can declare and assign the driver like below, but if we didn't
    //have the (Driver) class we could declare the driver on top then we can assign to anything we want in the
    //rest of steps like what we did in (Login_StepDef) class

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();


    //this is the first scenario1
    //for some reason if you run this at the first time it will not work so you need to login manually to the
    //crater app then come back and run it by automation:
    //user name: entityadmin@primetechschool.com , password: primetech@school
    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() {
        driver.manage().window().maximize();
        driver.get("http://crater.primetech-apps.com/login");
        //add implicit wait after loading the web page if we don't add the implicit wait we will hav an error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() throws InterruptedException {
        //these steps are not working so we will try the javascriptexecutor
        //loginPage.emailInput.sendKeys("entityadmin@primetechschool.com");
        //loginPage.passwordInput.sendKeys("primetech@school");

        //using JavaScriptExecutor also not working
        //SeleniumUtils.sendKeysUsingJavaScriptExecutor("entityadmin@primetechschool.com", loginPage.emailInput);
        //Thread.sleep(2000);
        //SeleniumUtils.sendKeysUsingJavaScriptExecutor("primetech@school", loginPage.passwordInput);
        //Thread.sleep(2000);

        //using Action class
        SeleniumUtils.sendkeysWithActionsClass(loginPage.emailInput ,"entityadmin@primetechschool.com");
        Thread.sleep(2000);
        SeleniumUtils.sendkeysWithActionsClass(loginPage.passwordInput,"primetech@school");
        Thread.sleep(2000);
    }

    //here you need to replace @When with @And, it's cucumber error not us
    @And("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginPage.loginButton.click();
        Thread.sleep(3000);//you have to put the waiting time here otherwise it won't see the button
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws InterruptedException {
        //verify using url that is different from login url
        String loginUrl = "http://crater.primetech-apps.com/login";
        String afterLoginUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login in is : " + afterLoginUrl);

        //we will use Assert to compare between the 2 urls if they area not equals it means true nothing will
        //show on console
        Assert.assertNotEquals(loginUrl , afterLoginUrl);
        Thread.sleep(2000);
        //here we rae verifying if the (Settings) text is display if yes it means true
        Assert.assertTrue(settingsPage.settingsLabel.isDisplayed());
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    //this is the second scenario2
    //here we will get only 3 steps because cucumber doesn't generate any duplicate steps and since we have
    //same or duplicate steps in scenario1 then they will not be generated in scenario2
    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() throws InterruptedException {
        SeleniumUtils.sendkeysWithActionsClass(loginPage.emailInput ,"xxxxxx@primetechschool.com");
        Thread.sleep(2000);
        SeleniumUtils.sendkeysWithActionsClass(loginPage.passwordInput,"primetech@school");
        Thread.sleep(2000);
    }

    @Then("user should see an error message {string} displayed")
    public void user_should_see_an_error_message_displayed(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.loginErrorMessageLabel.getText();
        //verify that the error message  displayed is equal to the expected error message
        Assert.assertTrue(expectedErrorMessage.equals(actualErrorMessage));
    }

    //change the @Then to @And
    @And("user should not be logged in")
    public void user_should_not_be_logged_in() {
        String loginUrl = "http://crater.primetech-apps.com/login";
        //verify that login url didn't changes , meaning we are still in the same page and we couldn't login
        Assert.assertTrue(driver.getCurrentUrl().equals(loginUrl));
        Driver.closeDriver();
    }


}
