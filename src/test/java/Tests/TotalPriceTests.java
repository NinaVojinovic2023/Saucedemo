package Tests;

import Base.BaseTest;
import Utils.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OverviewPage;

import java.util.HashMap;

public class TotalPriceTests extends BaseTest {

        @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
        public void getItemTotalTest(HashMap<String, String> hashMap) {
            loginPage.setUsernameField(hashMap.get("username"));
            loginPage.setPasswordField(hashMap.get("password"));
            HomePage homePage = loginPage.clickLoginButton();
            homePage.clickAddToCartButtonFromHPByIndex(0);
            CartPage cartPage = homePage.clickCart();
            Assert.assertEquals(cartPage.countItems(), 1, "Not expected number");
            CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
            checkoutPage.setFirstName("Nina");
            checkoutPage.setLastName("Vojinovic");
            checkoutPage.setPostCode("11000");
            OverviewPage overviewPage = checkoutPage.clickContinueButton();
            Assert.assertEquals(overviewPage.By.className("summary_subtotal_label");, "Item total: $28.06", "Not expected price");

        }
    }

