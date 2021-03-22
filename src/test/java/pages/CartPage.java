package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    By summerDressName = By.cssSelector("#product_6_31_0_462806 > td.cart_description > p > a");
    By tShirtName = By.cssSelector("#product_1_1_0_462806 > td.cart_description > p > a");
    By summerDressPrice = By.id("total_product_price_6_31_462806");
    By tShirtPrice = By.id("total_product_price_1_1_462806");
    By totalProduct = By.id("total_product");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String dressName(){
        String summerDressNameText = driver.findElement(summerDressName).getText();

        return summerDressNameText;
    }
    public String tShirtName(){
        String tShirtNameText = driver.findElement(tShirtName).getText();

        return tShirtNameText;
    }
    public String dressPrice(){
        String summerDressPriceText = driver.findElement(summerDressPrice).getText().substring(1);

        return summerDressPriceText;
    }
    public String tShirtPrice(){
        String tShirtPriceText = driver.findElement(tShirtPrice).getText().substring(1);

        return tShirtPriceText;
    }


    public String calculateTotalProduct(){
        String dressPriceStr = driver.findElement(summerDressPrice).getText().trim();
        String tShirtPriceStr = driver.findElement(tShirtPrice).getText().trim();

        double dressPriceFlo = Double.parseDouble(dressPriceStr.substring(1));
        double tShirtPriceFlo = Double.parseDouble(tShirtPriceStr.substring(1));

        double total = dressPriceFlo+tShirtPriceFlo;

        String strDouble = String.format("%.2f", total);

        return strDouble;
    }

    public String totalProduct(){
        String totalProductStr = driver.findElement(totalProduct).getText().trim();
        double totalProductFlo = Double.parseDouble(totalProductStr.substring(1));

        String strDouble = String.format("%.2f", totalProductFlo);

        return strDouble;
    }

}
