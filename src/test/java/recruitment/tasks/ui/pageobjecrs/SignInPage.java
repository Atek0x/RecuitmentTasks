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

public class SignInPage implements IPageValidation {

    private static final Logger LOGGER = LogManager.getLogger();
    WebDriver driver;
    WebDriverWait wait;

    private String email = "artek0xxx@gmail.com";
    private String password = "artek0x123)";
    public String error = "Zaloguj się";

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement nextButton;
    @FindBy(css = "input[type=\"email\"")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"headingText\"]")
    private WebElement logInPageTitle;
    //WebElement not in use.
    @FindBy(xpath = "xpathToPAgeTitle]")
    private WebElement passwordPageTitle;
    //WebElement not in use.
    @FindBy(xpath = "xpathToPasswordField")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"headingText\"]")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitToLoadPage() {
        LOGGER.info("Wait until page will be loaded.");
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public SignInPage fillEmailAddressField() {
        wait.until(ExpectedConditions.visibilityOf(logInPageTitle));
        emailField.clear();
        emailField.sendKeys(email);
        nextButton.click();
        return new SignInPage(driver, wait);
    }
//Method not in use
//    public SignInPage fillPasswordField() {
//        wait.until(ExpectedConditions.visibilityOf(passwordPageTitle));
//        passwordField.clear();
//        passwordField.sendKeys(password);
//        return new SignInPage(driver, wait);
//    }

    public String getErrorMessage() {
        LOGGER.info("Getting error message.");
        waitToLoadPage();
        return errorMessage.getText();
    }
}
