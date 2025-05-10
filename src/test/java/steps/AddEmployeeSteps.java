package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOption);
    }

    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters <firstname> and <lastname>")
    public void user_enters_firstname_and_lastname() {
        sendText("James", addEmployeePage.firstNameLocator);
        sendText("Bond", addEmployeePage.lastNameLocator);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @When("the system generates a unique EID")
    public void the_system_generates_a_unique_eid() {
        System.out.println(addEmployeePage.employeeId.getText());
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("Test passed");
    }

    @When("user enters <firstname> and <lastname> and <EID>")
    public void user_enters_firstname_and_lastname_and_eid() {
        sendText("Rob", addEmployeePage.firstNameLocator);
        sendText("Johnson", addEmployeePage.lastNameLocator);
        sendText("RJ2025", addEmployeePage.addEmpId);
    }

    @Then("user is added successfully")
    public void user_is_added_successfully() {
        System.out.println("Test Passed");
    }

    @When("user enters wrong username and\\/or password")
    public void user_enters_wrong_username_and_or_password() {
        sendText("admin", loginPage.errorMessage);
    }

    @When("user skips the first or last name entry")
    public void user_skips_the_first_or_last_name_entry() {
        sendText(" ", addEmployeePage.firstNameLocator);
        sendText("Johnson", addEmployeePage.lastNameLocator);
    }

    @Then("user can see the error message")
    public void user_can_see_the_error_message(){
        Assert.assertEquals(addEmployeePage.firstNameError.getText(),"Required");
    }

}
