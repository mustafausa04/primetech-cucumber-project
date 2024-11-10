package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CraterAPIInvoices {
    //this is another API ex so first thing you need to do is to go look at the documentation or AC in the website
    //   https://docs.crater.financial/invoices then lets choose (list all invoices), you will see it is a GET
    //method and in the headers you will see (Authorization: Bearer {token}) so we need to get the token first and
    //the only way is use the log in in  order to get that token so we can save it and keep using it anywhere we want

    //we will make those global so we can use them anywhere we want
    String baseUrl = "http://crater.primetech-apps.com/";//base url
    Response response;//we will make the response global so we can call it anywhere
    String token;//we will make the token global
    List<Integer> invoiceIds = new ArrayList<>();//declaring a list of integers

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


    @Test(dependsOnMethods = "loginToCraterApp")
    public void get_all_Invoices(){
        //in this test case we will go to the (all invoices) in the documentation and from there we execute
        //we get the end point from the documentation we put it in a String so we can append it to the base url
        String endpoint = "api/v1/invoices";

        //We will use map to create the headers according to the documentation so we can send them
        //note: if we send those headers the server will complain because data transfer over servers through json
        //or xml format but RestAssured library will take care of that and it will send it as json data format
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        //this means i will give you the headers and request body when i do the post request return the response
        //back and save it in the response
        response = RestAssured.given()//this should be Response response = RestAssured.given() but we made it global
                .headers(requestHeaders)//sending the headers
                .when()
                .get(baseUrl+endpoint);//appending the base url to the end point using POST according to AC

        //to get the status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to print the response body
        response.prettyPrint();//or  response.getBody().prettyPrint();

        //here we will get the list of ids so it suppose to be like this
        //List<Integer> invoiceIds = response.jsonPath().getList("data.id");
        //but since we will gonna use the list in the next test case then we will declare it on top
        invoiceIds = response.jsonPath().getList("data.id");
        System.out.println(invoiceIds);
    }


    @Test(dependsOnMethods = "get_all_Invoices")
    public void get_specific_Invoice(){
        //here we will do (retrieve an invoice) look at the documentation
        //User makes a request GET to api/v1/invoices/
        //Then a list of all the invoices should be returned
        //Verify that Status code should be 200
        //Verify content-type --> Application/json
        //Verify that a list of Ids are returned

        //here we will get the end point with id according to the documentation and we will say get me the first
        //id in that list which is index 0
        String endpoint = "api/v1/invoices/" + invoiceIds.get(0);

        //here we will print the full url including the first id in the list
        System.out.println("Full endpoint is " + baseUrl + endpoint);

        //We will use map to create the headers according to the documentation so we can send them
        //note: if we send those headers the server will complain because data transfer over servers through json
        //or xml format but RestAssured library will take care of that and it will send it as json data format
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        //this means i will give you the headers and request body when i do the post request return the response
        //back and save it in the response
        response = RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseUrl + endpoint);

        //to get the status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to print the response body
        response.prettyPrint();//or  response.getBody().prettyPrint();
    }

//----------------------DELETE ex but it is not gonna work because it is been blocked by the school 
// We need access to perform a delete operation (admin user )
//    @Test(dependsOnMethods = "get_specific_Invoice")
//    public void delete_specific_Invoice(){
//        String endpoint = "api/v1/invoices/" +invoiceIds.get(0);
//        System.out.println("Full endpoint is " + baseUrl+endpoint);
//
//        Map<String, Object> requestHeaders = new HashMap<>();
//        requestHeaders.put("Content-Type", "application/json");
//        requestHeaders.put("Accept", "application/json");
//        requestHeaders.put("Authorization", "Bearer " + token);
//
//
//        response = RestAssured.given()
//                .headers(requestHeaders)
//                .when()
//                .delete(baseUrl+endpoint);
//
//        response.then().statusCode(200);
//
//        response.prettyPrint();
//    }


}
