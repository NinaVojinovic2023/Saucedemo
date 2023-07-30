package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    public LoginPage loginPage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.webdriver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        this.backToLoginPage();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void backToLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        }

        @AfterClass
        public void teardown () {
            driver.quit();
        }
    }

