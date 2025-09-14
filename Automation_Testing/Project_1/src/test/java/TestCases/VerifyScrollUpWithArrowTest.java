package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyScrollUpWithArrowTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;

    // Footer "SUBSCRIPTION" title (robust uppercase match)
    private final By subscriptionTitle = By.xpath(
        "//footer//h2[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SUBSCRIPTION')]"
    );

    // Bottom-right scroll-up arrow
    private final By scrollUpArrow = By.cssSelector("#scrollUp");

    // Top hero text: "Full-Fledged practice website for Automation Engineers"
    private final By topHeroText = By.xpath(
        "//*[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')," +
        "'FULL-FLEDGED PRACTICE WEBSITE FOR AUTOMATION ENGINEERS')]"
    );

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);
        homePage = new HomePage(framework);
    }

    @Test
    public void testVerifyScrollUpUsingArrowAndScrollDown() {
        // Navigate to home page
        homePage.navigateToURL("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Scroll to the footer by targeting the SUBSCRIPTION heading directly
        try { framework.scrollToElement(subscriptionTitle); } catch (Exception ignore) {}
        framework.explicitWait(subscriptionTitle, 10);
        String subTxt = framework.getText(subscriptionTitle);
        Assert.assertTrue(subTxt != null && subTxt.toUpperCase().contains("SUBSCRIPTION"),
                "'SUBSCRIPTION' title not visible after scrolling down");

        // Click the bottom-right scroll-up arrow
        framework.explicitWait(scrollUpArrow, 10);
        try {
            framework.click(scrollUpArrow);
        } catch (Exception e) {
            framework.clickWithJS(scrollUpArrow);
        }

        // Verify the page scrolled back to top by asserting the hero text is visible
        framework.explicitWait(topHeroText, 10);
        String heroText = framework.getText(topHeroText);
        Assert.assertTrue(
            heroText != null &&
            heroText.toUpperCase().contains("FULL-FLEDGED PRACTICE WEBSITE FOR AUTOMATION ENGINEERS"),
            "Top hero text not visible after scrolling up"
        );
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}
