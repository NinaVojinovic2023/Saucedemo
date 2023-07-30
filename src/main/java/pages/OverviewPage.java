package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private WebDriver driver;

    private By totalItems = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver){
        this.driver = driver;
    }


    private String getItemTotal(){
        return driver.findElement(totalItems).getText();

    }

    public CompletePage clickFinish(){
        driver.findElement(finishButton).click();
        return new CompletePage(driver);
    }




}
