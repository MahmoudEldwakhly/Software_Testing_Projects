package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTestCasesPageTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        // Initialize page objects
        homePage = new HomePage(framework);
    }

    @Test
    public void testVerifyTestCasesPage() {
        // 1. Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // 2. Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // 3. Click Test Cases
        homePage.clickTestCases();

        // 4. Verify user is on Test Cases page
        String currentUrl = framework.getCurrentURL();
        String title = framework.getPageTitle();

        Assert.assertTrue(currentUrl.contains("/test_cases"), "Did not navigate to Test Cases page. Current URL: " + currentUrl);
        Assert.assertTrue(title.toLowerCase().contains("test cases"), "Page title does not indicate Test Cases page. Title: " + title);
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
