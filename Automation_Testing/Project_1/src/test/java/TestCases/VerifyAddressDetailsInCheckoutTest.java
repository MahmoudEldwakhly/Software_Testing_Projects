package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyAddressDetailsInCheckoutTest {

    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        loginPage = new LoginPage(framework);
        signupPage = new SignupPage(framework);
        registrationPage = new RegistrationPage(framework);
        checkoutPage = new CheckoutPage(framework);
    }

    @Test
    public void testVerifyAddressDetailsInCheckout() {
        // Open home
        homePage.navigateToURL("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Open signup/login
        homePage.clickSignupLogin();

        // Prepare unique email and registration data
        String name = "Addr User";
        String email = "addruser" + System.currentTimeMillis() + "@example.com";
        String password = "addrpass123";

        String firstName = "Mahmoud";
        String lastName  = "Eldwakhly";
        String company   = "Addr Company";
        String address1  = "123 Main St";
        String address2  = "Apt 10";
        String country   = "United States";
        String state     = "California";
        String city      = "Los Angeles";
        String zipcode   = "90001";
        String mobile    = "1234567890";

        // Start signup
        loginPage.enterSignupName(name);
        loginPage.enterSignupEmail(email);
        loginPage.clickSignup();

        // Fill account information
        Assert.assertTrue(signupPage.isAccountInfoVisible(), "Account info page not visible");
        signupPage.selectTitle("Mr");
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth("14", "2", "2003");
        signupPage.checkNewsletter();
        signupPage.checkOffers();
        signupPage.enterAddressInfo(
                firstName, lastName, company,
                address1, address2, country,
                state, city, zipcode, mobile
        );
        signupPage.clickCreateAccount();

        // Confirm creation and continue
        Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "Account creation failed");
        registrationPage.clickContinue();

        // Verify logged in banner
        Assert.assertTrue(homePage.isLoggedInAsVisible(), "Logged in as username not visible");

        // Add any product to cart from Products and open cart
        homePage.clickProducts();
        productsPage.addFirstProductToCart();
        productsPage.clickViewCart();

        // Verify cart page is displayed by checking the Proceed control
        Assert.assertTrue(checkoutPage.isProceedToCheckoutVisible(), "Cart page not displayed");

        // Proceed to checkout
        checkoutPage.clickProceedToCheckout();

        // Verify address section visible
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details not visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order not visible");

        // Grab address blocks
        String delivery = checkoutPage.getDeliveryAddressText();
        String billing  = checkoutPage.getBillingAddressText();

        // Verify delivery address contains all registration details
        assertBlockContainsAll(delivery,
                firstName + " " + lastName,
                company,
                address1,
                address2,
                city,
                state,
                zipcode,
                country,
                mobile
        );

        // Verify billing address contains all registration details
        assertBlockContainsAll(billing,
                firstName + " " + lastName,
                company,
                address1,
                address2,
                city,
                state,
                zipcode,
                country,
                mobile
        );

        // Cleanup account
        homePage.clickDeleteAccount();
        Assert.assertTrue(registrationPage.isAccountDeletedVisible(), "Account deletion failed");
        registrationPage.clickContinue();
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

    // Verifies that the address block includes each expected fragment, case-insensitive
    private void assertBlockContainsAll(String block, String... expectedPieces) {
        String haystack = block == null ? "" : block.toLowerCase();
        for (String piece : expectedPieces) {
            String needle = piece == null ? "" : piece.toLowerCase();
            Assert.assertTrue(haystack.contains(needle),
                    "Address block missing: [" + piece + "]\nBlock was:\n" + block);
        }
    }
}
