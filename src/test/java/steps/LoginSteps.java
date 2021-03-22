package steps;

import pages.HomePage;
import pages.LoginPage;
import base.BaseTest;
import collections.LoginPageCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends BaseTest {

    private BaseTest base;

    public LoginSteps(BaseTest base) {
        this.base = base;
    }

    @Given("^Navigate to the login page$")
    public void navigateToTheLoginPage() {
        base.navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(base.driver).signInPage();
    }

    @When("^Fill in email and password$")
    public void fillInEmailAndPassword() {
        new LoginPage(base.driver).signInCredentials(LoginPageCollection.email,LoginPageCollection.password);

    }

    @And("^Press login button$")
    public void pressLoginButton() {
        new LoginPage(base.driver).signInButton();

    }

    @Then("^Have to check the page address$")
    public void haveToCheckThePageAddress() {
        new HomePage(base.driver).assertPageAddress();

    }
}
