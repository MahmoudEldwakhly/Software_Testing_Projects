package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.LoginPage;
import Main.Pages.RegistrationPage;
import Main.Pages.SignupPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;
    
    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15); // Increased wait time
        
        // Initialize page objects
        homePage = new HomePage(framework);
        loginPage = new LoginPage(framework);
        signupPage = new SignupPage(framework);
        registrationPage = new RegistrationPage(framework);
    }
    
    @Test
    public void testRegisterUser() {
        try {
            // 1. Launch browser (done in setUp)
            // 2. Navigate to url 'http://automationexercise.com'
            System.out.println("Navigating to Automation Exercise...");
            homePage.navigateToHomePage("http://automationexercise.com");
            
            // 3. Verify that home page is visible successfully
            System.out.println("Verifying home page...");
            assert homePage.isHomePageVisible() : "Home page is not visible";
            
            // 4. Click on 'Signup / Login' button
            System.out.println("Clicking Signup/Login...");
            homePage.clickSignupLogin();
            
            // Add a small delay to ensure page loads
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            
            // 5. Verify 'New User Signup!' is visible
            System.out.println("Verifying New User Signup text...");
            assert loginPage.isNewUserSignupVisible() : "New User Signup! is not visible";
            
            // 6. Enter name and email address
            System.out.println("Entering signup details...");
            String name = "Test User";
            String email = "testuser" + System.currentTimeMillis() + "@example.com";
            loginPage.enterSignupName(name);
            loginPage.enterSignupEmail(email);
            
            // 7. Click 'Signup' button
            System.out.println("Clicking Signup button...");
            loginPage.clickSignup();
            
            // Add a small delay to ensure page loads
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            
            // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            System.out.println("Verifying Account Information text...");
            assert signupPage.isAccountInfoVisible() : "ENTER ACCOUNT INFORMATION is not visible";
            
            // 9. Fill details: Title, Name, Email, Password, Date of birth
            System.out.println("Filling account information...");
            signupPage.selectTitle("Mr");
            signupPage.enterPassword("password123");
            signupPage.selectDateOfBirth("10", "1", "1990"); // Using numeric month
            
            // 10. Select checkbox 'Sign up for our newsletter!'
            signupPage.checkNewsletter();
            
            // 11. Select checkbox 'Receive special offers from our partners!'
            signupPage.checkOffers();
            
            // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            signupPage.enterAddressInfo(
                "Test", 
                "User", 
                "Test Company", 
                "123 Test Street", 
                "Apt 1", 
                "United States", 
                "California", 
                "Los Angeles", 
                "90001", 
                "1234567890"
            );
            
            // 13. Click 'Create Account button'
            System.out.println("Creating account...");
            signupPage.clickCreateAccount();
            try { Thread.sleep(5000); } catch (InterruptedException e) {}

// 14. Verify that 'ACCOUNT CREATED!' is visible
System.out.println("Verifying account creation...");
boolean accountCreated = registrationPage.isAccountCreatedVisible();
if (!accountCreated) {
    System.out.println("Account creation verification failed, checking page content...");
    // Take a screenshot or log page source for debugging
    System.out.println("Current URL: " + framework.getCurrentURL());
    System.out.println("Page title: " + framework.getPageTitle());
}

assert accountCreated : "ACCOUNT CREATED! is not visible";
            // 14. Verify that 'ACCOUNT CREATED!' is visible
            System.out.println("Verifying account creation...");
            assert registrationPage.isAccountCreatedVisible() : "ACCOUNT CREATED! is not visible";
            
            // 15. Click 'Continue' button
            registrationPage.clickContinue();
            
            // 16. Verify that 'Logged in as username' is visible
            System.out.println("Verifying login status...");
            assert homePage.isLoggedInAsVisible() : "Logged in as username is not visible";
            
            // 17. Click 'Delete Account' button
            homePage.clickDeleteAccount();
            
            // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            System.out.println("Verifying account deletion...");
            assert registrationPage.isAccountDeletedVisible() : "ACCOUNT DELETED! is not visible";
            registrationPage.clickContinue();
            
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}