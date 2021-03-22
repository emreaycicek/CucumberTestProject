package steps;

import pages.*;
import base.BaseTest;
import collections.LoginPageCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CartSteps extends BaseTest {

    private BaseTest base;

    public CartSteps(BaseTest base) {
        this.base = base;
    }

    @When("^Log into the system$")
    public void logIntoTheSystem() {
        base.navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(base.driver).signInPage();
        new LoginPage(base.driver).signInCredentials(LoginPageCollection.email, LoginPageCollection.password);
        new LoginPage(base.driver).signInButton();
    }

    @And("^Go to dresses category$")
    public void goToDressesCategory() {
        new HomePage(base.driver).goDressesCategory();

    }

    @And("^Go to summer dresses category$")
    public void goToSummerDressesCategory() {
        new DressesCategoryPage(base.driver).goSummerDressesCategory();

    }

    String dressName;
    String dressPrice;
    @And("^Add second product in the basket\\.Product name and product price are noted$$")
    public void addSecondProductInTheBasketProductPriceAndProductNameInformationIsNoted() {
        new SummerDressesCategoryPage(base.driver).addChartSecondProduct();
        dressName = new SummerDressesCategoryPage(base.driver).ProductName();
        dressPrice = new SummerDressesCategoryPage(base.driver).ProductPrice();
    }

    @And("^Go to t-shirt category$")
    public void goToTShirtCategory() {
        new SummerDressesCategoryPage(base.driver).goTShirtCategory();

    }

    String tShirtName;
    String tShirtPrice;
    @And("^Add any product in the basket\\.Product name and product price are noted$")
    public void addAnyProductInTheBasketProductPriceAndProductNameInformationIsNoted() {
        new TShirtsPage(base.driver).addChartProduct();
        tShirtName = new TShirtsPage(base.driver).ProductName();
        tShirtPrice = new TShirtsPage(base.driver).ProductPrice();
    }

    @And("^Go to cart page$")
    public void goToCartPage() {
        new TShirtsPage(base.driver).goChartPage();
    }

    @Then("^Assert dress and shirt names$")
    public void assertDressAndShirtNames() {

        String dressNameOnCartPage = new CartPage(base.driver).dressName();
        String tShirtNameOnCartPage = new CartPage(base.driver).tShirtName();

        Assert.assertEquals(dressName, dressNameOnCartPage);
        Assert.assertEquals(tShirtName, tShirtNameOnCartPage);
    }

    @And("^Assert dress and shirt prices$")
    public void assertDressAndShirtPrices() {

        String dressPriceOnCartPage = new CartPage(base.driver).dressPrice();
        String tShirtPriceOnCartPage = new CartPage(base.driver).tShirtPrice();

        Assert.assertEquals(dressPrice, dressPriceOnCartPage);
        Assert.assertEquals(tShirtPrice, tShirtPriceOnCartPage);

    }

    @And("^Assert total price$")
    public void assertTotalPrice() {
        String calculateTotalProduct = new CartPage(base.driver).calculateTotalProduct();
        String totalProduct = new CartPage(base.driver).totalProduct();

        Assert.assertEquals(calculateTotalProduct, totalProduct);

    }

}
