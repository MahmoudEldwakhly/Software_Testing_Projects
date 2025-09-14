package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubscriptionInCartPageTest {
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
    public void testVerifySubscriptionInCartPage() {
        // Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Click Cart
        homePage.clickCart();

        // Scroll down to footer
        homePage.scrollToSubscription();

        // Verify Subscription text
        Assert.assertTrue(homePage.isSubscriptionTextVisible(), "'SUBSCRIPTION' text not visible");

        // Enter email and click subscribe
        String email = "cartsub" + System.currentTimeMillis() + "@example.com";
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
