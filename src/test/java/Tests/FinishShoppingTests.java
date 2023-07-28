package Tests;

import Base.BaseTest;
import Utils.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;

public class FinishShoppingTests {

    public class FinishShoppingTest extends BaseTest {
        @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
        public void finishShoppingTest(HashMap<String, String> hashMap){
            loginPage.setUsernameField(hashMap.get("username"));
            loginPage.setPasswordField(hashMap.get("password"));
            HomePage homePage = loginPage.clickLoginButton();
            homePage.clickAddToCartButtonFromHPByIndex(0);
            CartPage cartPage = homePage.clickCart();
            Assert.assertEquals(cartPage.countItems(), 1, "Not expected number");
            CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
            checkoutPage.setFirstName(hashMap.get("firstName"));
            checkoutPage.setLastName(hashMap.get("lastName"));
            checkoutPage.setPostCode(hashMap.get("postalCode"));
            OverviewPage overviewPage = checkoutPage.clickContinueButton();
            Assert.assertEquals(overviewPage.getItemTotal(), "Item total: $29.99", "Not expected price");
            CompletePage completeCheckoutPage = overviewPage.clickFinish();
            Assert.assertEquals(completeCheckoutPage.getFinishShoppingText(),
                    "Thank you for your order!",
                    "Not expected text");

        }
    }
}
