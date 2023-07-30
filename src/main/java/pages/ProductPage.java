package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

private WebDriver driver;

    private By productName = By.className("inventory_details_name");
    private By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private By backToProductsButton = By.className("#back-to-products");
    private By cart = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage clickAddToCart(){
        driver.findElement(addToCartButton).click();
        return new ProductPage(driver);

    }


    public HomePage clickBackToProductsButton(){
        driver.findElement(backToProductsButton).click();
        return new HomePage(driver);

    }

    public String getProductName(){

        return driver.findElement(productName).getText();
    }


    public CartPage clickCart(){
        driver.findElement(cart).click();
        return new CartPage(driver);
    }

    public HomePage clickBackToProducts() {
        driver.findElement(By.id("back-to-products"));
        return new HomePage(driver);
    }
}
