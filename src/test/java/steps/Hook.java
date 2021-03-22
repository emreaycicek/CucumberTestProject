package steps;

import base.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseTest {

    private BaseTest base;

    public Hook(BaseTest base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        //setProperty();
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        base.driver.quit();
    }

    /*
    public static void setProperty() {
    }*/

}
