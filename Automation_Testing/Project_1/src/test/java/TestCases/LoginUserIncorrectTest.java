package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserIncorrectTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        // Initialize page objects
        homePage = new HomePage(framework);
        loginPage = new LoginPage(framework);
    }

    @Test
    public void testLoginUserWithIncorrectCredentials() {
        // 1. Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // 2. Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // 3. Click Signup/Login
        homePage.clickSignupLogin();

        // 4. Verify Login section
        Assert.assertTrue(loginPage.isLoginToAccountVisible(), "'Login to your account' is not visible");

        // 5. Enter incorrect credentials
        loginPage.enterLoginEmail("wronguser" + System.currentTimeMillis() + "@example.com");
        loginPage.enterLoginPassword("wrongpassword");

        // 6. Click login
        loginPage.clickLogin();

        // 7. Verify error message
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Error message not displayed for invalid login");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
