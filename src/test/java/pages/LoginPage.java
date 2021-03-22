package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By signIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    By email = By.id("email");
    By pssword = By.id("passwd");
    By signInButton = By.id("SubmitLogin");

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void signInPage(){

        driver.findElement(signIn).click();

    }
    public void signInCredentials(String username,String password){

        driver.findElement(email).sendKeys(username);
        driver.findElement(pssword).sendKeys(password);

    }
    public void signInButton(){

        driver.findElement(signInButton).click();
    }

}
