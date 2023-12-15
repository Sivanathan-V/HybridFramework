package com.qa.steps.ui;

import com.qa.engine.DriverManager;
import com.qa.engine.ProjectBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.qa.pages.ui.LoginPage;

public class LoginStep extends ProjectBase {

    @Given("User is on the Cyclos LoginPage")
    public void userIsOnTheCyclosLoginPage() {
        new DriverManager().launchBrowser();
        getDriver().get("https://demo.cyclos.org/ui/home");
    }

    @When("User should login {string} and {string}")
    public void userShouldLoginAnd(String username, String password) {
        new LoginPage().userName(username).passWord(password).login();
    }

    @Then("User should verify after Login success message {string}")
    public void userShouldVerifyAfterLoginSuccessMessage(String value) {
        Assert.assertEquals(new LoginPage().getDetails(), value);
    }

}
