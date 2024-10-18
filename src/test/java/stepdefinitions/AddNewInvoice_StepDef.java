package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InvoicesPage;

public class AddNewInvoice_StepDef {

    InvoicesPage invoicesPage = new InvoicesPage();
    //we will declare the firstInvoice here so we can call it in the bottom
    String firstInvoice;

    @When("the user clicks on the Add New Invoice button")
    public void the_user_clicks_on_the_add_new_invoice_button() throws InterruptedException {
        //this will get us the text for the first invoice for exp INV-00040, using split() will get us the part[1]
        //which is 00040 because part[0] will be INV
        //Thread.sleep(6000);
        firstInvoice = invoicesPage.firstInvoice.getText().split("-")[1];
        System.out.println(firstInvoice);
        Thread.sleep(3000);
        invoicesPage.addNewInvoiceButton.click();
    }

    @And("the user selects a client from the New Customer dropdown")
    public void the_user_selects_a_client_from_the_new_customer_dropdown() throws InterruptedException {
        //here we will click on new customer box
        invoicesPage.selectNewCustomer.click();
        //then we will type "Garfield"
        invoicesPage.customerInputField.sendKeys("Garfield");
        //then we will select "Garfield" when it pops up
        invoicesPage.firstCustomerInList.click();
        Thread.sleep(6000);
    }

    @When("the user select the first item")
    public void the_user_select_the_first_item() {
        //we will click on the dropdown
        invoicesPage.selectNewItemDropdown.click();
        //then we will click on the first item there
        invoicesPage.firstItemInList.click();
    }

    @And("the user add exchange rate {string}")
    public void the_user_add_exchange_rate(String rateInput) {
        //we need to clear the rate box because already a number there
        invoicesPage.exchangeRateInput.clear();
        //then we add what we want
        invoicesPage.exchangeRateInput.sendKeys(rateInput);
    }

    @And("the user enters the price {string}")
    public void the_user_enters_the_price(String priceInput) {
        invoicesPage.priceInput.sendKeys(priceInput);
    }

    @And("the user clicks on the Save Invoice button")
    public void the_user_clicks_on_the_save_invoice_button() throws InterruptedException {
        invoicesPage.saveInvoiceButton.click();
        Thread.sleep(2000);
    }

    @Then("the invoice should be saved and listed in the invoices list")
    public void the_invoice_should_be_saved_and_listed_in_the_invoices_list() {
        //this is tricky so grab the initial invoice number before creating new invoice , save it into variable after
        //creating the new invoice we get the new invoice number and verify that the number is equal to old number +1
        int firstInvoiceNumber = Integer.parseInt(firstInvoice);//to convert the string to int

        String newInvoiceNumber = invoicesPage.newInvoiceNumber.getText().split("-")[1]; //INV-00041
        int newInvoiceNumberInt = Integer.parseInt(newInvoiceNumber);//to convert the string to int

        //verify that the new invoice number is equal to old invoice number +1
        Assert.assertTrue(newInvoiceNumberInt > firstInvoiceNumber);
    }

//    @And("the invoice total should match the items and their quantities")
//    public void the_invoice_total_should_match_the_items_and_their_quantities() {
//    }

}
