package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductsVerifyCartAfterLoginTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        cartPage = new CartPage(framework);
        loginPage = new LoginPage(framework);
        signupPage = new SignupPage(framework);
        registrationPage = new RegistrationPage(framework);
    }

    @Test
    public void testSearchProductsAndVerifyCartAfterLogin() {
        // Launch + go to Products
        homePage.navigateToHomePage("http://automationexercise.com");
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible");

        // Search and verify results
        productsPage.searchProduct("dress");
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "'SEARCHED PRODUCTS' header not visible");
        Assert.assertTrue(productsPage.areSearchedProductsVisible(), "No products shown in searched grid");

        // Add ALL items from the SEARCHED PRODUCTS grid (first page only)
        int totalResults = productsPage.getSearchedResultsCount();
        int added = productsPage.addAllSearchedResultsToCart();
        Assert.assertTrue(added > 0, "Nothing was added from the search results grid");

        // Open Cart and verify items are present
        productsPage.clickViewCart();
        Assert.assertTrue(cartPage.isAnyCartRowPresent(), "Cart appears empty after adding searched items");
        int rowsBeforeAuth = cartPage.countItemsInCart();
        Assert.assertTrue(rowsBeforeAuth >= 1, "No rows detected in cart");

        // Login. If login fails (account doesn't exist), sign up with SAME email/pass and continue
        homePage.clickSignupLogin();
        String email = "loginpersist@example.com";
        String pass  = "persist123";

        // Try login first
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(pass);
        loginPage.clickLogin();

        // If not logged in, register the same credentials
        if (!homePage.isLoggedInAsVisible()) {
            // Fill Signup form
            loginPage.enterSignupName("Cart User");
            loginPage.enterSignupEmail(email);
            loginPage.clickSignup();

            // Complete account info (same password used above)
            Assert.assertTrue(signupPage.isAccountInfoVisible(), "Account info page not visible");
            signupPage.selectTitle("Mr");
            signupPage.enterPassword(pass);
            signupPage.selectDateOfBirth("10", "5", "1995");
            // Optional checks (kept consistent with earlier tests)
            signupPage.checkNewsletter();
            signupPage.checkOffers();
            signupPage.enterAddressInfo(
                    "Cart", "User", "Cart Co",
                    "Street 1", "Apt 2",
                    "United States", "CA", "Los Angeles",
                    "90001", "1234567890"
            );
            signupPage.clickCreateAccount();

            Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "Account creation failed");
            registrationPage.clickContinue();
            Assert.assertTrue(homePage.isLoggedInAsVisible(), "'Logged in as' not visible after signup");
        }

        // Go back to Cart
        homePage.clickCart();

        // Verify cart still shows items after login/signup (counts can merge; presence is enough)
        Assert.assertTrue(cartPage.isAnyCartRowPresent(), "Cart became empty after authentication");
        int rowsAfterAuth = cartPage.countItemsInCart();
        Assert.assertTrue(rowsAfterAuth >= 1, "No cart rows after login/signup");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}
