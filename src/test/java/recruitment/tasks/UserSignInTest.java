package recruitment.tasks;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import recruitment.tasks.ui.pageobjecrs.listeners.TestListener;

@Listeners({TestListener.class})
public class UserSignInTest extends AbstractTest{

    @Test
    public void userSignInTest() {

        homePage
                .ignoreFirstWindow()
                .clickOnSignUpButton();
        signInPage
                .fillEmailAddressField();

        //Google prevents logins from some browsers. Google may block login from browsers.

        Assert.assertEquals(signInPage.getErrorMessage(), signInPage.error);
    }
}
