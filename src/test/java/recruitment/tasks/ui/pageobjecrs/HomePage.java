package recruitment.tasks.ui.pageobjecrs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import recruitment.tasks.ui.pageobjecrs.interfaces.IPageValidation;

public class HomePage implements IPageValidation {

    private static final Logger LOGGER = LogManager.getLogger();
    WebDriver driver;
    WebDriverWait wait;

    public String title = "Google";

    @FindBy(className = "gb_Ld")
    private WebElement signInButton;

    @FindBy(className = "gb_Ld")
    private WebElement signUpButton;

    @FindBy(className = "lnXdpd")
    private WebElement homePageTitle;

    @FindBy(id = "W0wltc")
    private WebElement rejectAllButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitToLoadPage() {
        LOGGER.info("Wait until page will be loaded.");
        wait.until(ExpectedConditions.visibilityOf(homePageTitle));
    }

    public String getHomePageTitle() {
        LOGGER.info("Return home page title.");
        wait.until(ExpectedConditions.visibilityOf(homePageTitle));
        return homePageTitle.getText();
    }

    public HomePage ignoreFirstWindow() {
        LOGGER.info("Reject all cookie");
        wait.until(ExpectedConditions.elementToBeClickable(rejectAllButton));
        rejectAllButton.click();
        return new HomePage(driver, wait);
    }

    public HomePage clickOnSignUpButton() {
        signUpButton.click();
        return new HomePage(driver, wait);
    }
}
