package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utilities.DBUtils;

public class AddItem_And_Verify_DB_StepDef {

    @And("the item is added into the DB")
    public void the_item_is_added_into_the_db() {
        //we will create the query and assign it to String
        String query = "select * from CraterDBS.items order by created_at desc;";
        //we will execute the query by calling the method DBUtils.selectRecord(String query, String colName)
        //then we save the return name and print it
        String name = DBUtils.selectRecord(query,"name");
        System.out.println("THe new item name is : " + name);
        //here we verifying the column name "name" is not empty
        Assert.assertTrue(!name.isEmpty());
    }

}
