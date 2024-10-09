package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class CreateFacebookAccount_Datatable_StepDef {

    @Given("I open Facebook URL and Create accounts with below information")
    public void i_open_facebook_url_and_create_accounts_with_below_information(DataTable dataTable) {

        //here we can do (dataTable.) and choose asMaps() then hover over it to see the return type is
        //List<Map<String, String>>
        //this is a list contains map inside of it
        List<Map<String, String>> fbUsers =  dataTable.asMaps();

        System.out.println("List of users is " +fbUsers);

        //for each map of string print
        for(Map<String, String> user : fbUsers){
            System.out.println("First Name -->" + user.get("First Name"));
            System.out.println("Last Name -->" + user.get("Last Name"));
            System.out.println("Email Address -->" + user.get("Email Address"));
            System.out.println("Password -->" + user.get("Password"));
            System.out.println("Phone Number -->" + user.get("Phone Number"));
            System.out.println("DOB -->" + user.get("DOB"));
            System.out.println("---------------------------------------");
        }

    }

}
