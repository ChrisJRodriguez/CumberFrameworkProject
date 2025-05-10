package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access the HRMS application")
    public void user_is_able_to_access_the_hrms_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid login username and password")
    public void user_enters_valid_login_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("Test passed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        sendText("losdifj", loginPage.usernameField);
        sendText("lijdf", loginPage.passwordField);
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String errorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,"Invalid credentials");
        System.out.println("error is shown");

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

}
