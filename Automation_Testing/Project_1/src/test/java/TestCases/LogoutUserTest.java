package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.LoginPage;
import Main.Pages.SignupPage;
import Main.Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutUserTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        // Initialize page objects
        homePage = new HomePage(framework);
        loginPage = new LoginPage(framework);
        signupPage = new SignupPage(framework);
        registrationPage = new RegistrationPage(framework);
    }

    @Test
    public void testLogoutUser() {
        // ---------- Account Creation ----------
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isNewUserSignupVisible(), "'New User Signup!' not visible");

        String name = "Logout Test User";
        String email = "logoutuser" + System.currentTimeMillis() + "@example.com";
        String password = "logoutpass123";

        loginPage.enterSignupName(name);
        loginPage.enterSignupEmail(email);
        loginPage.clickSignup();

        Assert.assertTrue(signupPage.isAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' not visible");

        signupPage.selectTitle("Mr");
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth("10", "March", "1995");
        signupPage.checkNewsletter();
        signupPage.checkOffers();
        signupPage.enterAddressInfo(
                "Logout", "User", "Test Company", "123 Test Street", "Apt 9",
                "United States", "California", "Los Angeles", "90001", "1234567890"
        );
        signupPage.clickCreateAccount();

        Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "'ACCOUNT CREATED!' not visible");
        registrationPage.clickContinue();

        Assert.assertTrue(homePage.isLoggedInAsVisible(), "'Logged in as username' not visible after signup");

        // ---------- Logout Flow ----------
        homePage.clickLogout();

        // Verify navigation back to login page
        Assert.assertTrue(loginPage.isLoginToAccountVisible(), "User was not redirected to login page after logout");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
