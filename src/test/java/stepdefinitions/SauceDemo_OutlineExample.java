package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class SauceDemo_OutlineExample {
    //if for any reason the @Given, @When, @Then is not working or we can import them just go to (Maven) button on
    //the very right and click the icon Reload it will refresh them

    WebDriver driver = Driver.getDriver();

    @Given("user on login page")
    public void user_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    //change the (String string) to (String username) and the other one to (String password)
    @When("user enters  {string} and enters {string}")
    public void user_enters_and_enters(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();
        Thread.sleep(2000);
    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        System.out.println("user not able to login");
    }

}
