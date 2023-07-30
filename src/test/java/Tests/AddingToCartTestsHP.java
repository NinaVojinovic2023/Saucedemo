package Tests;

import Base.BaseTest;
import Utils.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

import java.util.HashMap;

public class AddingToCartTestsHP extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void addOneItemTest(HashMap<String, String> hashMap) {
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartButtonFromHPByIndex(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 1, "Not true number of items");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void addAllItemsTest(HashMap<String, String> hashMap) {
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartButtonFromHPByIndex(0);
        homePage.clickAddToCartButtonFromHPByIndex(1);
        homePage.clickAddToCartButtonFromHPByIndex(2);
        homePage.clickAddToCartButtonFromHPByIndex(3);
        homePage.clickAddToCartButtonFromHPByIndex(4);
        homePage.clickAddToCartButtonFromHPByIndex(5);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 6, "Not expected number of items");
    }
}