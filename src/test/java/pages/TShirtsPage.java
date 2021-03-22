package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TShirtsPage {

    private WebDriver driver;

    By productImage = By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img");
    By productAddToChart = By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");
    By tShirtProductName = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
    By tShirtProductPrice= By.cssSelector("#center_column > ul > li > div > div.left-block > div > div.content_price > span");

    By continueShoppingButton = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span");
    By chartButton = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");

    public TShirtsPage(WebDriver driver){
        this.driver = driver;
    }

    public void addChartProduct(){
        WebElement tShirtProductImageElement = driver.findElement(productImage);
        Actions actions = new Actions(driver);
        actions.moveToElement(tShirtProductImageElement).perform();
        driver.findElement(productAddToChart).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();

    }

    public String ProductName(){
        String tShirtProductNameStr = driver.findElement(tShirtProductName).getText();

        return tShirtProductNameStr;
    }

    public String ProductPrice(){
        WebElement productImageElement = driver.findElement(productImage);
        Actions actions = new Actions(driver);
        actions.moveToElement(productImageElement).perform();

        String tShirtProductPriceStr = driver.findElement(tShirtProductPrice).getText();
        double tShirtPriceDbl = Double.parseDouble(tShirtProductPriceStr.substring(1));
        String strDouble = String.format("%.2f", tShirtPriceDbl).replace(",",".");

        return strDouble;
    }
    public void goChartPage(){
        driver.findElement(chartButton).click();

    }

}
