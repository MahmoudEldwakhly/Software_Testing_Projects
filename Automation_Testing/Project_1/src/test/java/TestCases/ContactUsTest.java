package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ContactUsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        // Initialize page objects
        homePage = new HomePage(framework);
        contactUsPage = new ContactUsPage(framework);
    }

    @Test
    public void testContactUsForm() {
        // 1. Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // 2. Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // 3. Click Contact Us
        framework.click(By.cssSelector("a[href='/contact_us']")); // Direct click from framework

        // 4. Verify 'GET IN TOUCH'
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' not visible");

        // 5. Enter form details
        contactUsPage.enterName("Test User");
        contactUsPage.enterEmail("testuser@example.com");
        contactUsPage.enterSubject("Automation Test");
        contactUsPage.enterMessage("This is a test message submitted via automation.");

        // 6. Upload file (File path)
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testfile.txt";
        contactUsPage.uploadFile(filePath);

        // 7. Submit
        contactUsPage.clickSubmit();

        // 8. Handle alert
        contactUsPage.acceptAlert();

        // 9. Verify success message
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message not displayed");

        // 10. Click Home and verify landed on home page
        contactUsPage.clickHome();
        Assert.assertTrue(homePage.isHomePageVisible(), "Not navigated back to home page");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
