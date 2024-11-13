package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utilities.DBUtils;

public class AddInvoice_And_Verify_DB_StepDef {

    @And("the invoice should be added to the database")
    public void the_invoice_should_be_added_to_the_database() {
        //we will create the query and assign it to String
        String query = "select * from CraterDBS.invoices order by invoice_date desc;";
        //we will execute the query by calling the method DBUtils.selectRecord(String query, String colName)
        //then we save the return name and print it
        String invoiceNumber = DBUtils.selectRecord(query , "invoice_number");
        System.out.println("The new invoice number is " + invoiceNumber );
        //here we verifying the name we got with name start with "INV-"
        Assert.assertTrue(invoiceNumber.startsWith("INV-"));
    }

}
