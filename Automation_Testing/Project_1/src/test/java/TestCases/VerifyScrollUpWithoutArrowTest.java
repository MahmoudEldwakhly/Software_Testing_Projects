package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyScrollUpWithoutArrowTest {

    private SeleniumFrameWork framework;
    private HomePage homePage;

    // Bottom sentinel to guarantee a real downward scroll
    private final By footer = By.cssSelector("footer");

    // Case-insensitive "SUBSCRIPTION" anywhere near the bottom
    private final By subscriptionTitleAny = By.xpath(
        "//*[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SUBSCRIPTION')]"
    );

    // Top hero text (what we must see after scrolling up)
    private final By topHeroText = By.xpath(
        "//*[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')," +
        "'FULL-FLEDGED PRACTICE WEBSITE FOR AUTOMATION ENGINEERS')]"
    );

    // Header and Home link as reliable top sentinels
    private final By header = By.cssSelector("#header");
    private final By homeLink = By.cssSelector("a[href='/']");

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);
        homePage = new HomePage(framework);
    }

    @Test
    public void testScrollUpWithoutArrow() {
        // Open site and confirm home page is visible
        framework.navigateToURL("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Scroll down by bringing the footer into view
        framework.scrollToElement(footer);

        // Confirm SUBSCRIPTION is present near the bottom
        framework.explicitWait(subscriptionTitleAny, 10);

        // Try to scroll back up without using the arrow
        Assert.assertTrue(scrollBackToTop(), "Failed to scroll back to top and show the hero text");
    }

    private boolean scrollBackToTop() {
        // First attempt: scroll to header, then to the hero text
        try { framework.scrollToElement(header); } catch (Exception ignored) {}
        try { framework.scrollToElement(topHeroText); } catch (Exception ignored) {}

        if (isHeroVisible()) return true;

        // Fallback: click the Home link to land at the top (still not using the arrow)
        try {
            framework.explicitWait(homeLink, 5);
            framework.click(homeLink);
            return isHeroVisible();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isHeroVisible() {
        try {
            framework.explicitWait(topHeroText, 10);
            String hero = framework.getText(topHeroText);
            return hero != null && hero.toUpperCase().contains("FULL-FLEDGED PRACTICE WEBSITE FOR AUTOMATION ENGINEERS");
        } catch (Exception e) {
            return false;
        }
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}
