package base;

import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver driver;

    public void navigateUrl(String url) {
        driver.get(url);
    }


}
