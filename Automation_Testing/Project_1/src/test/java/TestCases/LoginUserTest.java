
/**
 *
 * @author mahmoud eldawakhly
 */
package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.LoginPage;
import Main.Pages.RegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    
    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);
        
        // Initialize page objects
        homePage = new HomePage(framework);
        loginPage = new LoginPage(framework);
        registrationPage = new RegistrationPage(framework);
    }
    
    @Test
    public void testLoginUserWithCorrectCredentials() {
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
            
            // 5. Verify 'Login to your account' is visible
            System.out.println("Verifying Login to your account text...");
            assert loginPage.isLoginToAccountVisible() : "Login to your account is not visible";
            
            // 6. Enter correct email address and password
            System.out.println("Entering login credentials...");
            String email = "mahmoudaldwakhly53@gmail.com"; 
            String password = "123456789";      
            
            loginPage.enterLoginEmail(email);
            loginPage.enterLoginPassword(password);
            
            // 7. Click 'login' button
            System.out.println("Clicking Login button...");
            loginPage.clickLogin();
            
            // Add a small delay to ensure login completes
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            
            // 8. Verify that 'Logged in as username' is visible
            System.out.println("Verifying login status...");
            assert homePage.isLoggedInAsVisible() : "Logged in as username is not visible";
            
            // 9. Click 'Delete Account' button
            homePage.clickDeleteAccount();
            
            // 10. Verify that 'ACCOUNT DELETED!' is visible
            System.out.println("Verifying account deletion...");
            assert registrationPage.isAccountDeletedVisible() : "ACCOUNT DELETED! is not visible";
            
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