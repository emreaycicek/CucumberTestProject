package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesCategoryPage {
    private WebDriver driver;

    By summerDressesCategory = By.cssSelector("#categories_block_left > div > ul > li.last > a");

    public DressesCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void goSummerDressesCategory(){
        driver.findElement(summerDressesCategory).click();

    }
}
