package recruitment.tasks;

import org.testng.Assert;
import org.testng.annotations.*;
import recruitment.tasks.ui.pageobjecrs.listeners.TestListener;

@Listeners({TestListener.class})
public class PageTitleVeryficationTest extends AbstractTest{

    @Test
    public void pageTitleVeryficationTest() {

        homePage
                .ignoreFirstWindow()
                .getHomePageTitle();

        Assert.assertEquals(homePage.getHomePageTitle() , homePage.title);
    }
}
