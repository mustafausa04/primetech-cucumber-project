package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.InvoicesPage;
import utilities.Driver;

public class ViewInvoices_StepDef {
    //after we run (DryTestRunner) to get the steps and paste them here we see that the first step in the
    //(View_Invoices.feature) which is (Given user is logged in successfully) is not generated by the dryrunner
    //because it is already exist from before in the (AddItem_StepDef), then next make sure all the steps here are
    //matching with steps in the gherkin language in (View_Invoices.feature), make sure to change all @And @THen...
    //to match them with the (View_Invoices.feature), then run the (DryTestRunner) again it should show you all
    //green if there is any red then it must be a step that didn't implemented in the right way.

    WebDriver driver = Driver.getDriver();
    DashboardPage dashboardPage = new DashboardPage();
    InvoicesPage invoicesPage = new InvoicesPage();

    @And("the user is on the invoices page")
    public void the_user_is_on_the_invoices_page() throws InterruptedException {
        //user gets into the invoices page by clicking on the invoice hyperlink from left tab
        Thread.sleep(2000);
        dashboardPage.invoicesTab.click();

    }

    @Then("the Invoices label should be displayed")
    public void the_invoices_label_should_be_displayed() throws InterruptedException {
        //to check if the (Invoices) text is displayed
        Thread.sleep(1000);
        Assert.assertTrue(invoicesPage.invoicesLabel.isDisplayed());
    }

    @And("the user clicks on a specific invoice")
    public void the_user_clicks_on_a_specific_invoice() {
        //to click on the first element on the right screen under (number)
        invoicesPage.firstInvoice.click();
    }

    @Then("the invoice details should be displayed on the right side of the screen")
    public void the_invoice_details_should_be_displayed_on_the_right_side_of_the_screen() throws InterruptedException {
        Thread.sleep(3000);
        //to check if the
        Assert.assertTrue(invoicesPage.invoiceDetailsLabel.isDisplayed());
    }

}
