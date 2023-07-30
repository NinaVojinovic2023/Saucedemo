package Tests;

import Base.BaseTest;
import Utils.DataUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginDataProviderTests extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void standardUserLoginTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        HomePage homePage1 = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void problemUserLoginTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        HomePage homePage1 = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider3")
    public void lockedUserLoginTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        HomePage homePage1 = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider4")
    public void performanceGlitchUserLoginTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        HomePage homePage1 = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider5")
    public void loginWithWrongUsernameTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(), "Epic sadface: Username and password do not match any user in this servic" , "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider6")
    public void LoginWithWrongPasswordTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider7")
    public void loginJustWithUsernameTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider8")
    public void loginWhithoutUsernameTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider9")
    public void loginWithoutCredintialsTest(HashMap<String, String>hashMap){
        loginPage.setUsernameField(hashMap.get("username"));
        loginPage.setPasswordField(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorAlert(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }








}
