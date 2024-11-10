package api_tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExampleDemo {

    @Test
    public void javaFakerExample(){
        //we got the faker dependency in the pom.xml and all what we need here is to create an object of Faker class
        //to access to the rest of method
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());//to get a fake first name
        System.out.println(faker.name().lastName());//to get a fake last name
        System.out.println(faker.cat().name());//to get a fake cat name
        System.out.println(faker.address().cityName());//to get a fake city name
    }

}
