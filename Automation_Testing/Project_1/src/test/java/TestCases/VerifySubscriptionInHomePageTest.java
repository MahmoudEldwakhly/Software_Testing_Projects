package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubscriptionInHomePageTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
    }

    @Test
    public void testVerifySubscriptionInHomePage() {
        // Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Scroll down to footer
        homePage.scrollToSubscription();

        // Verify Subscription text is visible
        Assert.assertTrue(homePage.isSubscriptionTextVisible(), "'SUBSCRIPTION' text not visible");

        // Enter email and click subscribe
        String email = "test" + System.currentTimeMillis() + "@example.com";
        homePage.enterSubscriptionEmail(email);
        homePage.clickSubscribeButton();

        // Verify success message
        Assert.assertTrue(homePage.isSubscriptionSuccessMessageVisible(), "Subscription success message not visible");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}
