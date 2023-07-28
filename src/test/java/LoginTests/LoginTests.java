package LoginTests;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    @Test
    public void standardUserLoginTest() {
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void problemUserLoginTest() {
        loginPage.setUsernameField("problem_user");
        loginPage.setPasswordField("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void lockedUserLoginTest() {
        loginPage.setUsernameField("locked_out_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is login successfully");
    }

    @Test
    public void performanceGlitchUserLoginTest() {
        loginPage.setUsernameField("performance_glitch_user");
        loginPage.setPasswordField("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }
    @Test
    public void loginWithWrongUsernameTest() {
        loginPage.setUsernameField("Nina");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void LoginWithWrongPasswordTest() {
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("Nina");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void loginJustWithUsernameTest() {
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test
    public void loginWhithoutUsernameTest() {
        loginPage.setUsernameField("");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
    @Test
    public void loginWithoutCredintialsTest() {
        loginPage.setUsernameField("");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
}