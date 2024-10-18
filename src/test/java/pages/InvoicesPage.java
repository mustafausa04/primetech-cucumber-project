package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InvoicesPage {

    //creating Constructor for the page to initialize the elements
    public InvoicesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************
    //to find the text (Invoices)
    @FindBy(xpath = "//h3[text()='Invoices']") //or you can use this //h3[.='Invoices']
    public WebElement invoicesLabel;

    //to find the first element on the right screen for ex the first one under (number) also this is tricky xpath
    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices/')])[2]")
    public WebElement firstInvoice;

    //to find the text (INV-000026) on top the other new screen, this is also tricky xpath so either we leave it
    //as of //h3 or we could use contains so it will be always read the element even if the INV_000026 changed to
    //a different number when they keep adding new elements.
    @FindBy(xpath = "//h3")
    public WebElement invoiceDetailsLabel;

    //to find the new invoices button
    @FindBy(xpath = "//button[text()=' New Invoice']")
    public WebElement addNewInvoiceButton;

    //to find new customer
    @FindBy(xpath = "//label[text()='New Customer ']")
    public WebElement selectNewCustomer;

    //to find the customer input field
    @FindBy(xpath = "//input[@icon='search']")
    public WebElement customerInputField;

    //to find the first element "Garfield"
    @FindBy(xpath = "//ul[@class='max-h-80 flex flex-col overflow-auto list border-t border-gray-200']/li")
    public WebElement firstCustomerInList;

    //to find the items input box, also the xpath tricky so we go to the parent which is (table) then to its child
    @FindBy(xpath = "//table[@class='w-full']//input[@type='text']")
    public WebElement selectNewItemDropdown;

    @FindBy(xpath = "//ul[@class='flex flex-col p-0 m-0 list-none']/li[1]")
    public WebElement firstItemInList;

    //to find the exchange rate input box, it is tricky xpath so we will use the parent to get to its child
    @FindBy(xpath = "//div[@class='flex relative rounded-md shadow-sm font-base']//input")
    public WebElement exchangeRateInput;

    //to find the quantity input box
    @FindBy(xpath = "//table[@class='w-full']//input[@type='number']")
    public WebElement quantityInput;

    //to find the price input box
    @FindBy(xpath = "//table[@class='w-full']//input[@type='tel']")
    public WebElement priceInput;

    //to find the save invoice button
    @FindBy(xpath = "//button[text()=' Save Invoice']")
    public WebElement saveInvoiceButton;

    //to find the invoice number text after we save it
    @FindBy(xpath = "//h3[starts-with(text(),'INV')]")
    public WebElement newInvoiceNumber;

}
