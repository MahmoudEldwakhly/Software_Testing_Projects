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

public class RegisterUserExistingEmailTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;

    private final String existingEmail = "mahmoudaldwakhly53@gmail.com";
    private final String password = "123456789";

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
    public void testRegisterUserWithExistingEmail() {
        // ---------- Step 1: Ensure account exists ----------
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isNewUserSignupVisible(), "'New User Signup!' not visible");

        // Try to log in with the existing account
        loginPage.enterLoginEmail(existingEmail);
        loginPage.enterLoginPassword(password);
        loginPage.clickLogin();

        // If login succeeds, we know the account already exists
        boolean alreadyLoggedIn = homePage.isLoggedInAsVisible();

        if (!alreadyLoggedIn) {
            // If not logged in, create the account
            homePage.clickSignupLogin();
            loginPage.enterSignupName("Existing User");
            loginPage.enterSignupEmail(existingEmail);
            loginPage.clickSignup();

            Assert.assertTrue(signupPage.isAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' not visible");

            signupPage.selectTitle("Mr");
            signupPage.enterPassword(password);
            signupPage.selectDateOfBirth("10", "March", "1995");
            signupPage.checkNewsletter();
            signupPage.checkOffers();
            signupPage.enterAddressInfo(
                    "Existing", "User", "Company", "123 Street", "Apt 1",
                    "United States", "California", "Los Angeles", "90001", "1234567890"
            );
            signupPage.clickCreateAccount();

            Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "'ACCOUNT CREATED!' not visible");
            registrationPage.clickContinue();
            Assert.assertTrue(homePage.isLoggedInAsVisible(), "'Logged in as username' not visible after creating account");

            // Logout so we can test signup again
            homePage.clickLogout();
        }

        // ---------- Step 2: Try to sign up again with same email ----------
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isNewUserSignupVisible(), "'New User Signup!' not visible");

        loginPage.enterSignupName("Existing User");
        loginPage.enterSignupEmail(existingEmail);
        loginPage.clickSignup();

        // ---------- Step 3: Verify error message ----------
        Assert.assertTrue(loginPage.isSignupEmailErrorVisible(), "'Email Address already exist!' message not displayed");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
