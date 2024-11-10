package api_tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CraterAPIItems {

    //we will make those global so we can use them anywhere we want
    String baseUrl = "http://crater.primetech-apps.com/";//base url
    Response response;//we will make the response global so we can call it anywhere
    String token;//we will make the token global
    int item_id;

    @Test//make sure you use the import from testng option not the junit option
    public void loginToCraterApp(){
        //in this login test we will use these documentation requirements
        //method POST, url "http://crater.primetech-apps.com/"
        //end point "api/v1/auth/login"
        //headers Content-Type", "application/json, "Accept", "application/json", "company", "1"
        //request body "username" "dummy@primetechschool.com", "password" "primetech@school",
        // "device_name", "mobile_app"

        String endpoint ="api/v1/auth/login";//we will get this endpoint from the documentation
        String userEmail ="dummy@primetechschool.com";//we will enter this
        String userPassword = "primetech@school";//we will enter this

        //We will use map to create the headers according to the documentation so we can send them
        //note: if we send those headers the server will complain because data transfer over servers through json
        //or xml format but RestAssured library will take care of that and it will send it as json data format
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");

        //We will use map to create the request body according to the documentation so we can send it
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", userEmail);
        requestBody.put("password", userPassword);
        requestBody.put("device_name", "mobile_app");//this is also in Ac documentation so we added it here

        //this means i will give you the headers and request body when i do the post request return the response
        //back and save it in the response
        response = RestAssured.given()//this should be Response response = RestAssured.given() but we made it global
                .headers(requestHeaders)//sending the headers
                .body(requestBody)//sending the request body
                .when()//optional
                .post(baseUrl+endpoint);//appending the base url to the end point using POST according to AC

        //to get the status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to print the response body
        response.prettyPrint();//or  response.getBody().prettyPrint();

        //to get the token we use path() to get the value of the token and print it, we need the token to save it
        // because later when we do another API test it will ask for the token to be add it to the other requests
        //in the requirement
        token = response.path("token");//the token is a String we put global so we can use anywhere we want
        System.out.println(token);

    }

    //we will make this test case depends on the "loginToCraterApp" because if we don't do it the testNG will go by
    //alphabetical and it will run this one before the above one which will make it fail because the above one has
    //to run first to generate the token for us so we can use it for the next tes case
    @Test(dependsOnMethods = "loginToCraterApp")
    public void create_an_Item(){

        //to get the documentation here go to https://docs.crater.financial/#api-reference , scroll down to (items)
        //then (create an item)
        //we added the faker dependency to pom.xml to generate fake names and other to us
        Faker faker = new Faker();//create object for Faker class to access its methods
        String endpoint ="api/v1/items";
        String itemName = faker.commerce().productName();
        String itemDescription = faker.commerce().material();
        int itemPrice = new Random().nextInt(100-10)+100;

        //we will print what we are creating and the token too
        System.out.println("The body of the request: " + itemName + " || " + itemDescription + " || " + itemPrice);
        System.out.println("Here is the token -->" + token);

        //We will use map to create the headers according to the documentation so we can send them
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        //We will use map to create the request body according to the documentation so we can send it
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", itemName);
        requestBody.put("price", itemPrice);
        requestBody.put("description", itemDescription);

        //this means i will give you the headers and request body when i do the post request return the response
        //back and save it in the response
        response = RestAssured.given()
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .post(baseUrl+endpoint);

        //to get the status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to print the response body
        response.prettyPrint();//or  response.getBody().prettyPrint();

        //to get the id for the item that we created, we will declare it on top to make it global so we can use it
        //in the next test case when we do update on the item using PUT request
        item_id = response.path("data.id");//here we will get the id
        System.out.println("The item id that was created is --> "+ item_id);//here we will print the id
    }


    //we will make this test case depends on the "create_an_Item" because with the PUT (update) we need an id and in
    //order to get an id we need to create an item
    @Test(dependsOnMethods = "create_an_Item")
    public void update_an_Item(){

        Faker faker = new Faker();
        String endpoint = "api/v1/items/" + item_id;//this is coming from the requirements to attach the id
        System.out.println("Entire endpoint is " + baseUrl + endpoint);//we will print it to see it

        String itemName = faker.commerce().productName();//this is required from AC
        String itemDescription = faker.commerce().material();
        int itemPrice = new Random().nextInt(100-10)+100; //this is required from AC
        System.out.println("The Description will be updated to : " + itemDescription);

        //We will use map to create the headers according to the documentation so we can send them
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        //We will use map to create the request body according to the documentation so we can send it
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", itemName);
        requestBody.put("price", itemPrice);
        requestBody.put("description", itemDescription);

        //this means i will give you the headers and request body when i do the post request return the response
        //back and save it in the response
        response = RestAssured.given()
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .put(baseUrl + endpoint);

        //to get the status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());
    }

}
