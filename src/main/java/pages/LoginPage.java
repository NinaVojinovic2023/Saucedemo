package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorButton = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage() {
    }

    public void setUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public String getErrorAlert(){
        return  driver.findElement(errorButton).getText();
    }


}
