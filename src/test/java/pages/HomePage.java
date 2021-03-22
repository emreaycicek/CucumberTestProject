package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    By dressesCategory = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void assertPageAddress(){
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }
    public void goDressesCategory(){
        driver.findElement(dressesCategory).click();

    }

}
