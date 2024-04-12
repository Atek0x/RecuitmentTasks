package recruitment.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import recruitment.tasks.driver.BrowserType;
import recruitment.tasks.driver.DriverManager;
import recruitment.tasks.ui.pageobjecrs.HomePage;
import recruitment.tasks.ui.pageobjecrs.SignInPage;
import recruitment.tasks.ui.pageobjecrs.SignUpPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static recruitment.tasks.utils.Utils.CONFIG_DATA;

abstract public class AbstractTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeMethod()
    public void setup() throws MalformedURLException {

        initialisation();
        homePage = new HomePage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        signUpPage = new SignUpPage(driver, wait);
    }

    public void initialisation() throws MalformedURLException {
        LOGGER.info("Prepare every setting to start testing run.");
        String gridUrl = System.getProperty("grid.url");
        if (gridUrl == null) {
            DriverManager.getInstance().setWebDriver(BrowserType.valueOf(CONFIG_DATA.driverType()));
        } else {
            driver = new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
        }
        driver = DriverManager.getInstance().getDriver();
        driver.get(CONFIG_DATA.uiUrl());
        driver.manage().window().maximize();
        Duration timeout = Duration.ofSeconds(CONFIG_DATA.waitTimeoutInSeconds());
        wait = new WebDriverWait(driver, timeout);
    }

//    @AfterMethod()
//    public void terminate() {
//        LOGGER.info("Close driver after test method.");
//        driver.quit();
//    }
}
