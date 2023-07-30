package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By titleCategory = By.className("title");
    private By cartButton = By.className("shopping_cart_link");
    private By cartButtonBadge = By.className("shopping_cart_badge");

    public HomePage(WebDriver driver){
        this.driver= driver;
    }

    public ProductPage clickProductName(String productName){
        driver.findElement(By.linkText(productName)).click();
        return new ProductPage(driver);
    }

    public String getTitle(){
        return driver.findElement(titleCategory).getText();
    }

    public CartPage clickCart(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public void clickAddToCartButtonFromHPByIndex(int index){
        List<WebElement> button = driver.findElements(By.className("btn_small"));
        button.get(index).click();
    }

    public void clickRemoveButtonFromHPByIndex(int index){
        List<WebElement> button = driver.findElements(By.className("btn_small"));
        button.get(index).click();
    }
    public String getBadgeCartNumber(){
        return driver.findElement(cartButtonBadge).getText();
    }





}
