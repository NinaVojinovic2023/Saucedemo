package Tests;

import Base.BaseTest;
import Utils.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

import java.util.HashMap;

public class RemoveProductsTestsHP extends BaseTest {

        @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
        public void removeFromHomePageTest(HashMap<String, String> hashMap){
            loginPage.setUsernameField(hashMap.get("username"));
            loginPage.setPasswordField(hashMap.get("password"));
            HomePage homePage = loginPage.clickLoginButton();
            homePage.clickRemoveButtonFromHPByIndex(0);
            CartPage cartPage = homePage.clickCart();
            cartPage.clickRemoveByIndex(0);
            Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
        }
        @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
        public void removeAllItemsFromHomePageTest(HashMap<String, String> hashMap){
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
            cartPage.clickRemoveByIndex(0);
            cartPage.clickRemoveByIndex(1);
            cartPage.clickRemoveByIndex(2);
            cartPage.clickRemoveByIndex(3);
            cartPage.clickRemoveByIndex(4);
            cartPage.clickRemoveByIndex(5);
            Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
        }
    }

