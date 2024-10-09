package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Calculator_Outline_StepDef {

    @Given("I have entered {int} in the calculator and I have entered {int} in the calculator")
    public void i_have_entered_in_the_calculator_and_i_have_entered_in_the_calculator(Integer int1, Integer int2) {
        System.out.println("I have entered  "+ int1 +" and "+ int2 +" into the calculator");
    }
    @When("I press add")
    public void i_press_add() {
        System.out.println("I press add");
    }
    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(Integer sum) {
        System.out.println("The result should be  " + sum + "  on the screen");
    }



//    @Given("I have entered {int} in the calculator")
//    public void i_have_entered_in_the_calculator(Integer int1) {
//        System.out.println("I have entered  "+ int1 +" into the calculator");
//    }
//    @When("I press add")
//    public void i_press_add() {
//        System.out.println("I press add");
//    }
//    @Then("the result should be {int} on the screen")
//    public void the_result_should_be_on_the_screen(Integer sum) {
//        System.out.println("The result should be  " + sum + "  on the screen");
//    }

}
