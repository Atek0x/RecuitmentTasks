package recruitment.tasks;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import recruitment.tasks.ui.pageobjecrs.listeners.TestListener;

@Listeners({TestListener.class})
public class UserSignUpTest extends AbstractTest {
    @Test
    public void userSignInTest() {

        homePage
                .ignoreFirstWindow()
                .clickOnSignUpButton();

        signUpPage
                .clickCreateButton()
                .chooseAccountOptionAndClickOnIt()
                .fillNameAndLastNameFields()
                .clickNextButton()
                .fillBackgroundInformationFields()
                .fillUserNameInEmailAddress()
                .fillPasswordFields();

        // Because the site won't let me register due to phone number verification, to confirm that I am not a robot,
        // I decided to end this test by entering a password that was too weak for the site to return an error.

        Assert.assertEquals(signUpPage.getErrorMessage(), signUpPage.error);
    }
}
