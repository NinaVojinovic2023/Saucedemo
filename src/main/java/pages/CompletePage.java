package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    private WebDriver driver;
    private By textMessage = By.className("title");
    private By backHomeButton = By.id("checkout_complete_container");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public CompletePage() {
    }

    public HomePage clickBackHome(){
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }
    public String getFinishShoppingText(){
        return driver.findElement(textMessage).getText();
    }




}
