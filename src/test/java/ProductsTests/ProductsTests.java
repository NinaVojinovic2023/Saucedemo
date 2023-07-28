package ProductsTests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import javax.sql.RowSet;

public class ProductsTests extends BaseTest {
            @Test
            public void addOneItemTest() {
                loginPage.setUsernameField("standard_user");
                loginPage.setPasswordField("secret_sauce");
                HomePage homePage = loginPage.clickLoginButton();
                ProductPage productPage = homePage.clickProductName("Sauce Labs Backpack");
                Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
                productPage.clickAddToCart();
                CartPage cartPage = productPage.clickCart();
                Assert.assertEquals(cartPage.countItems(), 1, "Not true number of items");
            }
    }

