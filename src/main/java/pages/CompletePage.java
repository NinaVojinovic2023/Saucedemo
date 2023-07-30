package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    private WebDriver driver;
    private By textMessage = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }
    public String getFinishShoppingText(){
        return driver.findElement(textMessage).getText();
    }




}
