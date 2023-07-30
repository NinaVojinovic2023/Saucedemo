package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class AddingToCartTestsPP extends BaseTest {
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
        @Test
        public void addAllItemsTest() {
            loginPage.setUsernameField("standard_user");
            loginPage.setPasswordField("secret_sauce");
            HomePage homePage = loginPage.clickLoginButton();
            ProductPage productPage = homePage.clickProductName("Sauce Labs Backpack");
            Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
            productPage.clickAddToCart();
            homePage = productPage.clickBackToProducts();
            productPage = homePage.clickProductName("Sauce Labs Bike Light");
            Assert.assertEquals(productPage.getProductName(), "Sauce Labs Bike Light", "Not true product name");
            productPage.clickAddToCart();
            homePage = productPage.clickBackToProducts();
            productPage = homePage.clickProductName("Sauce Labs Bolt T-Shirt");
            Assert.assertEquals(productPage.getProductName(), "Sauce Labs Bolt T-Shirt", "Not true product name");
            productPage.clickAddToCart();
            homePage = productPage.clickBackToProducts();
            productPage = homePage.clickProductName("Sauce Labs Fleece Jacket");
            Assert.assertEquals(productPage.getProductName(), "Sauce Labs Fleece Jacket", "Not true product name");
            productPage.clickAddToCart();
            homePage = productPage.clickBackToProducts();
            productPage = homePage.clickProductName("Sauce Labs Onesie");
            Assert.assertEquals(productPage.getProductName(), "Sauce Labs Onesie", "Not true product name");
            productPage.clickAddToCart();
            homePage = productPage.clickBackToProducts();
            productPage = homePage.clickProductName("Test.allTheThings() T-Shirt (Red)");
            Assert.assertEquals(productPage.getProductName(), "Test.allTheThings() T-Shirt (Red)", "Not true product name");
            productPage.clickAddToCart();
            CartPage cartPage = productPage.clickCart();
            Assert.assertEquals(cartPage.countItems(), 6, "Not true number of items");
        }

}
