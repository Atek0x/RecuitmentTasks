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
import recruitment.tasks.utils.Utils;

public class SignUpPage implements IPageValidation {

    private static final Logger LOGGER = LogManager.getLogger();
    private WebDriver driver;
    private WebDriverWait wait;
    private String name = "Stefan";
    private String lastName = "Batory";
    private Integer day = 27;
    private Integer year = 1933;
    private Integer emailUserName = Utils.generateRandomNumber();
    private String user = "usertest" + emailUserName;
    private Integer userPassword = Utils.generateRandomNumber();
    private String password = "passwordtest" + userPassword;
    public String error = "Utwórz silne hasło";

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[3]/div/div[2]/div/div/div[1]/div/button/span")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[3]/div/div[2]/div/div/div[2]/div/ul/li[1]/span[2]")
    private WebElement selectPersonalUser;

    @FindBy(xpath = "//*[@id=\"collectNameNext\"]/div/button/span")
    private WebElement nextButton;

    @FindBy(css = "input[name='day']")
    private WebElement dayField;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    private WebElement backgroundInfomationPageTitle;

    @FindBy(id = "month")
    private WebElement monthChoiceMenu;

    @FindBy(xpath = "//*[@id=\"month\"]/option[10]")
    private WebElement monthChoice;

    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement yearField;

    @FindBy(id = "gender")
    private WebElement genderChoiceMenu;

    @FindBy(xpath = "//*[@id=\"gender\"]/option[3]")
    private WebElement genderChoice;

    @FindBy(xpath = "//*[@id=\"birthdaygenderNext\"]/div/button/span")
    private WebElement nextButton2;

    @FindBy(id = "headingSubtext")
    private WebElement loginMethondPageTitle;

    @FindBy(css = "input[jsname=\"YPqjbf\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id=\"next\"]/div/button/span")
    private WebElement nextButton3;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    private WebElement createStongPasswodPageTitle;

    @FindBy(xpath = "//*[@id=\"passwd\"]/div[1]/div/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")
    private WebElement passwordAgainField;

    @FindBy(className = "VfPpkd-vQzf8d")
    private WebElement nextButton4;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    private WebElement errorMessage;

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitToLoadPage() {
        LOGGER.info("Wait until page will be loaded.");
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public SignUpPage clickCreateButton() {
        LOGGER.info("Clicking on 'Create Account' button.");
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        createAccountButton.click();
        return new SignUpPage(driver, wait);
    }

    public SignUpPage chooseAccountOptionAndClickOnIt() {
        LOGGER.info("Choosing account option and clicking on it.");
        wait.until(ExpectedConditions.visibilityOf(selectPersonalUser));
        selectPersonalUser.click();
        return new SignUpPage(driver, wait);
    }

    public SignUpPage fillNameAndLastNameFields() {
        LOGGER.info("Filling name and last name fields.");
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.clear();
        nameField.sendKeys(name);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return new SignUpPage(driver, wait);
    }

    public SignUpPage clickNextButton() {
        LOGGER.info("Clicking on 'Next' button.");
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
        return new SignUpPage(driver, wait);
    }

    public SignUpPage fillBackgroundInformationFields() {
        LOGGER.info("Filling background information fields.");
        wait.until(ExpectedConditions.visibilityOf(backgroundInfomationPageTitle));
        sleep(3000);
        dayField.clear();
        dayField.sendKeys(day.toString());
        monthChoiceMenu.click();
        wait.until(ExpectedConditions.visibilityOf(monthChoice));
        monthChoice.click();
        yearField.click();
        yearField.sendKeys(year.toString());
        genderChoiceMenu.click();
        wait.until(ExpectedConditions.visibilityOf(genderChoice));
        genderChoice.click();
        nextButton2.click();
        return new SignUpPage(driver, wait);
    }

    public SignUpPage fillUserNameInEmailAddress() {
        LOGGER.info("Filling user name in email address field.");
        wait.until(ExpectedConditions.visibilityOf(loginMethondPageTitle));
        sleep(2000);
        userNameField.clear();
        userNameField.sendKeys(user);
        nextButton3.click();
        return new SignUpPage(driver, wait);
    }

    public SignUpPage fillPasswordFields() {
        LOGGER.info("Filling password fields.");
        wait.until(ExpectedConditions.visibilityOf(createStongPasswodPageTitle));
        sleep(2000);
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordAgainField.clear();
        passwordAgainField.sendKeys(password);
        sleep(2000);
        nextButton4.click();
        nextButton4.click();
        return new SignUpPage(driver, wait);
    }

    public String getErrorMessage() {
        LOGGER.info("Getting error message.");
        waitToLoadPage();
        return errorMessage.getText();
    }
}
