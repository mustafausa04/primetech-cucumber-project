package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

public class Login_StepDef {
    //import all @Given and the rest
    //delete these from each step we don't need it
    //     // Write code here that turns the phrase above into concrete actions
    //        throw new io.cucumber.java.PendingException();

    //we have to declare the driver up here to make it global so we can use it in each method below
    WebDriver driver = Driver.getDriver();

    @Given("User is navigated to saucedemo.com")
    public void user_is_navigated_to_saucedemo_com() {
        //here we write our normal code
        driver.get("https://www.saucedemo.com/");
    }


    @When("User enters {string} in the username field")
    public void user_enters_in_the_username_field(String usernameValue) {//here we change (String string) to (String usernameValue)
        System.out.println("This is the value of username : " + usernameValue);
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys(usernameValue);

    }
    //here make sure to change @When to @And because everything here has to match what we have in the cucumber
    //file (Login_saucedemo.feature)
    @And("User enters {string} in the password field")
    public void user_enters_in_the_password_field(String passValue) {//here we change (String string) to (String passValue)
        System.out.println("This is the value of pass : " + passValue);
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys(passValue);
    }

    //here make sure to change @When to @And because everything here has to match what we have in the cucumber
    //file (Login_saucedemo.feature)
    @And("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        WebElement button  = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

    }
    @Then("User is able to verify the {string} label is displayed")
    public void user_is_able_to_verify_the_label_is_displayed(String expectedProductLabel) {
        WebElement actualElement = driver.findElement(By.xpath("//span[text()='Products']"));//coming from UI
        String actualLabel = actualElement.getText();

        //to check if "Products" is displayed, first we need to import (Assert)
        //using assertTrue() it means anything inside the (...) has to be true if it is true it will pass if it
        //false is not gonna pass
        boolean productLabelIsDisplayed = actualElement.isDisplayed();
        Assert.assertTrue(productLabelIsDisplayed);
        //or simply
        //Assert.assertTrue(actualElement.isDisplayed());

        //Option 1: old way to verify
        //here we will verify the actual result coming from UI to the requirement the test case will pass for
        //both positive and negative which is wrong because for negative it shouldn't pass so if we go to
        //(Login_saucedemo.feature) file and changed the "Products" to "Productssss" it will show you on the console that
        //is "not equal" but on the left side of the console it will show pass and green which is wrong that's
        //why we need to use (Assertion) that is coming from junit library
        //if (expectedProductLabel.equals(actualElement.getText())){
        //    System.out.println("they are equal");
        //}else{
        //    System.out.println("not equal");
        //}

        //Option 2: new way to verify, using (Assertion) from junit library
        //we will use (Assertion) instead of if condition to compare
        Assert.assertEquals(expectedProductLabel , actualLabel );

        //driver.quit();//we can add this to Hooks class and it will close each scenario after it's done


    }


}
