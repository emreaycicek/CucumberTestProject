package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesCategoryPage {

    private WebDriver driver;

    By secondProductImage = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.left-block > div > a.product_img_link > img");
    By secondProductAddToChart = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");
    By secondProductName = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.right-block > h5 > a");
    By secondProductPrice = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line.hovered > div > div.left-block > div > div.content_price > span");

    By continueShoppingButton =By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span");
    By tShirtButton = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");

    public SummerDressesCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void addChartSecondProduct(){
        WebElement secondProductImageElement = driver.findElement(secondProductImage);
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProductImageElement).perform();
        driver.findElement(secondProductAddToChart).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();

    }

    public String ProductName(){
        String dressProductName = driver.findElement(secondProductName).getText();

        return dressProductName;
    }

    public String ProductPrice(){
        WebElement secondProductImageElement = driver.findElement(secondProductImage);
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProductImageElement).perform();

        String dressProductPrice = driver.findElement(secondProductPrice).getText();
        double dressPriceDbl = Double.parseDouble(dressProductPrice.substring(1));
        String strDouble = String.format("%.2f", dressPriceDbl).replace(",",".");

        return strDouble;
    }

    public void goTShirtCategory(){
        driver.findElement(tShirtButton).click();
    }
}
